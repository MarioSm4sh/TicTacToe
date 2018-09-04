import javax.swing.*;
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

    private void addMouseListenersToBoardSpacesHelper(BoardSpaceModel boardSpace) {
        JPanel space = boardSpace.getBoardSpace();
        space.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                if(boardModel.getActivePlayer().getPlayerLetter() == 'X') {
//                    boardView.drawX(space);
//                } else {
//                    boardView.drawO(space);
//                }
            }
        });
    }



}
