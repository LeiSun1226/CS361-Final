package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dishes.DishData;
import model.MainModel;
import dishes.Dish;

/**
 * Class for application GUI
 */
public class MainView extends JFrame{
	/**
	 * uid
	 */
	private static final long serialVersionUID = 5702178460462074307L;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JToggleButton btnBreakfast = new JToggleButton("Breakfast");
	private final JToggleButton btnLunch = new JToggleButton("Lunch");
	private final JToggleButton btnDinner = new JToggleButton("Dinner");
	private final JToggleButton btnAfternoonSnack = new JToggleButton("Afternoon Snack");
	private final JToggleButton btnMorningSnack = new JToggleButton("Morning Snack");
	private final JToggleButton btnMidnightSnack = new JToggleButton("Midnight Snack");
	private final JTextPane txtpnSelectMealsYou = new JTextPane();
	private final JPanel panel_4 = new JPanel();
	private final JTextPane txtpnConstraitnsOfVariety = new JTextPane();
	private final JPanel panel_5 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JTextPane txtpnCaloryIntake = new JTextPane();
	private final JSlider sliderCalorie = new JSlider();
	private final JPanel panel_3 = new JPanel();
	private final JScrollPane scrollPaneRecommendations = new JScrollPane();
	private final JPanel panelRecommendation = new JPanel();
	public MainModel program;
	private final JPanel panel_7 = new JPanel();
	private final JTextPane txtpnNumberOfPeople = new JTextPane();
	private final JSpinner spinnerNumPeople = new JSpinner();
	private final JPanel panel_8 = new JPanel();
	private final JButton btnGenerate = new JButton("Generate!");
	private int cur_calorie;
	private final JButton btnSetting = new JButton("Setting");
	private SettingView setting = new SettingView();
	
	/**
	 *  Initializer for the GUI view
	 */
	public MainView(MainModel p) {
		this.program = p;
		start();
	}
	
	/**
	 * Start the program running
	 */
	public void start() {
		initGUI();
		setVisible(true);
	}
	
	public void printDish(Dish d) { 
		JPanel dish = new JPanel();
		dish.setSize(200, 500);
		FlowLayout flowLayout = (FlowLayout) dish.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JTextPane name = new JTextPane();
		name.setText(d.name);
		dish.add(name);
		
		JTextPane calorie = new JTextPane();
		calorie.setText("Calorie: " + String.valueOf(d.calories));
		dish.add(calorie);
		
		JTextPane weight = new JTextPane();
		weight.setText("Serving size: " + String.valueOf(d.weight) + "g");
		dish.add(weight);
		
		JTextPane serving = new JTextPane();
		serving.setText("Number of serving(s): " + String.valueOf(this.program.numPeople));
		dish.add(serving);
		
		dish.setPreferredSize(new Dimension(this.panelRecommendation.getWidth(), 50));
		this.panelRecommendation.add(dish);
		revalidate();
		repaint();
	}
	
