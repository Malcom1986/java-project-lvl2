package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Parameters (description = "Path to first file")
    private String filepath1;

    @Parameters(description = "Path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "Output format", defaultValue = "stylish")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.gendiff(filepath1, filepath2, format));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
