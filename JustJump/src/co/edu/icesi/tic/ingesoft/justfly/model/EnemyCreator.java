package co.edu.icesi.tic.ingesoft.justfly.model;

import java.util.ArrayList;

/**
 * Class that allows to create enemies.
 * @author lfrivera
 *
 */
public class EnemyCreator {

	/**
	 * Unique instance of the class.
	 */
	private static EnemyCreator instance;
	
	/**
	 * Constructor of the class.
	 */
	private EnemyCreator()
	{}
	
	public static EnemyCreator getInstance()
	{
		if(instance == null)
		{
			instance = new EnemyCreator();
		}
		return instance;
	}
	
	/**
	 * Incomplete.
	 * Allows to create the initial enemies of the game (borders).
	 * @return Initial enemies of the game.
	 */
	public ArrayList<Enemy> generateInitialEnemies()
	{
		ArrayList<Enemy> response = new ArrayList<Enemy>();

		return response;
	}
	
	/**
	 * Incomplete
	 * Method that allows to generate a random enemy.
	 * @return New enemy.
	 */
	public Enemy generateRandomEnemy()
	{
		Enemy random = new Enemy(0, 0);
		return random;
	}
	
}
