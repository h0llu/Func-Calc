import Exceptions.CountException;
import Exceptions.DivisionByZeroException;
import Exceptions.OverflowException;
import Exceptions.ParsingException;
import Operations.Expression;
import Parser.ExpressionParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FunctionGUI extends JFrame {
	JLabel functionLabel,
		   xLabel,
		   errorLabel,
		   fOfXLabel;
	JTextField functionField,
			   xField;
	Expression expression;
	PlotPanel panel;

	public FunctionGUI() {
		setTitle("Function Calculator");
		setSize(900, 650);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		functionLabel = new JLabel("f(x) =");
		functionLabel.setFont(new Font(functionLabel.getFont().getName(), Font.BOLD, 18));
		functionLabel.setBounds(10, 50, 60, 30);

		xLabel = new JLabel("x =");
		xLabel.setFont(new Font(xLabel.getFont().getName(), Font.BOLD, 18));
		xLabel.setBounds(10, 85, 60, 30);

		fOfXLabel = new JLabel("");
		fOfXLabel.setFont(new Font(fOfXLabel.getFont().getName(), Font.BOLD, 18));
		fOfXLabel.setForeground(Color.BLACK);
		fOfXLabel.setBounds(10, 120, 200, 30);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 200, 200, 100);

		add(functionLabel);
		add(xLabel);
		add(fOfXLabel);
		add(errorLabel);

		functionField = new JTextField();
		functionField.setBounds(75, 50, 150, 30);

		xField = new JTextField();
		xField.setBounds(75, 85, 150, 30);

		add(functionField);
		add(xField);

		JButton setFunction = new JButton("Set function");
		setFunction.setBounds(10, 500, 215, 25);

		JButton evaluate = new JButton("Evaluate");
		evaluate.setBounds(10, 530, 215, 25);

		JButton drawPlot = new JButton("Draw a plot");
		drawPlot.setBounds(10, 560, 215, 25);

		setFunction.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent mouseEvent) {}
			@Override
			public void mouseExited(MouseEvent mouseEvent) {}
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {}
			@Override
			public void mousePressed(MouseEvent mouseEvent) {}
			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
				panel.setFunction(null);
				panel.repaint();
				errorLabel.setText("");
				fOfXLabel.setText("");
				String stringExpr = functionField.getText();
				try {
					expression = new ExpressionParser().parse(stringExpr);
				} catch (ParsingException e) {
					expression = null;
					errorLabel.setText("<html>" + e.getMessage());
				}
			}});

		evaluate.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent mouseEvent) {}
			@Override
			public void mouseExited(MouseEvent mouseEvent) {}
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {}
			@Override
			public void mousePressed(MouseEvent mouseEvent) {}
			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
				errorLabel.setText("");
				fOfXLabel.setText("");
				if (xField.getText().equals("")) {
					errorLabel.setText("<html>x is not specified");
					return;
				}
				if (expression == null) {
					errorLabel.setText("<html>f(x) is empty");
					return;
				}
				double x = Double.parseDouble(xField.getText());
				try {
					String result = Double.toString(expression.evaluate(x));
					fOfXLabel.setText("f(x) = " + result);
				} catch (CountException | DivisionByZeroException | OverflowException e) {
					errorLabel.setText("<html>" + e.getMessage());
				}
			}
		});

		drawPlot.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent mouseEvent) {}
			@Override
			public void mouseExited(MouseEvent mouseEvent) {}
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {}
			@Override
			public void mousePressed(MouseEvent mouseEvent) {}
			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
					if (expression == null) {
						errorLabel.setText("<html>f(x) is empty");
						return;
					}
					panel.setFunction(func());
					panel.repaint();
			}

			private ArrayList<Pair> func() {
				ArrayList<Pair> function = new ArrayList<>();
				for (int x = 0; x < 600; x++) {
					try {
						double functionValue = expression.evaluate((double)(x - 300) / 15);
						if (functionValue < -20 || functionValue > 20) {
							continue;
						}
						Pair pair = new Pair(x, functionValue * -15 + 300);
						function.add(pair);
					} catch (CountException | DivisionByZeroException | OverflowException ignored) {}
				}
				return function;
			}
		});

		add(setFunction);
		add(evaluate);
		add(drawPlot);

		panel = new PlotPanel();
		panel.setBounds(240, 0, 600, 600);

		add(panel);
		setVisible(true);
	}
}

