import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, MouseListener {

    private final int DELAY = 0;

    private final int SCREEN_X = 800;
    private final int SCREEN_Y = 800;

    public Timer timer;
    public LangtonsAnt ant;

    public GamePanel() {
        initPanel();
    }

    public void initPanel() {
        ant = new LangtonsAnt(SCREEN_X, SCREEN_Y);

        addMouseListener(this);

        addKeyListener(new TAdapter());
        setOpaque(false);
        setFocusable(true);
        setPreferredSize(new Dimension(SCREEN_X, SCREEN_Y));
        System.out.println("-----INIT-----");

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        ant.paint(g2d);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try { ant.update(); } catch (Exception ee) {}

        repaint();  
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
/*         ant.addAnt(e.getX(), e.getY());
 */        System.out.println("X: " + e.getX() + "Y: " + e.getY());
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ant.addAnt(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}
