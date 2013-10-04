import javax.swing.*;
import java.awt.*;
/*
 * This Viewer class is produced by Ted Meyer for WPI CS 2223 (Algorithms)
 * This Viewer class is free to use by any student in the class provided they give attribution
 *
 * This code is provided for free on github.com/tmathmeyer/wpi-algo
 */
public class Viewer extends JPanel{
	int[] values = new int[0];
	JFrame f = new JFrame();

	public Viewer(String title){
		this.setPreferredSize(new Dimension(500,500));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1,1));
		f.add(this);
		f.pack();
		f.setVisible(true);
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,100+values.length*2,500);

		for(int i = 0; i < values.length; i++){
			int val = values[i];
			double scale = (255.0/500.0) * val;
			Color barColor = new Color(255-(int)scale, (int)scale, 0);
			g.setColor(barColor);
			g.fillRect(50+i*2, 500-val, 2, val);
		}
	}
	public void set(int[] v){
		this.values = v;
		this.repaint();
		f.setPreferredSize(new Dimension(100+values.length*2, 500));
		f.pack();
		f.repaint();
		f.revalidate();
		f.setVisible(true);
	}
}
