package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        var data1 = getFileData(filepath1);
        var data2 = getFileData(filepath2);
        var diff = Tree.buildTree(data1, data2);

        return Formatter.format(diff, format);
    }

    private static Map<String, Object> getFileData(String filepath) throws Exception {
        var absolutePath = Paths.get(filepath).toAbsolutePath().normalize();
        var content = Files.readString(absolutePath);
        var fileType = FilenameUtils.getExtension(filepath);
        return Parser.parse(content);
    }
}
