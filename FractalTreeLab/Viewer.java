import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Viewer implements ActionListener
{
    private final int WIDTH = 700;
    private final int HEIGHT = 400;

    private TreePanel drawing;
    private JPanel panel;
    private JFrame frame;

    public static void main(String[] args)
    {
        Viewer viewer = new Viewer();
    }

    public Viewer()
    {
        drawing = new TreePanel(10);

        panel = new JPanel();
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
}