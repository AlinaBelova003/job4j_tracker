package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item[] findAll() {
        return items.toArray(new Item[items.size()]);
    }

    public Item[] findByName(String kay) {
        List<Item> result = new ArrayList<>();
        int count = 0;
        for (Item i : items) {
            if (i.getName().contains(kay)) {
                result.add(i);
                count++;
            }
        }
        return items.toArray(new Item[items.size()]);
    }

    public Item findById(int id) {
        int index = items.indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item.getId();
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.add(item);
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = items.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items.remove(findById(id));
            size--;
        }
        return rsl;
    }
}