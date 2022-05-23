package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDeskByName().thenComparing(new JobDesByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameLengthAndDeskPriority() {
        Comparator<Job> cmpNameLnDePriority = new JobDeskByNameLn().thenComparing(new JobDesByPriority());
        int rsl = cmpNameLnDePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

}