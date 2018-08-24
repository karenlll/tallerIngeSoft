package co.edu.icesi.tic.ingesoft.justfly.model;

import co.edu.icesi.tic.ingesoft.justfly.model.entity.CircleShape;

/**
 * Class that allows to detect collisions.
 * 
 * @author lfrivera
 *
 */
public class CollisionHelper {

	/**
	 * Unique instances of the class.
	 */
	private static CollisionHelper instance;

	/**
	 * Constructor of the class.
	 */
	private CollisionHelper() {
	}

	/**
	 * Allows to obtain the unique instance of the class.
	 * 
	 * @return Unique instance of the class.
	 */
	public static CollisionHelper getInstance() {
		if (instance == null) {
			instance = new CollisionHelper();
		}

		return instance;
	}

	/**
	 * Incomplete. Allows to detect collisions. Taken from:
	 * http://stackoverflow.com/questions/8566336/java-circle-circle-collision-detection
	 * 
	 * @param a
	 *            First shape to be compared.
	 * @param b
	 *            Second shape to be compared.
	 * @return Boolean value that indicates whether there is a collision.
	 */
	public boolean collision(CircleShape a, CircleShape b) {
		boolean answer = false;
		double dx = a.getPosition().x - b.getPosition().x;
		double dy = a.getPosition().y - b.getPosition().y;
		double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		answer = distance < a.getRadius() + b.getRadius();

		return answer;
	}
	

}
