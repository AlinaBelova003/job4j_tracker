package ru.job4j.gc.leak;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostTest {

    @Test
    void whenEqualsClass() {
        Post post = new Post(1, "всё похоже", null);
        Post post1 = new Post(1, "всё похоже", null);
        Post post2 = new Post(2, "всё похоже", null);
        assertThat(post).isEqualTo(post);
        assertThat(post).isEqualTo(post1);
        assertThat(post).isNotEqualTo(post2);
    }

}