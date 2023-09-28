package ru.job4j.odd.srp.singleton;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Singleton — подразумевает, что помимо своих основных обязанностей класс занимается еще
 * и контролированием количества своих экземпляров, чем нарушает Single Responsibility Principle.
 */
public class Singleton {
    private static Singleton instance;
    private FileWriter fileWrite;

    public Singleton() {
        try {
            fileWrite = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
           instance = new Singleton();
        }
        return instance;
    }

    public void log(String message) {
        try {
            fileWrite.write(message);
            fileWrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
