//Stephen Orsino
//Pizzeria.java


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Pizzeria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declare local variables
	private JPanel Heading;
	private JPanel pnleast;
	private JPanel pnlwest;
	private JPanel pnlcenter;
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
	
	//Constructor
	public Pizzeria() {
		
		//Set up main JFrame
		super("Order your pizza here!");
		setSize(900,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//set up groups
		createGroups();
		
		//add panels to main JFrame
		createBody();
		
		setVisible(true);
	}
	
	public void createGroups() {
		//create a radio group for pizza size
		szsmall = new JRadioButton("Small: $7.00", true);
		szmed = new JRadioButton("Medium: $9.00");
		szlarge = new JRadioButton("Large: $11.00");
		szextra = new JRadioButton("Extra Large: $14.00");
		grpsize = new ButtonGroup();
		
		//add buttons to group
		grpsize.add(szsmall);
		grpsize.add(szmed);
		grpsize.add(szlarge);
		grpsize.add(szextra);
		
		//Layout the buttons vertically
		Pizzasize = new JPanel();
		Pizzasize.setLayout(new GridLayout(6,3));
		Size = new JLabel("CHOOSE YOUR SIZE:");
		Pizzasize.add(Size);
		Pizzasize.add(szsmall);
		Pizzasize.add(szmed);
		Pizzasize.add(szlarge);
		Pizzasize.add(szextra);
		
		//Create a button group for drinks
		drsoda = new JRadioButton("Soda: $2.00", true);
		drtea = new JRadioButton("Tea: $1.50");
		drbottle = new JRadioButton("Bottle of Water: $1.25");
		drtap = new JRadioButton("Tap Water: No Charge");
		grpdrink = new ButtonGroup();
		
		//add buttons to group
		grpdrink.add(drsoda);
		grpdrink.add(drtea);
		grpdrink.add(drbottle);
		grpdrink.add(drtap);
		
		//Layout the buttons vertically
		drink = new JPanel();
		drink.setLayout(new GridLayout(6,3));
		Drink = new JLabel("CHOOSE YOUR DRINK:");
		drink.add(Drink);
		drink.add(drsoda);
		drink.add(drtea);
		drink.add(drbottle);
		drink.add(drtap);
		
		//create checkboxes for toppings
		toppep = new JCheckBox("Pepperoni $1.00");
		topsausage = new JCheckBox("Sausage $1.00");
		topmush = new JCheckBox("Mushrooms $1.00");
		topolive = new JCheckBox("Olives $1.00");
		
		//Layout the checkboxes vertically
		pizzatop = new JPanel();
		pizzatop.setLayout(new GridLayout(6,3));
		Toppings = new JLabel("CHOOSE YOUR TOPPINGS: ");
		pizzatop.add(Toppings);
		pizzatop.add(toppep);
		pizzatop.add(topsausage);
		pizzatop.add(topmush);
		pizzatop.add(topolive);
	}
	
	public void createBody(){
		//Set up heading
		JPanel Heading = new JPanel();
		Heading.setBackground(Color.RED);
		Heading.setSize(900,50);
		JLabel heading = new JLabel("YOUR FAVORITE JAVA PIZZERIA");
		heading.setForeground(Color.WHITE);
		Heading.add(heading);
		
		//Set up drink panel
		JPanel pnleast = new JPanel();
		pnleast.setSize(300,300);
		pnleast.add(drink, BorderLayout.CENTER);
		
		//Set up toppings panel
		JPanel pnlcenter = new JPanel();
		pnlcenter.setSize(300,300);
		pnlcenter.add(pizzatop, BorderLayout.CENTER);
		
		//Set upsize panel
		JPanel pnlwest = new JPanel();
		pnlwest.setSize(300,300);
		pnlwest.add(Pizzasize, BorderLayout.CENTER);
		
		//set up buttons
		JPanel Buttons = new JPanel();
		Buttons.setBackground(Color.RED);
		Buttons.setSize(900,50);
		price = new JLabel();
		price.setForeground(Color.WHITE);
		btncost = new JButton("Calculate");
		btnexit = new JButton ("Exit");
		Buttons.add(btncost);
		Buttons.add(btnexit);
		Buttons.add(price);
		
		//Add functionality to buttons
		calculateButton calculate = new calculateButton();
		btncost.addActionListener(calculate);
		closeButton close = new closeButton();
		btnexit.addActionListener(close);
		
		//Add all panels to main JFrame
		add(Heading, BorderLayout.NORTH);
		add(pnlwest, BorderLayout.WEST);
		add(pnlcenter, BorderLayout.CENTER);
		add(pnleast, BorderLayout.EAST);
		add(Buttons, BorderLayout.SOUTH);
	}
	
	private class calculateButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//start with zero 
			double total = 0.0;
			
			//add to total depending on what is selected
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
			
			//create a currency format
			DecimalFormat dollar = new DecimalFormat("0.00");
			
			//display the formatted total through the previously created JLabel
			price.setText("Total Order: $" + dollar.format(total));
		}
	}
	
	private class closeButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//functionality for exit button
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		//Create instance of pizzeria
		Pizzeria myPizza = new Pizzeria();
	}
}
