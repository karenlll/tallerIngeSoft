package co.edu.icesi.tic.ingesoft.justfly.model;

import co.edu.icesi.tic.ingesoft.justfly.model.entity.CircleShape;

/**
 * Interface that defines the behavior of a motinable element.
 * @author lfrivera
 *
 */
public interface IMotionable {

	/**
	 * Method that allows to move right.
	 */
	public void right();
	
	/**
	 * Method that allows to move left.
	 */
	public void left();
	
	/**
	 * Allows to detect a collision.
	 * @param shape Shape to be validated.
	 * @return Boolean that indicates whether there is a collision.
	 */
	public boolean collision(CircleShape shape);
	
}
