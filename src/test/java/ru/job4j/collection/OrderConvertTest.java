package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOder() {
        List<Order> order = new ArrayList<>();
        order.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(order);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenSingleOderDuplicate() {
        List<Order> order = new ArrayList<>();
        order.add(new Order("3sfe", "Dress"));
        order.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(order);
        assertThat(map.size(), is(1));
    }
}