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
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.format("%s%s%s", cacheDir, File.separator, key)))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
