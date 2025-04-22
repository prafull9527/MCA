/*import javax.swing.*;

public class BlinkText implements Runnable 
{
    JLabel label;

    public BlinkText() 
    {
        JFrame f = new JFrame("Blinking Text");
        label = new JLabel("Hello Prafull", SwingConstants.CENTER);
        f.add(label);
        f.setSize(300, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        new Thread(this).start();
    }

    public void run() 
    {
        while (true) 
        {
            label.setVisible(!label.isVisible());
            try 
            { 
                Thread.sleep(500); 
            } 
            catch (Exception e) 
            {

            }
        }
    }

    public static void main(String[] args)
     {
        new BlinkText();
    }
}
*/
import javax.swing.*;
public class blinktext implements Runnable
{
    JLabel label;
    public blinktext()
    {
        JFrame f=new JFrame("blink text");
        label=new JLabel("Prafull chavan",SwingConstants.CENTER);
        f.add(label);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        new Thread(this).start();
    }
    public void run()
    {
        while(true)
        {
            label.setVisible(!label.isVisible());
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) {
        new blinktext();
    }

}


 /* 
 import java.awt.*;
 public class BlinkText extends Frame implements Runnable
 {
 Thread t;
 Label l1;
 int f;
 public BlinkText()
 {
 t=new Thread(this);
 t.start();
 setLayout(null);
 l1=new Label("Hello JAVA");
 l1.setBounds(100,100,100,40);
 add(l1);
 setSize(300,300);
 setVisible(true);
 f=0;
 }
 public void run()
 {
 try
 {
 if(f==0)
 {
 t.sleep(200);
 l1.setText("");
 f=1;
 }
 if(f==1)
 {
 t.sleep(200);
 l1.setText("Hello Java");
 f=0;
 }
 }catch(Exception e)
 {
 System.out.println(e);
 }
 run();
 }
 public static void main(String args[])
 {
 new BlinkText();
 }
 }
 */