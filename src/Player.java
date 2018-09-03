public class Player {
    private static final int INITIAL_SCORE = 0;
    private int score = INITIAL_SCORE;
    private char playerLetter;
    private boolean hasWon = false;
    private boolean isActive;

    public Player(char letter, boolean activeStatus) {
        playerLetter = letter;
        isActive = activeStatus;
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

    public void setActiveStatus(boolean turn) {
        isActive = turn;
    }

}
