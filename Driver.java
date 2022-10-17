import java.awt.EventQueue;
import javax.swing.JFrame;

public class Driver extends JFrame {

    public Driver() {
        System.out.println("Starting Smart Rockets!");
        initUI();
    }
    
    private void initUI() {
        
        add(new GamePanel());

        setResizable(false);
        pack();
        
        setTitle("Langston's Ant");    
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Driver();
            ex.setVisible(true);
        });
    }
}