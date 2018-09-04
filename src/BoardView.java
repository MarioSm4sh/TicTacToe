import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    private BoardModel boardModel;
    public BoardView(BoardModel model) {
        boardModel = model;
        this.drawBoardAndWindow();
    }

    private void drawBoardAndWindow() {
        JPanel contentPanel = new JPanel(new GridLayout(3, 3));

        for(int r = 0;  r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                contentPanel.add(boardModel.getBoard()[r][c].getBoardSpace());
            }
        }

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3));

        frame.setContentPane(contentPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void drawX(JPanel space) {
//        JPanel boardSpace = new JPanel() {
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                //g.drawLine(10, 10, 20, 35);
//                g.setColor(Color.RED);
//                g.fillRect(10, 10, 50, 50);
//            }
//        };
//        return boardSpace;
//         return new BoardSpaceModel() {
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.setColor(Color.BLUE);
//                g.fillRect(10, 10, 50, 50);
//            }
//        };
//        if(space instanceof JPanel) {
////            Graphics g = space.getGraphics();
////            g.setColor(Color.BLUE);
////            g.fillRect(10, 10, 50, 50);
//
//        }
        
    }

    public void drawO(JPanel boardSpace) {

    }
}
