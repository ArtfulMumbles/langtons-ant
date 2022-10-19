import java.awt.Graphics2D;

public class LangtonsAnt {

    private final int BOARD_SIZE = 160;
    private final String RULES = "RLRL";
    private final int NUM_ANTS = 20;

    private int screenX;
    private int screenY;
    private Board board;

    public LangtonsAnt(int screenX, int screenY) {

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

    public void addAnt(int x, int y) {
        board.addAnt(x / (screenX / BOARD_SIZE), y / (screenY / BOARD_SIZE));
    }

}
