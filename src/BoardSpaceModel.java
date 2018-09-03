import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardSpaceModel extends JPanel {
    private boolean isOccupied;


    public BoardSpaceModel() {
        isOccupied = false;
    }

    public JPanel createAndDrawBoardSpace(int size) {
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
}
