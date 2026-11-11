public class WordleGameTest {
    public static void main(String[] args) {
        assertStatuses(
            WordleGame.scoreGuess("silly", "silky"),
            "🟩🟩🟩⬛🟩"
        );
        assertStatuses(
            WordleGame.scoreGuess("array", "cigar"),
            "⬛🟨⬛🟩⬛"
        );
    }

    private static void assertStatuses(String[] statuses, String expected) {
        String actual = String.join("", statuses);
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
}
