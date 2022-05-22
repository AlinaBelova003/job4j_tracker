package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemAscByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobAskTest {

    @Test
    public void whenJobToAscName() {
        List<Job> jobs = Arrays.asList(
                new Job("Alina", 2),
                new Job("Veronica", 1),
                new Job("Sasha", 3)
        );
        Comparator comparators = new JobAskByName();
        Collections.sort(jobs, new JobAskByName());
        List<Job> expected = Arrays.asList(
                new Job("Alina", 2),
                new Job("Sasha", 3),
                new Job("Veronica", 1)
        );
        Assert.assertThat(jobs.toString(), is(expected.toString()));
    }

    @Test
    public void whenJobToAskPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Alina", 2),
                new Job("Veronica", 1),
                new Job("Sasha", 3)
        );
        Comparator comparators = new JobAskByPriority();
        Collections.sort(jobs, new JobAskByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Veronica", 1),
                new Job("Alina", 2),
                new Job("Sasha", 3)
        );
        Assert.assertThat(jobs.toString(), is(expected.toString()));
    }

    @Test
    public void whenJobToDeskPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Alina", 2),
                new Job("Veronica", 1),
                new Job("Sasha", 3)
        );
        Comparator comparators = new JobDesByPriority();
        Collections.sort(jobs, new JobDesByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Sasha", 3),
                new Job("Alina", 2),
                new Job("Veronica", 1)
        );
        Assert.assertThat(jobs.toString(), is(expected.toString()));
    }

    @Test
    public void whenJobToDeskName() {
        List<Job> jobs = Arrays.asList(
                new Job("Alina", 2),
                new Job("Veronica", 1),
                new Job("Sasha", 3)
        );
        Comparator comparators = new JobDeskByName();
        Collections.sort(jobs, new JobDeskByName());
        List<Job> expected = Arrays.asList(
                new Job("Veronica", 1),
                new Job("Sasha", 3),
                new Job("Alina", 2)
        );
        Assert.assertThat(jobs.toString(), is(expected.toString()));
    }
}