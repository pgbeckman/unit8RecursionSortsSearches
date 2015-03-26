
import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 650;
   private final int PANEL_HEIGHT = 350;

   private final int STARTX = PANEL_WIDTH / 2 , STARTY = PANEL_HEIGHT - 20;

   private int current; //current order
   private double angle = 0;
   private int L = 50;
   private double angleChange = 0;
   private int lengthChange = 5;

   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.WHITE);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   public void drawFractal (int order, int x1, int y1, double angle, int L,
                            Graphics2D page)
   {
      if (order == 0) {
         return;
        }
      else
      {
         int newX1 = (int)(x1+L*Math.sin(angle-angleChange));
         int newY1 = (int)(y1-L*Math.cos(angle-angleChange));
         int newX2 = (int)(x1+L*Math.sin(angle+angleChange));
         int newY2 = (int)(y1-L*Math.cos(angle+angleChange));
         page.setStroke(new BasicStroke(L/7));
         page.drawLine(x1, y1, newX1, newY1);
         page.drawLine(x1, y1, newX2, newY2);
         drawFractal(order-1, newX1, newY1, angle - angleChange, L - lengthChange, page);
         drawFractal(order-1, newX2, newY2, angle + angleChange, L - lengthChange, page);
        }
   }
   
   public void growFractal (int order, int x1, int y1, double angle, int L,
                            Graphics2D page)
   {
      if (order == 0) {
         return;
        }
      else
      {
         drawFractal(order, x1, y1, angle, L, page);
         repaint();
         if(angleChange < .4){
         angleChange += .0001;
        }
        }
   }

   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);

      page.setColor (Color.RED);

      Graphics2D g2 = (Graphics2D) page;
      growFractal(current, STARTX, STARTY, angle, L, g2);
   }
}
