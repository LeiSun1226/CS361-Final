package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SettingView extends JFrame{

	/**
	 * uid
	 */
	private static final long serialVersionUID = 5296096948937594691L;

	public SettingView() {
	}
	
	public void start() {
		initGUI();
		setVisible(true);
	}
	
	public void close() {
		setVisible(false);
	}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnAdvancedOptions = new JTextPane();
		txtpnAdvancedOptions.setText("Advanced Options");
		panel.add(txtpnAdvancedOptions, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JTextPane txtpnInstructionExclude = new JTextPane();
		txtpnInstructionExclude.setText("Select Dish to Exclude from Recommendation");
		panel_2.add(txtpnInstructionExclude);
		
		JComboBox comboBoxExclude = new JComboBox();
		panel_2.add(comboBoxExclude);
		
		JTextPane txtpnInstructionInclude = new JTextPane();
		txtpnInstructionInclude.setText("Select Dish to Include in Recommendation");
		panel_2.add(txtpnInstructionInclude);
		
		JComboBox comboBoxInclude = new JComboBox();
		panel_2.add(comboBoxInclude);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnGuide = new JTextPane();
		txtpnGuide.setText("This program is used to provide meal plan recommendations based on "
				+ "user preference. To request for recommendations, select the meals, amount of "
				+ "calorie, and number of people that suit your needs. You can further personalize "
				+ "your meal plans using the advanced options below.");
		panel_1.add(txtpnGuide, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnSettings = new JTextPane();
		txtpnSettings.setText("Settings");
		panel_3.add(txtpnSettings, BorderLayout.WEST);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		panel_3.add(btnBack, BorderLayout.EAST);
	}
}
