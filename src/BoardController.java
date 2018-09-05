import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardController {

    private BoardModel boardModel;
    private BoardView boardView;

    public BoardController(BoardModel model, BoardView view) {
        boardModel = model;
        boardView = view;
        this.addMouseListenersToBoardSpaces();
    }

    private void addMouseListenersToBoardSpaces() {
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                this.addMouseListenersToBoardSpacesHelper(boardModel.getBoard()[r][c]);
            }
        }
    }

    private void addMouseListenersToBoardSpacesHelper(BoardSpacePanel boardSpace) {
        //JPanel space = boardSpace.getBoardSpace();
        boardSpace.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boardSpace.setIsOccupied(true);
                boardSpace.setPlayerOccupyingSpace(boardModel.getActivePlayer());
                boardModel.switchTurns();
                boardSpace.revalidate();
                //boardSpace.setBackground(Color.RED);
                boardSpace.repaint();
                System.out.println(Integer.toString(boardSpace.getRow()) + ", " +  Integer.toString(boardSpace.getCol()));
//                if(boardModel.getActivePlayer().getPlayerLetter() == 'X') {
//                    boardView.drawX(space);
//                } else {
//                    boardView.drawO(space);
//                }
            }
        });
    }



}
