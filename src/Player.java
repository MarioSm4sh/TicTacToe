public class Player {
    private static final int INITIAL_SCORE = 0;
    private int score = INITIAL_SCORE;
    private char playerLetter;
    private boolean hasWon = false;

    public Player(char letter) {
        playerLetter = letter;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void setWinStatus(boolean outcome) {
        hasWon = outcome;
    }
}
