package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
       Comparator<Attachment> comparator =  (left, right) -> Integer.compare(left.getSize(), right.getSize());
       Comparator<Attachment> comparator1 = (left, right) -> left.getName().compareTo(right.getName());
       Comparator<String> comparator2 = (left, right) -> Integer.compare(left.length(), right.length());
    }
}
