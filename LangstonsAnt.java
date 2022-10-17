import java.awt.Graphics2D;

public class LangstonsAnt {

    private final int BOARD_SIZE = 100;
    private final String RULES = "RLLR";
    private final int NUM_ANTS = 2;

    private int screenX;
    private int screenY;
    private Board board;

    public LangstonsAnt(int screenX, int screenY) {

        board = new Board(BOARD_SIZE, RULES, NUM_ANTS);

        this.screenX = screenX;
        this.screenY = screenY;
        
    }

    public void paint(Graphics2D g) {
        board.paint(g, screenX, screenY);
    }

    public void update() throws Exception {
        board.update();
    }

}
