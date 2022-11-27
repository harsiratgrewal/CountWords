import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        String inputFileName = "words.txt";
        String outputFileName = "words_count.txt";
        if (args.length > 1) {
            inputFileName = args[0];
            outputFileName = args[1];
        } else if (args.length > 0) {
            inputFileName = args[0];
        }

        Map<String, Integer> wordCount = new TreeMap<>();
        try (
                FileReader fileReader = new FileReader(inputFileName);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(outputFileName);
                BufferedWriter writer = new BufferedWriter(fileWriter);) {
            String line, word;
            while ((line = reader.readLine()) != null) {
                word = line.trim().toLowerCase();
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }

    }
}
