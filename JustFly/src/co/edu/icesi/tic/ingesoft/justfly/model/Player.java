package co.edu.icesi.tic.ingesoft.justfly.model;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;

import co.edu.icesi.tic.ingesoft.justfly.model.entity.CircleShape;

/**
 * Class that represents a player of the game.
 * @author lfrivera
 *
 */
public class Player implements IMotionable{
	
	/**
	 * Position of the player.
	 */
	private Point position;
	
	/**
	 * Actual points of the player.
	 */
	private int points;
	
	/**
	 * Actual sprite of the player.
	 */
	private int actualSprite;
	
	/**
	 * The sprite width;
	 */
	private int spriteWidth;
	
	/**
	 * The sprite heigh;
	 */
	private int spriteHeight;
	
	/**
	 * Max number of sprites.
	 */
	private int maxSprites;
	
	/**
	 * Shape of the player.
	 */
	private CircleShape shape;
	
	/**
	 * Constructor of the class.
	 * @param x Horizontal position of the player.
	 * @param y Vertical position of the player.
	 */
	public Player(int x, int y)
	{
		position = new Point(x, y);
		points = 0;
		actualSprite = 1;
		spriteHeight = 100;
		spriteWidth = 100;
		maxSprites = 14;
		shape = new CircleShape(20, x + 55, y + 58);
	}
	
	/**
	 * Method that allows to obtain the actual sprite of the player.
	 * @return Sprite image.
	 */
	public Image show()
	{
		URL path = (Player.class.getResource("sprites/" + actualSprite + ".png"));
		Image image = Toolkit.getDefaultToolkit().getImage(path);
		return image;
	}
	
	@Override
	public void right() {
		
	}

	@Override
	public void left() {
		
	}
	
	/**
	 * Method that allows to move to an upper position.
	 */
	public void up() {

		position.translate(0, -1);
		
	}
	
	/**
	 * Method that allows to move to a lower position.
	 */
	public void down() {
		
		position.translate(0, 1);

	}
	
	/**
	 * Method that allows to sum one point to the player.
	 */
	public void sumOnePoint()
	{
	
	}
	
	@Override
	public boolean collision(CircleShape externalShape) {
		return false;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getActualSprite() {
		return actualSprite;
	}

	public void setActualSprite(int actualSprite) {
		this.actualSprite = actualSprite;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	public int getMaxSprites() {
		return maxSprites;
	}

	public void setMaxSprites(int maxSprites) {
		this.maxSprites = maxSprites;
	}

	public CircleShape getShape() {
		return shape;
	}

	public void setShape(CircleShape shape) {
		this.shape = shape;
	}
	
	

}
