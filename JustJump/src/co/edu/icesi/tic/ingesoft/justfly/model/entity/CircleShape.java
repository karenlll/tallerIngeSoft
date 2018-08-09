package co.edu.icesi.tic.ingesoft.justfly.model.entity;

import java.awt.Point;

/**
 * Class that represents a circle.
 * @author lfrivera
 *
 */
public class CircleShape {
	
	/**
	 * Radius of the circle.
	 */
	private int radius;

	/**
	 * Position of the circle.
	 */
	private Point position;

	/**
	 * Constructor of the class.
	 * @param radius Radius of the circle.
	 * @param x Horizontal position of the circle.
	 * @param y Vertical position of the circle.
	 */
	public CircleShape(int radius, int x, int y) {
		this.radius = radius;
		this.position = new Point(x, y);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	
}
