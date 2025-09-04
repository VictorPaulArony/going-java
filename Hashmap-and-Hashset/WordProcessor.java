import java.util.*;
import java.util.logging.Logger;

public class WordProcessor {
    private static final Logger logger = Logger.getLogger(WordProcessor.class.getName());

    // method to count word frequencies using Hashmap
    public static Map<String, Integer> getFrequentWord(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    // method to get unique wordd using Hashset
    public static Set<String> getUniqueWords(String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }

    // main method to compare and print results
    public static void main(String[] args) {
        String[] words = { "mama", "baba", "kaka", "dudu",
                "mama", "kaka", "baba", "kuku" };

        Map<String, Integer> frequencies = getFrequentWord(words);
        Set<String> uniqueWords = getUniqueWords(words);

        logger.info(() -> "Word Frequencies (HashMap): " + frequencies);
        logger.info(() -> "Unique Words (HashSet): " + uniqueWords);
    }
}
