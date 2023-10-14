package ru.job4j.odd.srp.hr;

import org.junit.jupiter.api.Test;
import ru.job4j.odd.srp.model.Employee;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SortSalaryTest {

    @Test
    public void whenSortReverseTrue() {
        Calendar calendar = Calendar.getInstance();
        List<Employee> employeeList = List.of(new Employee("Ivan", calendar, calendar, 30000),
                new Employee("Alex", calendar, calendar, 25000),
                new Employee("Vladimir", calendar, calendar, 40000));
        List<Employee> result = SortSalary.sortSalaryReversed(employeeList);
        List<Employee> expected = List.of(new Employee("Alex", calendar, calendar, 25000),
                new Employee("Ivan", calendar, calendar, 30000),
                new Employee("Vladimir", calendar, calendar, 40000));
        assertThat(result).isEqualTo(expected);
    }

}