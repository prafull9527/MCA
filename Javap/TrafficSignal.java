import java.applet.Applet;
import java.awt.*;
public class TrafficSignal extends Applet implements Runnable
 {
Thread t;
int signal = 0; // 0 = Red, 1 = Yellow, 2 = Green
public void init() 
{
t = new Thread(this);
t.start();
}
public void run() 
{
while (true) {
try {
repaint();
Thread.sleep(2000); // 2 seconds per signal
signal = (signal + 1) % 3; // Cycle through signals
} catch (InterruptedException e) 
{
System.out.println(e);
}
}
}
public void paint(Graphics g) 
{
// Draw signal box
g.drawRect(100, 100, 100, 300);
// Red Light
if (signal == 0) 
{
g.setColor(Color.red);
g.fillOval(100, 100, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 200, 100, 100);
g.drawOval(100, 300, 100, 100);
}
// Yellow Light
else if (signal == 1) 
{
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.setColor(Color.yellow);
g.fillOval(100, 200, 100, 100);
g.setColor(Color.black);
g.drawOval(100, 300, 100, 100);
}
// Green Light
else if (signal == 2) 
{
g.setColor(Color.black);
g.drawOval(100, 100, 100, 100);
g.drawOval(100, 200, 100, 100);
g.setColor(Color.green);
g.fillOval(100, 300, 100, 100);
}
}
}



