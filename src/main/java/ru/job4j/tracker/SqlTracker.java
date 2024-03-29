package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс SqlTracker будет подключаться к базе данных, создавать в ней записи, редактировать, читать и удалять.
 * Для того чтобы мы могли подключаться к базе данных, нам нужно вынести настройки в файл app.properties
 */
public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Добавление записи
     * Для записи точного времени, которое есть в том регионе, где идет запись используем setTimestamp()
     * @param item объект записи
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement("insert into Items (name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

      @Override
    public List<Item> findAll() {
        List<Item> item = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemName = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("Select * from items where name = ?")) {
            statement.setString(1, key);
           try (ResultSet resultSet = statement.executeQuery()) {
               while (resultSet.next()) {
                   itemName.add(new Item(
                           resultSet.getString("name")

                   ));
               }
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return itemName;
    }

    @Override
    public Item findById(int id) {
       Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement("Select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    /**
     * Properties постоянный набор свойств. Свойства можно сохранить в поток или загрузить из потока.
     * Чтение из БД tracker будет производиться из класса настроек
     */
    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        SqlTracker tracker = new SqlTracker();
        Item  item = new Item(1, "Alina", LocalDateTime.now());
        Item item1 = new Item(2, "Vera", LocalDateTime.now());
        Item item2 = new Item(3, "Vlad", LocalDateTime.now());
        System.out.println(tracker.add(item));
        System.out.println(tracker.add(item1));
        System.out.println(tracker.add(item2));
        System.out.println(tracker.replace(2, item));
        System.out.println(tracker.findAll());
        System.out.println(tracker.findByName("Vlad"));
        System.out.println(tracker.findById(2));
        System.out.println(tracker.delete(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SqlTracker tracker = (SqlTracker) o;
        return Objects.equals(cn, tracker.cn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cn);
    }
}
