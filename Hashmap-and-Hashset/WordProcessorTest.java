import java.util.*;

public class WordProcessorTest {

    public static void main(String[] args) {
        testGetFrequentWord();
        testGetUniqueWords();
        System.out.println("All tests passed.");
    }

    public static void testGetFrequentWord() {
        String[] words = { "mama", "baba", "kaka", "dudu",
                "mama", "kaka", "baba", "kuku" };

        Map<String, Integer> expected = new HashMap<>();
        expected.put("baba", 2);
        expected.put("kuku", 1);
        expected.put("mama", 2);
        expected.put("dudu", 1);
        expected.put("kaka", 2);

        Map<String, Integer> result = WordProcessor.getFrequentWord(words);

        assert result.equals(expected) : "Test failed: " + result;
    }

    public static void testGetUniqueWords() {
        String[] words = { "mama", "baba", "kaka", "dudu",
                "mama", "kaka", "baba", "kuku" };

        Set<String> expected = new HashSet<>(Arrays.asList("baba", "kuku", "mama", "dudu", "kaka"));
        Set<String> result =  WordProcessor.getUniqueWords(words);
        assert expected.equals(result) : "Test failed: " + result;
    }
}
