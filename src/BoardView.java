import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {
    private JPanel contentPanel;

    private BoardModel boardModel;
    public BoardView(BoardModel model) {
        contentPanel = new JPanel(new GridLayout(3, 3));
        boardModel = model;
        drawBoard();
        drawWindow();
    }

    private void drawBoard() {
        //JPanel contentPanel = new JPanel(new GridLayout(3, 3));
        for(int r = 0;  r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                contentPanel.add(boardModel.getBoard()[r][c]);
            }
        }
    }

    private void drawWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        frame.add(contentPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
