import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardView extends JFrame {

    public BoardView() {

    }

    private static JPanel drawBoard() {
        JPanel contentPanel = new JPanel(new GridLayout(3, 3));

        for(int c = 0; c < 9; c++) {
            contentPanel.add(BoardView.DrawBoardSpace(100));
        }
        return contentPanel;
    }

    private static JPanel DrawBoardSpace(int size) {
        JPanel boardSpace = new JPanel();
        boardSpace.setMinimumSize(new Dimension(size, size));
        boardSpace.setMaximumSize(new Dimension(size, size));
        boardSpace.setPreferredSize(new Dimension(size, size));
        boardSpace.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        boardSpace.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boardSpace.setBackground(Color.RED);
            }
        });
        return boardSpace;
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
