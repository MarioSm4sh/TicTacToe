import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardSpacePanel extends JPanel {
    private boolean isOccupied;
    private int row;
    private int col;
    private Player playerOccupyingSpace;
    private boolean enabled;
    BufferedImage playerImage;


    public BoardSpacePanel(int r, int c) {
        row = r;
        col = c;
        playerOccupyingSpace = null;
        isOccupied = false;
        enabled = true;
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

    private void setPlayerImage(BufferedImage image) {
        playerImage = image;
    }

    public void setPlayerOccupyingSpace(Player player) {
        playerOccupyingSpace = player;
    }

    public Player getPlayerOccupyingSpace() {
        return playerOccupyingSpace;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setIsOccupied(boolean status) {
        isOccupied = status;
    }
}