	/**
	 * Initialize the GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		txtpnSelectMealsYou.setText("Select Meals You Want to Have");
		
		panel_1.add(txtpnSelectMealsYou, BorderLayout.WEST);
		
		btnSetting.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setting.start();
				}
			});
		panel_1.add(btnSetting, BorderLayout.EAST);
		
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		btnBreakfast.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[0] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[0] = 0;
		      }
		   }
		});
		panel_2.add(btnBreakfast);
		
		btnMorningSnack.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[1] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[1] = 0;
		      }
		   }
		});
		panel_2.add(btnMorningSnack);
		
		btnLunch.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[2] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[2] = 0;
		      }
		   }
		});
		panel_2.add(btnLunch);
		
		btnAfternoonSnack.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[3] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[3] = 0;
		      }
		   }
		});
		panel_2.add(btnAfternoonSnack);
		
		btnDinner.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[4] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[4] = 0;
		      }
		   }
		});
		panel_2.add(btnDinner);
		
		btnMidnightSnack.addItemListener(new ItemListener() {
		   public void itemStateChanged(ItemEvent ev) {
		      if(ev.getStateChange()==ItemEvent.SELECTED){
		    	  program.meals[5] = 1;
		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
		    	  program.meals[5] = 0;
		      }
		   }
		});
		panel_2.add(btnMidnightSnack);
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
//		panel.add(panel_4);
//		txtpnConstraitnsOfVariety.setText("Constraints of Variety");
//		
//		panel_4.add(txtpnConstraitnsOfVariety);
		
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		txtpnCaloryIntake.setText("Calory Intake Per Person");
		
		panel_5.add(txtpnCaloryIntake);
		sliderCalorie.setPaintLabels(true);
		sliderCalorie.setMajorTickSpacing(1000);
		sliderCalorie.setValue(1000);
		sliderCalorie.setToolTipText("Slide to adjust calorie");
		sliderCalorie.setPaintTicks(true);
		sliderCalorie.setMinorTickSpacing(200);
		sliderCalorie.setMaximum(4000);
		sliderCalorie.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent event) {
	        	program.calorie = sliderCalorie.getValue();
	        }
	    });
		
		panel_5.add(sliderCalorie);
		
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		panel_6.add(panel_7, BorderLayout.WEST);
		txtpnNumberOfPeople.setText("Number of People");
		
		panel_7.add(txtpnNumberOfPeople);
		spinnerNumPeople.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		
		spinnerNumPeople.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent event) {
	        	program.numPeople = (int)spinnerNumPeople.getValue();
	        }
	    });
		panel_7.add(spinnerNumPeople);
		
		panel_6.add(panel_8, BorderLayout.EAST);
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate();
			}
		});
		panel_8.add(btnGenerate);
		
		getContentPane().add(scrollPaneRecommendations, BorderLayout.CENTER);
		panelRecommendation.setLayout(new BoxLayout(panelRecommendation, BoxLayout.Y_AXIS));
		scrollPaneRecommendations.setViewportView(panelRecommendation);
		
	}
	
	
	public void generate() {
		panelRecommendation.removeAll();
		revalidate();
		repaint();
		String msg = this.program.isValid();
		if (msg.length() != 0) showError(msg);
		else {
			List<Integer> cal = new ArrayList<Integer>();
			for (int i = 0; i < program.dish_name.length; i++) {
				ArrayList<Dish> dish = program.getDish(i);
				if (dish.size() != 0) {
					printMealHeader(program.dish_name[i]);
					for (Dish d : dish) {
						cal.add(d.calories);
						printDish(d);
					}
				}
			}
			int total;
			try {
				total = program.calcCalorie(cal);
				if (total == 0) {
					printMealHeader("Calorie calculator is temporarily unavailable.");
				} else {
					printMealHeader("The total amount of calorie is " + String.valueOf(total) + ".");
				}
			} catch (IOException e) {
				printMealHeader("Calorie calculator is temporarily unavailable.");
			}
		}
		
	}
	
	public void showError(String msg) {
		JPanel header = new JPanel();
		JTextPane name = new JTextPane();
		name.setText(msg);
		header.add(name);
		header.setPreferredSize(new Dimension(this.panelRecommendation.getWidth(), 50));
		
		this.panelRecommendation.add(header);
		revalidate();
		repaint();
	}
	
	public void printMealHeader(String meal) {
		JPanel header = new JPanel();
		JTextPane name = new JTextPane();
		name.setText(meal);
		header.add(name);
		header.setPreferredSize(new Dimension(this.panelRecommendation.getWidth(), 50));
		
		this.panelRecommendation.add(header);
		revalidate();
		repaint();
	}
	
	/**
	 * Main method for starting the application
	 * 
	 * @param args not used
	 */
	public static void main(String args[]) {
		DishData dishes = new DishData();
		MainModel program = new MainModel(dishes);
		MainView view = new MainView(program);
	}
}
