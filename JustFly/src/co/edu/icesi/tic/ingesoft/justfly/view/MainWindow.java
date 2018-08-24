package co.edu.icesi.tic.ingesoft.justfly.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.icesi.tic.ingesoft.justfly.model.Enemy;
import co.edu.icesi.tic.ingesoft.justfly.model.Player;

/**
 * The main window of the game.
 * @author lfrivera
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame{

	/**
	 * Main player of the game.
	 */
	private Player player;
	
	/**
	 * The fixed enemies.
	 */
	private ArrayList<Enemy> fixedEnemies;
	
	/**
	 * The random enemies.
	 */
	private ArrayList<Enemy> randomEnemies;
	
	/**
	 * Canvas of the game.
	 */
	private Canvas canvas;
	
	/**
	 * Constructor of the class.
	 */
	public MainWindow(Player player, ArrayList<Enemy> fixedEnemies, ArrayList<Enemy> randomEnemies)
	{
		super("JustFly by lfrivera (Universidad Icesi)");
		this.player = player;
		this.fixedEnemies = fixedEnemies;
		this.randomEnemies = randomEnemies;
		init();
	}
	
	/**
	 * Method that allows to initialize the main window.
	 */
	private void init()
	{
		setSize(1000,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		canvas = new Canvas(player, fixedEnemies, randomEnemies);
		setContentPane(canvas);
	}

	
	/**
	 * Allows to show a message.
	 * @param message Message to show.
	 */
	public void showMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Method that allows to obtain the canvas of the game.
	 * @return Canvas of the game.
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	
	
	
}
