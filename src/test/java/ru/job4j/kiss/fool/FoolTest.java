package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.Input;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when3True() {
        String result = Fool.Logic.checkAnswer(3);
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    void when5True() {
        String result = Fool.Logic.checkAnswer(5);
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    void whenFizzBuzz() {
        String result = Fool.Logic.checkAnswer(15);
        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    void whenNumber() {
        String result = Fool.Logic.checkAnswer(1);
        assertThat(result).isEqualTo("1");
    }
}