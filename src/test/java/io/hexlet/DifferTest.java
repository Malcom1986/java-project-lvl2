package io.hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;
    private static String basePath = "src/test/resources/fixtures/";

    @BeforeAll
    static void beforeAll() throws Exception {
        expectedStylish = Files.readString(getFixturePath("stylish"));
        expectedPlain = Files.readString(getFixturePath("plain"));
        expectedJson = Files.readString(getFixturePath("json"));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get(basePath + fileName).toAbsolutePath().normalize();
    }

    @Test
    void testJsonStylish() throws Exception {
        var actual = Differ.generate(
                basePath + "file1.json",
                basePath + "file2.json",
                "stylish"
        );
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    void testYamlStylish() throws  Exception {
        var actual = Differ.generate(
                basePath + "file1.yml",
                basePath + "file2.yml",
                "stylish"
        );

        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    void testJsonPlain() throws Exception {
        var actual = Differ.generate(
                basePath + "file1.json",
                basePath + "file2.json",
                "plain"
        );
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    void testYamlPlain() throws  Exception {
        var actual = Differ.generate(
                basePath + "file1.yml",
                basePath + "file2.yml",
                "plain"
        );

        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    void testYamlJson() throws  Exception {
        var actual = Differ.generate(
                basePath + "file1.yml",
                basePath + "file2.yml",
                "json"
        );

        assertThat(actual).isEqualTo(expectedJson);
    }

    @Test
    void testJsonJson() throws Exception {
        var actual = Differ.generate(
                basePath + "file1.json",
                basePath + "file2.json",
                "json"
        );
        assertThat(actual).isEqualTo(expectedJson);
    }
}
