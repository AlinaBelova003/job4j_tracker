package ru.job4j.cache;

import java.io.*;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    /**
     * путь к директории
     */
    private final String cacheDir;

    public DirFileCache(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    /**
     * Чтение файла и сбор в строку
     * @param key имя файла
     * @return текст из файла
     */
    @Override
    protected String load(String key) {
        System.out.println("Read file:" + key);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.format("%s%s%s", cacheDir, File.separator, key)))) {
            System.out.println("Файл есть");
            while (reader.ready()) {
                stringBuilder.append(String.format("%s%s", reader.readLine(), File.separator));
            }
        } catch (IOException e) {
            System.out.println("Файла нет");
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
