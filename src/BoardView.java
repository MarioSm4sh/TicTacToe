import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardView extends JFrame {

    public BoardView() {

    }

    private static JPanel drawBoard() {
        BoardSpaceModel[][] board = new BoardSpaceModel[3][3];
        JPanel contentPanel = new JPanel(new GridLayout(3, 3));


        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                board[r][c] = new BoardSpaceModel();
                contentPanel.add(board[r][c].createAndDrawBoardSpace(100));
            }
        }
        return contentPanel;
    }

    public void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3));

        frame.setContentPane(BoardView.drawBoard());
        frame.pack();
        frame.setVisible(true);
    }

}
