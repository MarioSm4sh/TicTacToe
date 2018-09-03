import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardView extends JFrame {

    private BoardModel boardModel;
    public BoardView(BoardModel model) {
        boardModel = model;
        this.createAndShowGUI(boardModel);
    }

    private static JPanel drawBoard(BoardSpaceModel[][] board) {
        JPanel contentPanel = new JPanel(new GridLayout(3, 3));

        for(int r = 0;  r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                contentPanel.add(board[r][c].drawAndAddMouseListenersToBoardSpaces(100));
            }
        }
        return contentPanel;
    }

    private void createAndShowGUI(BoardModel model) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3));

        frame.setContentPane(BoardView.drawBoard(model.getBoard()));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
