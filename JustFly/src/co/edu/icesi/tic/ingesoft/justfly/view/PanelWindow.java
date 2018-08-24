package co.edu.icesi.tic.ingesoft.justfly.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A window that enables controlling the main actions in the game.
 * 
 * @author lfrivera
 *
 */
public class PanelWindow extends JFrame {

	// Constants
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 250;
	public static final String BUTTON_1_NAME = "Change Buttons' Color";
	public static final String BUTTON_2_NAME = "Change Panel's Color";
	public static final String BUTTON_3_NAME = "Change Canvas' Color";
	public static final String BUTTON_4_NAME = "Change Fonts' Color";
	public static final String BUTTON_5_NAME = "Change Score's Color";
	public static final String BUTTON_6_NAME = "Randomize Colors";
	public static final String BUTTON_7_NAME = "Activate/De-activate Collision Shapes";
	public static final String BUTTON_8_NAME = "Exit Game";
	public static final String BUTTON_9_NAME = "Close Control Panel";

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The relative window.
	 */
	private JFrame relativeWindow;

	/**
	 * The buttons in the control panel.
	 */
	private JButton[] buttons;

	/**
	 * The main panel of the window.
	 */
	private JPanel mainPanel;

	/**
	 * Constructor of the class.
	 */
	public PanelWindow(JFrame relativeWindow) {
		init();
	}

	/**
	 * Allows to initialize the window.
	 */
	private void init() {

		// Initial configuration

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(relativeWindow);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Configure Panel

		mainPanel = new JPanel();
		mainPanel.setSize(getMaximumSize());
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Configure Buttons
		JButton[] auxButtons = { new JButton(BUTTON_1_NAME), new JButton(BUTTON_2_NAME), new JButton(BUTTON_3_NAME),
				new JButton(BUTTON_4_NAME), new JButton(BUTTON_5_NAME), new JButton(BUTTON_6_NAME),
				new JButton(BUTTON_7_NAME), new JButton(BUTTON_8_NAME), new JButton(BUTTON_9_NAME) };
		buttons = auxButtons;
		for (JButton button : buttons) {
			mainPanel.add(button);
		}

		setContentPane(mainPanel);
	}

	/**
	 * Allows to show a JColorChooser and obtain a selected color.
	 * 
	 * @return A selected color.
	 */
	public Color showColorChooser() {
		return new Color(0,0,0);
	}

	/*
	 * Getters & Setters
	 */

	public JButton[] getButtons() {
		return buttons;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

}
