package co.edu.icesi.tic.ingesoft.justfly.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import co.edu.icesi.tic.ingesoft.justfly.model.Enemy;
import co.edu.icesi.tic.ingesoft.justfly.model.EnemyCreator;
import co.edu.icesi.tic.ingesoft.justfly.model.Player;
import co.edu.icesi.tic.ingesoft.justfly.view.MainWindow;

/**
 * Entry point of the game.
 * @author lfrivera
 *
 */
public class JustFlyControl {
	
	/**
	 * Indicates whether the game is active.
	 */
	public static boolean ActiveGame;
	
	/**
	 * Main window of the game.
	 */
	private static MainWindow window;
	
	/**
	 * Main player of the game.
	 */
	private static Player player;
	
	/**
	 * Animation of the player.
	 */
	private static AnimationThread animationThread;
	
	/**
	 * The left motion thread of the player motion.
	 */
	private static MotionThread leftMotionPlayerThread;
	
	/**
	 * The right motion thread of the player motion.
	 */
	private static MotionThread rightMotionPlayerThread;
	
	/**
	 * The up motion thread of the player motion.
	 */
	private static MotionThread upMotionPlayerThread;
	
	/**
	 * The left motion thread of the player motion.
	 */
	private static MotionThread downMotionPlayerThread;
	
	/**
	 * The fixed enemies in the game.
	 */
	private static ArrayList<Enemy> fixedEnemies;
	
	/**
	 * The random enemies in the game.
	 */
	public static ArrayList<Enemy> randomEnemies;
	
	/**
	 * The motion rate.
	 */
	private static final int MOTION_RATE = 20;
	
	/**
	 * The random enemies appearance rate.
	 */
	private static final int RANDOM_ENEMIES_RATE = 1000;
	
	/**
	 * The motion rate of the random enemies.
	 */
	private static final int MAX_MOTION_RATE_RANDOM_ENEMIES = 20;
	
	/**
	 * The score rate.
	 */
	private static final int SCORE_RATE = 100;
	
	/**
	 * Main method.
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		ActiveGame = true;
		player = new Player(100,100);
		initializeEnemies();
		window = new MainWindow(player, fixedEnemies, randomEnemies);
		window.setVisible(true);
		initializeThreads();
		registerEvents();
		activateScoreTimer();
	}
	
	/**
	 * Method that allows to initialize the threads of the game.
	 */
	private static void initializeThreads()
	{
		animationThread = new AnimationThread(player, 60, window.getCanvas());
		animationThread.start();
	}
	
	/**
	 * Method that allows to initialize enemies.
	 */
	private static void initializeEnemies()
	{
		fixedEnemies = EnemyCreator.getInstance().generateInitialEnemies();
		randomEnemies = new ArrayList<Enemy>();
		Timer timer = new Timer(RANDOM_ENEMIES_RATE, generateRandomEnemy());
		timer.start();
	}
	
