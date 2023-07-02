package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cacheDir;

    public DirFileCache(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    @Override
    protected String load(String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(key))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("c:\\data\\");
        String fileContent = dirFileCache.get("Names.txt");
        System.out.println(fileContent);

    }
}
