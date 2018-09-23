import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardController {

    private BoardModel boardModel;
    private BoardView boardView;

    public BoardController(BoardModel model, BoardView view) {
        boardModel = model;
        boardView = view;
        this.addMouseListenersToBoardSpaces();
    }

    private void addMouseListenersToBoardSpaces() {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                this.addMouseListenersToBoardSpacesHelper(boardModel.getBoard()[r][c]);
            }
        }
    }

    private void addMouseListenersToBoardSpacesHelper(BoardSpacePanel boardSpace) {
        boardSpace.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boardSpace.setIsOccupied(true);
                boardSpace.setPlayerOccupyingSpace(boardModel.getActivePlayer());
                boardModel.switchTurns();
                boardSpace.revalidate();
                boardSpace.repaint();
                boardSpace.removeMouseListener(this);
                checkForWin();
            }
        });
    }

    private void checkForWin() {
        BoardSpacePanel[][] board = boardModel.getBoard();
        Player player1 = boardModel.getPlayer1();
        Player player2 = boardModel.getPlayer2();

        //For checking each horizontal row
        for(int r = 0; r < board.length; r++) {
            if(board[r][0].getPlayerOccupyingSpace() == null || board[r][1].getPlayerOccupyingSpace() == null || board[r][2].getPlayerOccupyingSpace() == null) {
                continue;
            }
            for(int c = 0; c < board[r].length; c++) {
                if(board[r][c].getPlayerOccupyingSpace() == player1) {
                    player1.incrementScore();
                } else if(board[r][c].getPlayerOccupyingSpace() == player2) {
                    player2.incrementScore();
                }
            }
            if(player1.getScore() == 3) {
                player1.setWinStatus(true);
                System.out.println("Player 1 Wins1!");
                return;
            } else if(player2.getScore() == 3) {
                player2.setWinStatus(true);
                System.out.println("Player 2 Wins1!");
                return;
            }
            player1.setScore(0);
            player2.setScore(0);
        }

        //For checking each vertical column
        for(int c = 0; c < board.length; c++) {
            if(board[0][c].getPlayerOccupyingSpace() == null || board[1][c].getPlayerOccupyingSpace() == null || board[2][c].getPlayerOccupyingSpace() == null) {
                continue;
            }
            for(int r = 0; r < board[c].length; r++) {
                if(board[c][r].getPlayerOccupyingSpace() == player1) {
                    player1.incrementScore();
                } else if(board[c][r].getPlayerOccupyingSpace() == player2) {
                    player2.incrementScore();
                }
            }
            if(player1.getScore() == 3) {
                player1.setWinStatus(true);
                System.out.println("Player 1 Wins2!");
                return;
            } else if(player2.getScore() == 3) {
                player2.setWinStatus(true);
                System.out.println("Player 2 Wins2!");
                return;
            }
            player1.setScore(0);
            player2.setScore(0);
        }

        //for checking diagonals
        if(board[0][0].getPlayerOccupyingSpace() == player1 && board[1][1].getPlayerOccupyingSpace() == player1 && board[2][2].getPlayerOccupyingSpace() == player1) {
            player1.setWinStatus(true);
            System.out.println("Player 1 Wins3!");
            return;
        } else if(board[0][0].getPlayerOccupyingSpace() == player2 && board[1][1].getPlayerOccupyingSpace() == player2 && board[2][2].getPlayerOccupyingSpace() == player2) {
            player2.setWinStatus(true);
            System.out.println("Player 2 Wins3!");
            return;
        }
    }

}
