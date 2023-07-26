package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    /**
     * Проверяем наличие объекта в кэше и если его нет, то загружаем.
     * Получаем SoftReference ссылку по значению ключа
     * Если ссылка есть в памяти, то по мягкой ссылки получаем значение и обновляем данные в кэши
     * Если нет, то загружаем и проверяем, если значение не пустое, то добавляем в кэш
     * @param key имя файла
     * @return внутренние содержимое файла
     */
    public final V get(K key) {
        SoftReference<V> softReference = cache.get(key);
        V value = (softReference != null) ? softReference.get() : null;
        if (value == null) {
            value = load(key);
        } else {
            put(key, value);
        }
        return value;
    }

    protected abstract V load(K key);
}

