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

    public void setScore(int s) {
        score = s;
    }

    public int getScore() {
        return score;
    }

    public void setWinStatus(boolean outcome) {
        hasWon = outcome;
    }

    public boolean getWinStatus() {
        return hasWon;
    }

    public void setActiveStatus(boolean turn) {
        isActive = turn;
    }

    public boolean getActiveStatus() {
        return isActive;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }

    public String toString() {
        return "Player " + getPlayerLetter();
    }

}