	/**
	 * Method that allows to register all events.
	 */
	private static void registerEvents()
	{
		window.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				
				if(keyCode == getCodeKeyUp())
				{
					upKeyEvent(false);
				}
				
				if(keyCode == getCodeKeyDown())
				{
					downKeyEvent(false);
				}
				
				if(keyCode == getCodeKeyLeft())
				{
					leftKeyEvent(false);
				}
				
				if(keyCode == getCodeKeyRight())
				{
					rightKeyEvent(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				
				if(keyCode == getCodeKeyUp())
				{
					upKeyEvent(true);
				}
				
				if(keyCode == getCodeKeyDown())
				{
					downKeyEvent(true);
				}
				
				if(keyCode == getCodeKeyLeft())
				{
					leftKeyEvent(true);
				}
				
				if(keyCode == getCodeKeyRight())
				{
					rightKeyEvent(true);
				}
				
			}
			
		});
	}
	
	/**
	 * Manages the up key.
	 * @param pressed Indicates whether the key was pressed or released.
	 */
	private static void upKeyEvent(boolean pressed)
	{
		if(pressed)
		{
			if(upMotionPlayerThread == null)
			{
				upMotionPlayerThread = new MotionThread(false,MotionThread.UP, player, MOTION_RATE, window,fixedEnemies,null);
				upMotionPlayerThread.start();
			}
		}
		else
		{
			upMotionPlayerThread.stopMotion();
			upMotionPlayerThread = null;
		}
	}
	
	/**
	 * Manages the down key.
	 * @param pressed Indicates whether the key was pressed or released.
	 */
	private static void downKeyEvent(boolean pressed)
	{
		if(pressed)
		{
			if(downMotionPlayerThread == null)
			{
				downMotionPlayerThread = new MotionThread(false,MotionThread.DOWN, player, MOTION_RATE, window,fixedEnemies,null);
				downMotionPlayerThread.start();
			}
		}
		else
		{
			downMotionPlayerThread.stopMotion();
			downMotionPlayerThread = null;
		}
	}
	
	/**
	 * Manages the left key.
	 * @param pressed Indicates whether the key was pressed or released.
	 */
	private static void leftKeyEvent(boolean pressed)
	{
		if(pressed)
		{
			if(leftMotionPlayerThread == null)
			{
				leftMotionPlayerThread = new MotionThread(false,MotionThread.LEFT, player, MOTION_RATE, window,fixedEnemies,null);
				leftMotionPlayerThread.start();
			}
		}
		else
		{
			leftMotionPlayerThread.stopMotion();
			leftMotionPlayerThread = null;
		}
	}
	
	/**
	 * Manages the right key.
	 * @param pressed Indicates whether the key was pressed or released.
	 */
	private static void rightKeyEvent(boolean pressed)
	{
		if(pressed)
		{
			if(rightMotionPlayerThread == null)
			{
				rightMotionPlayerThread = new MotionThread(false,MotionThread.RIGHT, player, MOTION_RATE, window,fixedEnemies,null);
				rightMotionPlayerThread.start();
			}
		}
		else
		{
			rightMotionPlayerThread.stopMotion();
			rightMotionPlayerThread = null;
		}
	}
	
	/**
	 * Method that allows to generate random enemies.
	 * @return ActionListener.
	 */
	private static ActionListener generateRandomEnemy()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Enemy enemy = EnemyCreator.getInstance().generateRandomEnemy();
				randomEnemies.add(enemy);
				MotionThread enemyThread = new MotionThread(true, MotionThread.LEFT, enemy, new Random().nextInt(MAX_MOTION_RATE_RANDOM_ENEMIES) + 1, window, null, player);
				enemyThread.start();
			}
		};
	}
	
	/**
	 * Allows to activate the score timer.
	 */
	private static void activateScoreTimer()
	{
		Timer timer = new Timer(SCORE_RATE, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ActiveGame)
				{
					player.sumOnePoint();
				}
			}
		});
		timer.start();
	}
	
	/**
	 * Allows to obtain the constant for the non-numpad up arrow key or the desired key for moving up the player.
	 * 
	 * @return The code for the up key.
	 */
	private static int getCodeKeyUp() {
		
		return -1;
		
	}
	
	/**
	 * Allows to obtain the constant for the non-numpad down arrow key or the desired key for moving down the player.
	 * 
	 * @return The code for the down key.
	 */
	private static int getCodeKeyDown() {
		
		return -1;
		
	}
	
	/**
	 * Allows to obtain the constant for the non-numpad left arrow key or the desired key for moving left the player.
	 * 
	 * @return The code for the left key.
	 */
	private static int getCodeKeyLeft() {
		
		return -1;
		
	}
	
	/**
	 * Allows to obtain the constant for the non-numpad right arrow key or the desired key for moving right the player.
	 * 
	 * @return The code for the down key.
	 */
	private static int getCodeKeyRight() {
		
		return -1;
		
	}

}
