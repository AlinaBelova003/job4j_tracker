package ru.job4j.odd.srp;

import java.util.List;

public interface SequenceGenerator<T> {

    List<T> generator(int size);

}
