import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardSpaceModel extends JPanel {
    private boolean isOccupied;
    private Player playerOccupyingSpace;
    BufferedImage playerImage;
    JPanel boardSpace;


    public BoardSpaceModel() {
        playerOccupyingSpace = null;
        isOccupied = false;
        boardSpace = new JPanel();
        boardSpace.setMinimumSize(new Dimension(100, 100));
        boardSpace.setMaximumSize(new Dimension(100, 100));
        boardSpace.setPreferredSize(new Dimension(100, 100));
        boardSpace.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.getPlayerOccupyingSpace().getPlayerLetter() == 'X') {
            g.setColor(Color.RED);
            g.drawLine(10, 10, 20, 20);
        } else {
            g.setColor(Color.BLUE);
            g.drawLine(10, 10, 20, 20);
        }

    }

    public JPanel getBoardSpace() {
        return boardSpace;
    }

    private void setPlayerImage(BufferedImage image) {
        playerImage = image;
    }

    public void setPlayerOccupyingSpace(Player player) {
        playerOccupyingSpace = player;
    }

    public Player getPlayerOccupyingSpace() {
        return playerOccupyingSpace;
    }

    public void setIsOccupied(boolean status) {
        isOccupied = status;
    }
}
