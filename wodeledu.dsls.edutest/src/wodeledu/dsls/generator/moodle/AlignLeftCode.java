package wodeledu.dsls.generator.moodle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class AlignLeftCode {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java AlignLeftCode <inputFile> <outputFile>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        try {
            String content = Files.readString(inputPath, StandardCharsets.UTF_8);
            String converted = alignFullyLeft(content);
            Files.writeString(outputPath, converted, StandardCharsets.UTF_8);
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String alignFullyLeft(String text) {
        String[] lines = text.split("\\R", -1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            // Remove all spaces and tabs from the left side
            String convertedLine = lines[i].replaceFirst("^[\\t ]+", "");
            result.append(convertedLine);

            if (i < lines.length - 1) {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}