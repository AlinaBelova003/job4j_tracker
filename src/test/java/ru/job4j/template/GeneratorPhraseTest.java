package ru.job4j.template;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
@Disabled
class GeneratorPhraseTest {
    @Test
    public void whenResultKeyTrueThenGetPhrase() {
        Generator generator = new GeneratorPhrase();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = generator.produce(template, map);
        assertThat(result).isEqualTo("I am Petr Arsntev, Who are you?");
    }

    @Test
    public void whenKeyNotGeneratorThenGetException() {
        Generator generator = new GeneratorPhrase();
        String template = "I am ${name}, I am ${45} old";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        String result = generator.produce(template, map);
        Assertions.assertThat(result).isInstanceOf(IllegalArgumentException.class);

    }

        @Test
        public void testInvalidTemplate() {
        Generator generator = new GeneratorPhrase();
            String template = "I am a ${name, Who are ${subject}?";
            Map<String, String> map = new HashMap<>();
            map.put("name", "Petr Arsentev");
            map.put("subject", "you");
            String result = generator.produce(template, map);
            Assertions.assertThat(result).isInstanceOf(IllegalArgumentException.class);
        }
}