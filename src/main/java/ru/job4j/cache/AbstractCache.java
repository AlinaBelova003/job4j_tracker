package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        cache.put(key, softReference);
    }

    /**
     * Проверяем наличие объекта в кэше и если его нет, то загружаем.
     * Получаем SoftReference ссылку по значению ключа
     * Если ссылка есть в памяти, то по мягкой ссылки получаем значение и обновляем данные в кэши
     * Если нет, то загружаем и проверяем, если значение не пустое, то добавляем в кэш
     * @param key имя файла
     */
    public final V get(K key) {
        if (cache.containsKey(key)) {
            SoftReference<V> softReference = cache.get(key);
            V value = softReference.get();
            put(key, value);
        } else {
            V file = load(key);
            if (file != null) {
                put(key, file);
            }
        }
        return ???;
    }

    protected abstract V load(K key);
}

