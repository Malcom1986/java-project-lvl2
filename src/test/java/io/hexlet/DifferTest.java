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
    private static String basePath = "src/test/resources/fixtures/";

    @BeforeAll
    static void beforeAll() throws Exception {
        expectedStylish = Files.readString(getFixturePath("stylish"));
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

    private static Path getFixturePath(String fileName) {
        return Paths.get(basePath + fileName).toAbsolutePath().normalize();
    }


}
