import javax.swing.*;
import java.awt.*;

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
		g.fillRect(0,0,500,500);

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
		f.repaint();
		f.revalidate();
		f.setVisible(true);
	}
}