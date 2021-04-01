import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

public class PlotPanel extends JPanel {
	private ArrayList<Pair> function = null;

	public PlotPanel() {
		setPreferredSize(new Dimension(600, 600));
		setBackground(Color.WHITE);
		setFocusable(true);
		paint(getGraphics());
	}

	public void setFunction(ArrayList<Pair> function) {
		this.function = function;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g;
		super.paintComponent(g);

		// Сетка
		gr.setPaint(Color.LIGHT_GRAY);
		gr.setStroke(new BasicStroke((float) 0.2));
		for(double i = 0; i <= this.getWidth(); i += 15){
			gr.draw(new Line2D.Double(0, i, this.getWidth(), i));
			gr.draw(new Line2D.Double(i,0, i, this.getHeight()));
		}

		// Рисуем оси
		gr.setPaint(Color.BLACK);
		gr.setStroke(new BasicStroke((float) 2));
		double ox = 300;
		gr.draw(new Line2D.Double(ox,0, ox,this.getHeight()));
		// оси
		double oy = 300;
		gr.draw(new Line2D.Double(0, oy,this.getWidth(), oy));

		// отображаем функцию
		if (function != null) {
			Iterator<Pair> it = function.iterator();
			Pair pair2 = null;
			if (it.hasNext())
				pair2 = it.next();
			while (it.hasNext()) {
				Pair pair1 = pair2;
				pair2 = it.next();
				gr.draw(new Line2D.Double(pair1.getKey(), pair1.getValue(), pair2.getKey(), pair2.getValue()));
			}
		}
	}
}