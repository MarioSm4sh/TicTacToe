import javax.swing.*;
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
                boardSpace.revalidate();
                boardSpace.repaint();
                boardSpace.removeMouseListener(this);
                checkForWin();
                if (boardModel.getPlayer1().getWinStatus() || boardModel.getPlayer2().getWinStatus()) {
                    int response = JOptionPane.showConfirmDialog(null,boardModel.getActivePlayer() + " Wins! Would you like to continue?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(response == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    } else {
                        resetGame();
                    }
                }
                boardModel.switchTurns();
            }
        });
    }

    private void resetGame() {
        boardView.dispose();
        String[] args = {};
        TicTacToe.main(args);
    }

    private void checkForWin() {
        BoardSpacePanel[][] board = boardModel.getBoard();
        Player player1 = boardModel.getPlayer1();
        Player player2 = boardModel.getPlayer2();

        //Horizontal
        for (int r = 0; r < board.length; r++) {
            if (checkForWinHelper(board[r], player1, player2)) {
                return;
            }
        }

        //Vertical
        for (int c = 0; c < board.length; c++) {
            BoardSpacePanel[] verticalSpaces = new BoardSpacePanel[3];
            for (int r = 0; r < board[c].length; r++) {
                verticalSpaces[r] = board[r][c];
            }
            if(checkForWinHelper(verticalSpaces, player1, player2)) {
                return;
            }
        }

        //Diagonal
        if(board[0][0].getPlayerOccupyingSpace() == player1 && board[1][1].getPlayerOccupyingSpace() == player1 && board[2][2].getPlayerOccupyingSpace() == player1) {
            player1.setWinStatus(true);
            System.out.println("Player 1 Wins3!");
            return;
        } else if(board[0][0].getPlayerOccupyingSpace() == player2 && board[1][1].getPlayerOccupyingSpace() == player2 && board[2][2].getPlayerOccupyingSpace() == player2) {
            player2.setWinStatus(true);
            System.out.println("Player 2 Wins3!");
            return;
        } else if(board[0][2].getPlayerOccupyingSpace() == player1 && board[1][1].getPlayerOccupyingSpace() == player1 && board[2][0].getPlayerOccupyingSpace() == player1) {
            player1.setWinStatus(true);
            System.out.println("Player 1 Wins3!");
            return;
        } else if(board[0][2].getPlayerOccupyingSpace() == player2 && board[1][1].getPlayerOccupyingSpace() == player2 && board[2][0].getPlayerOccupyingSpace() == player2) {
            player2.setWinStatus(true);
            System.out.println("Player 2 Wins3!");
            return;
        }
    }

    private boolean checkForWinHelper(BoardSpacePanel[] setOfBoardSpaces, Player player1, Player player2) {

        for(int c = 0; c < setOfBoardSpaces.length; c++) {
            if(setOfBoardSpaces[c].getPlayerOccupyingSpace() == null) {
                player1.setScore(0);
                player2.setScore(0);
                return false;
            } else {
                if (setOfBoardSpaces[c].getPlayerOccupyingSpace() == player1) {
                    player1.incrementScore();
                } else {
                    player2.incrementScore();
                }
            }
        }
        if(player1.getScore() == 3) {
            player1.setWinStatus(true);
            System.out.println("Player 1 Wins!");
            return true;
        } else if(player2.getScore() == 3) {
            player2.setWinStatus(true);
            System.out.println("Player 2 Wins!");
            return true;
        }
        player1.setScore(0);
        player2.setScore(0);
        return false;
    }

}   //End of Class