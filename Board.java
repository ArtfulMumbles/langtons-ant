import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Board {
    private static Random rand = new Random();

    private int[][] board;
    private int boardSize;
    private Ant ants[];
    private Color[] pallete;
    private String rules;

    public Board(int boardSize, String rules, int numAnts) {
        board = new int[boardSize][boardSize];
        this.boardSize = boardSize;

        ants = new Ant[numAnts];

        for(int i = 0; i < ants.length; i++) {
            ants[i] = new Ant( (i + 1) * boardSize / (numAnts + 1), (i + 1) * boardSize / (numAnts + 1));
        }

        this.rules = rules;

        this.pallete = new Color[rules.length()];
        for(int i = 0; i < pallete.length; i++) {
            pallete[i] = randomColor();
        }
    }

    public void update() throws Exception {
        for(Ant ant : ants) {
            ant.update();
        }
    }
    
    public void paint(Graphics2D g, int screenX, int screenY) {
        paintSquares(g, screenX, screenY);
        for(Ant ant : ants) {
            ant.paint(g, screenX, screenY);
        }
    }

    private void paintSquares(Graphics2D g, int screenX, int screenY) {

        for(int i = 0; i < boardSize; i++) {

            for(int j = 0; j < boardSize ; j++){
                
                g.setColor(pallete[board[i][j]]);

                g.fillRect(i * screenX / boardSize,
                           j * screenY / boardSize,
                          (i + 1) * screenX / boardSize,
                          (j + 1) * screenY / boardSize );

                g.setColor(Color.WHITE);
                /* g.drawRect(i * screenX / boardSize,
                           j * screenY / boardSize,
                          (i + 1) * screenX / boardSize,
                          (j + 1) * screenY / boardSize); */

            }
        }

        
    }

    public Color randomColor() {
        float r = rand.nextFloat() / 2f + 0.5f;
        float g = rand.nextFloat() / 2f + 0.5f;
        float b = rand.nextFloat() / 2f + 0.5f;

        return new Color(r, g, b);
    }

/*     private void paintGrid(Graphics2D g, int screenX, int screenY) {
        g.setColor(Color.WHITE);
        for(int i = 0; i <= screenX; i += screenX / boardSize) {
            g.drawLine(i, 0, i, screenY);
        }

        for(int i = 0; i <= screenY; i += screenY / boardSize) {
            g.drawLine(0, i, screenX, i);
        }
    } */

    private class Ant {
        private int x;
        private int y;
        private int dir;

        Ant(int x, int y) {
            this.x = x;
            this.y = y;
            this.dir = 2;
        }

        private void update() throws Exception {
            

            if(rules.charAt(board[x][y]) == 'R') {
                
                turnRight();
            }
            else if (rules.charAt(board[x][y]) == 'L' ){
                turnLeft();
            } 
            else throw new Exception("Unrecognized Character;");  
            
            board[x][y] = board[x][y] >= rules.length() - 1 ? 0 : board[x][y] + 1;

            moveForward();
        }

        private void moveForward() {
            switch(dir) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y += 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y -= 1; 
                    break;
            }
        }

        private void turnLeft() {
            dir = dir == 3 ? 0 : dir + 1;
        }

        private void turnRight() {
            dir = dir == 0 ? dir = 3 : dir - 1;
        }

        private void paint(Graphics2D g, int screenX, int screenY) {
            g.setColor(Color.RED);
            g.fillOval(x * screenX / boardSize,
                       y * screenY / boardSize,
                      screenX / boardSize,
                      screenY / boardSize );
        }
    }
}
