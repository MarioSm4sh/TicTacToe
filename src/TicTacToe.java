import javax.swing.*;

public class TicTacToe {

    public static void main(String[] args) {
        Player player1 = new Player('X', true);
        Player player2 = new Player('O', false);
        BoardModel model = new BoardModel(player1, player2);
        BoardView view = new BoardView(model);
        BoardController controller = new BoardController(model, view);

    }
}
