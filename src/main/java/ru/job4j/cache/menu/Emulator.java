package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Emulator {
    private Map<String, String> cache;
    private String cacheDir;

    /**
     * Создаёт объект с пустым кэшем и директорией
     * cache - новый объект, хранит ключ-значение в виде кэша
     * cacheDir - директория для чтения; устанавливается пользователем
     */
    Emulator() {
        cache = new HashMap<>();
        cacheDir = null;
    }

    /**
     * Позволяет пользователю указать кэшированную директорию
     * и если она существует, то теперь будет установлена для кэша
     */
    public void setCacheDirectory(String directory) {
        Path fileDir = Paths.get(directory);
        if (Files.exists(fileDir) && Files.isDirectory(fileDir)) {
            cacheDir = directory;
            System.out.println("Директория найдена и установлена успешна");
        } else {
            System.out.println("Указанная директория не существует или не является директорией.");
        }
    }

    /**
     * Загружает файл по имени директории и пути
     * @param fileName файл, из которого читаем и ключ
     */
    public void loadFile(String fileName) throws IOException {
        String filePath = cacheDir + File.separator + fileName;
        Path file = Paths.get(filePath);
        if (Files.exists(file) && !Files.isDirectory(file)) {
            String fileRead = Files.readString(file);
            cache.put(fileName, fileRead);
            System.out.println("В кэш загружен файл(ключ) и содержимое(значение)");
        } else if (!Files.exists(file)) {
            System.out.println("Загрузить файл");
        }
    }

    /**
     * Получение содержимого файла из кэша
     */
    public void getFile(String fileName) {
        String fileCache = cache.get(fileName);
        if (cache != null) {
            System.out.println("Содержимое файла " + fileName + ": " + fileCache);
        }
    }

    public static void main(String[] args) throws IOException {
       Emulator emulator = new Emulator();
       emulator.setCacheDirectory("data");
       emulator.loadFile("Names.txt");
       emulator.getFile("Names.txt");
    }
}
