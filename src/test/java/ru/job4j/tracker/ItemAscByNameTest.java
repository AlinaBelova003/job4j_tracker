package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {
    @Test
    public void whenItemToAsc() {
        List<Item> items = Arrays.asList(
                new Item("Alina"),
                new Item("Petr"),
                new Item("Stas")
        );
        Comparator comparators = new ItemAscByName();
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Alina"),
                new Item("Petr"),
                new Item("Stas")
        );
        Assert.assertThat(items.toString(), is(expected.toString()));
    }

    @Test
    public void whenItemToDes() {
        List<Item> items = Arrays.asList(
                new Item("Alina"),
                new Item("Petr"),
                new Item("Stas")
        );
        Comparator comparators = new ItemAscByName();
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Stas"),
                new Item("Petr"),
                new Item("Alina")
        );
        Assert.assertThat(items.toString(), is(expected.toString()));
    }

}