package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemNew = new Item[size];
        int size = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                itemNew[size] = item;
                size++;
        }

    }
        itemNew = Arrays.copyOf(itemNew, size);
        for (int index = 0; index < itemNew.length; index++) {
            System.out.println(itemNew[index]);
        }
            return itemNew;
    }

    public Item findByName(String kay) {
        Item result = null;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item.getName().equals(kay)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}