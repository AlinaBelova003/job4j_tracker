package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {
    @Test
    public void whenItem() {
        List<Item> items = new ArrayList<>(new Item("Alina"), new Item("Petr"), new Item("Stas"));
        Comparator comparators = new ItemAscByName();
        Collections.sort(items,comparators);
        List<Item> expected = ArrayList<> (new Item("Alina"), new Item("Stas"), new Item("Petr"));
        assertThat(items.toString(), is(expected.toString()));
    }

}