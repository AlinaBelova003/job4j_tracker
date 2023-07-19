package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try (BufferedReader reader = new BufferedReader(new FileReader(key))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("C:\\projects\\job4j_tracker\\data");
        String fileContent = dirFileCache.get("%s/%s".formatted(dirFileCache.cacheDir, "Names.txt"));
        System.out.println(fileContent);

    }
}
