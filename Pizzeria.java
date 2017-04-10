//Stephen Orsino
//Pizzeria.java


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Pizzeria extends JFrame {

	//JFrame pizzashop;
	private JPanel Heading;
	private JPanel Pizzasize;
	private JPanel pizzatop;
	private JPanel drink;
	private JPanel Buttons;
	private JLabel head;
	private JLabel Size;
	private JLabel Drink;
	private JLabel Toppings;
	private JLabel price;
	private JRadioButton szsmall;
	private JRadioButton szmed;
	private JRadioButton szlarge;
	private JRadioButton szextra;
	private JRadioButton drsoda;
	private JRadioButton drtea;
	private JRadioButton drbottle;
	private JRadioButton drtap;
	private JCheckBox toppep;
	private JCheckBox topsausage;
	private JCheckBox topmush;
	private JCheckBox topolive;
	private ButtonGroup grpsize;
	private ButtonGroup grpdrink;
	private JButton btncost;
	private JButton btnexit;
	
	public Pizzeria() {
		super("Order your pizza here!");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel Heading = new JPanel();
		JLabel heading = new JLabel("My Pizzeria");
		Heading.add(heading);
		createGroups();
		add(Heading, BorderLayout.NORTH);
		add(Pizzasize, BorderLayout.WEST);
		add(pizzatop, BorderLayout.CENTER);
		add(drink, BorderLayout.EAST);
		add(Buttons, BorderLayout.SOUTH);
		
		calculateButton calculate = new calculateButton();
		btncost.addActionListener(calculate);
		closeButton close = new closeButton();
		btnexit.addActionListener(close);
		
		setVisible(true);
		
		
	}
	
	public void createGroups() {
		szsmall = new JRadioButton("Small: $7.00", true);
		szmed = new JRadioButton("Medium: $9.00");
		szlarge = new JRadioButton("Large: $11.00");
		szextra = new JRadioButton("Extra Large: $14.00");
		grpsize = new ButtonGroup();
		
		grpsize.add(szsmall);
		grpsize.add(szmed);
		grpsize.add(szlarge);
		grpsize.add(szextra);
		
		Pizzasize = new JPanel();
		Size = new JLabel("Choose Your Size");
		Pizzasize.add(Size);
		Pizzasize.add(szsmall);
		Pizzasize.add(szmed);
		Pizzasize.add(szlarge);
		Pizzasize.add(szextra);
		
		drsoda = new JRadioButton("Soda: $2.00", true);
		drtea = new JRadioButton("Tea: $1.50");
		drbottle = new JRadioButton("Bottle of Water: $1.25");
		drtap = new JRadioButton("Tap Water: No Charge");
		grpdrink = new ButtonGroup();
		
		grpdrink.add(drsoda);
		grpdrink.add(drtea);
		grpdrink.add(drbottle);
		grpdrink.add(drtap);
		
		drink = new JPanel();
		Drink = new JLabel("Choose Your Drink");
		drink.add(Drink);
		drink.add(drsoda);
		drink.add(drtea);
		drink.add(drbottle);
		drink.add(drtap);
		
		
		toppep = new JCheckBox("Pepperoni");
		topsausage = new JCheckBox("Sausage");
		topmush = new JCheckBox("Mushrooms");
		topolive = new JCheckBox("Olives");
		
		pizzatop = new JPanel();
		Toppings = new JLabel("Choose your toppings: ");
		pizzatop.add(Toppings);
		pizzatop.add(toppep);
		pizzatop.add(topsausage);
		pizzatop.add(topmush);
		pizzatop.add(topolive);
		
		Buttons = new JPanel();
		price = new JLabel();
		btncost = new JButton("Calculate");
		btnexit = new JButton ("Exit");
		Buttons.add(btncost);
		Buttons.add(btnexit);
		Buttons.add(price);
		
	}
	
	private class calculateButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double total = 0.0;
			
			if (szsmall.isSelected())
				total += 7.0;
			if (szmed.isSelected())
				total += 9.0;
			if (szlarge.isSelected())
				total += 11.0;
			if (szextra.isSelected())
				total += 14.0;
			if (toppep.isSelected())
				total += 1.0;
			if (topsausage.isSelected())
				total += 1.0;
			if (topmush.isSelected())
				total += 1.0;
			if (topolive.isSelected())
				total += 1.0;
			if (drsoda.isSelected())
				total += 2.0;
			if (drtea.isSelected())
				total += 1.5;
			if (drbottle.isSelected())
				total += 1.25;
			
			DecimalFormat dollar = new DecimalFormat("0.00");
			
			price.setText("Total Order: $" + dollar.format(total));
		}
	}
	
	private class closeButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Pizzeria myPizza = new Pizzeria();
		
	}
	

}
