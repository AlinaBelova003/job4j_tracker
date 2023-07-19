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
     * @param key имя файла
     * @return значение объекта или создаем новый объект
     */
    public final V get(K key) {
        SoftReference<V> softReference = cache.get(key);
        if (softReference != null) {
            V value = softReference.get();
            put(key, value);
            return value;
        }
        return load(key);
    }

    protected abstract V load(K key);
}

