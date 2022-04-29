package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    public Item indexOf(int id) {
        return null;
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item delete(int id) {
        return null;
    }
}
