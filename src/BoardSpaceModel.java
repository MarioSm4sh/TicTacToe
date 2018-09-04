import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardSpaceModel extends JPanel {
    private boolean isOccupied;
    JPanel boardSpace;

    public BoardSpaceModel() {
        isOccupied = false;
        boardSpace = new JPanel();
        boardSpace.setMinimumSize(new Dimension(100, 100));
        boardSpace.setMaximumSize(new Dimension(100, 100));
        boardSpace.setPreferredSize(new Dimension(100, 100));
        boardSpace.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getBoardSpace() {
        return boardSpace;
    }

    public void setIsOccupied(boolean status) {
        isOccupied = status;
    }
}
