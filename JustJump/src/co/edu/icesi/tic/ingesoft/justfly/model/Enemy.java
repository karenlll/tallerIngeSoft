package co.edu.icesi.tic.ingesoft.justfly.model;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;

import co.edu.icesi.tic.ingesoft.justfly.model.entity.CircleShape;

/**
 * Class that represents an enemy in the game.
 * @author lfrivera
 *
 */
public class Enemy implements IMotionable{

	/**
	 * Position of the player.
	 */
	private Point position;
	
	/**
	 * Width of the enemy.
	 */
	private int width;
	
	/**
	 * Height of the enemy.
	 */
	private int height;
	
	/**
	 * Shape of the enemy.
	 */
	private CircleShape shape;
	
	/**
	 * Constructor of the class.
	 * @param x Horizontal position of the enemy.
	 * @param y Vertical position of the enemy.
	 */
	public Enemy(int x, int y)
	{
		position = new Point(x, y);
		width = height = 100;
		shape = new CircleShape(50, x+50, y+50);
	}
	
	@Override
	public void right() {
		
	}

	@Override
	public void left() {
		
	}

	@Override
	public boolean collision(CircleShape externalShape) {
		return false;
	}
	
	public Image show()
	{
		URL path = (Player.class.getResource("sprites/" + "enemy" + ".gif"));
		Image image = Toolkit.getDefaultToolkit().getImage(path);
		return image;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public CircleShape getShape() {
		return shape;
	}

	public void setShape(CircleShape shape) {
		this.shape = shape;
	}

	
}
