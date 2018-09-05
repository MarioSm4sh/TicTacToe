public class BoardModel {

    private Player player1;
    private Player player2;
    private BoardSpacePanel[][] board;


    public BoardModel(Player p1, Player p2) {
        board = new BoardSpacePanel[3][3];
        player1 = p1;
        player2 = p2;

        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                board[r][c] = new BoardSpacePanel(r, c);
            }
        }
    }

    public BoardSpacePanel[][] getBoard() {
        return board;
    }

    public Player getActivePlayer() {
        if(player1.getActiveStatus()) {
            return player1;
        }
        return player2;
    }

    public void switchTurns() {
        if(player1.getActiveStatus()) {
            player1.setActiveStatus(false);
            player2.setActiveStatus(true);
        } else if(player2.getActiveStatus()) {
            player2.setActiveStatus(false);
            player1.setActiveStatus(true);
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String toString() {
        return "player: " + getActivePlayer();
    }

}
