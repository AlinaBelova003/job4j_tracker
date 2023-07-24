package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес каталога для кеширования");
        String dir = scanner.nextLine();
        AbstractCache<String, String> dirFileCache = new DirFileCache(dir);
        System.out.println("Введите имя файла для кеширования или exit для выхода");
        String fileName = scanner.nextLine();
        while (!"exit".equals(fileName)) {
            System.out.println(dirFileCache.get(fileName));
            System.out.println("Если работа закончена введите exit");
            fileName = scanner.nextLine();

        }
    }
}
