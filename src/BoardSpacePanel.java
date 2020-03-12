import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardSpacePanel extends JPanel {
    private boolean isOccupied;
    private Player playerOccupyingSpace;


    public BoardSpacePanel() {
        playerOccupyingSpace = null;
        isOccupied = false;
        setMinimumSize(new Dimension(100, 100));
        setMaximumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.getPlayerOccupyingSpace() != null) {
            if(this.getPlayerOccupyingSpace().getPlayerLetter() == 'X') {
                g.setColor(Color.RED);
                g.drawLine(0, 0, this.getWidth(), this.getHeight());
                g.drawLine(this.getWidth(), 0, 0, this.getHeight());
            } else {
                g.setColor(Color.BLUE);
                g.drawOval(0, 0, this.getWidth(), this.getHeight());
            }
        }
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

    public boolean getIsOccupied() {
        return isOccupied;
    }
}
