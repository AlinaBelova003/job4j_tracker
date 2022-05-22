package ru.job4j.collection;

import java.util.*;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDeskByName().thenComparing(new JobDesByPriority()));

        Comparator<Job> comb = new JobDeskByNameLn()
                .thenComparing(new JobDeskByName())
                .thenComparing(new JobDesByPriority());
        Collections.sort(jobs, comb);

    }
}
