package co.edu.icesi.tic.ingesoft.justfly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.icesi.tic.ingesoft.justfly.model.Enemy;
import co.edu.icesi.tic.ingesoft.justfly.model.Player;

/**
 * Class that represents the canvas of the game.
 * @author lfrivera
 *
 */
@SuppressWarnings("serial")
public class Canvas extends JPanel{

	private boolean showShapes;
	
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
	 * Constructor of the class.
	 */
	public Canvas(Player player,  ArrayList<Enemy> fixedEnemies, ArrayList<Enemy> randomEnemies)
	{
		this.player = player;
		this.fixedEnemies = fixedEnemies;
		this.randomEnemies = randomEnemies;
		init();
	}
	
	/**
	 * Method that allows to initialize the canvas.
	 */
	private void init()
	{
		setSize(getMaximumSize());
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		showShapes = VisualSettings.getInstance().isActiveShapes();
		super.paintComponent(g);
		drawEnemies(g);
		drawPlayer(g);
		showScore(g);
		setBackground(VisualSettings.getInstance().getColorCanvas());
	}
	
	/**
	 * Allows to draw the player.
	 * @param g Graphics
	 */
	private void drawPlayer(Graphics g)
	{
		g.drawImage(player.show(), player.getPosition().x, player.getPosition().y, player.getSpriteWidth(), player.getSpriteHeight(), this);
		if(showShapes){
		g.setColor(Color.red);
		g.drawOval(player.getShape().getPosition().x - player.getShape().getRadius(), player.getShape().getPosition().y - player.getShape().getRadius(), player.getShape().getRadius()*2, player.getShape().getRadius()*2);
		}
		}
	
	/**
	 * Allows to draw enemies.
	 * @param g Graphics
	 */
	private void drawEnemies(Graphics g)
	{
		
		for(Enemy e:randomEnemies)
		{
			g.drawImage(e.show(), e.getPosition().x, e.getPosition().y, e.getWidth(), e.getHeight(), this);
			if(showShapes){
			g.setColor(Color.red);
			g.drawOval(e.getShape().getPosition().x - e.getShape().getRadius(), e.getShape().getPosition().y - e.getShape().getRadius(), e.getShape().getRadius()*2, e.getShape().getRadius()*2);
			}
		}
		
		for(Enemy e:fixedEnemies)
		{
			g.drawImage(e.show(), e.getPosition().x, e.getPosition().y, e.getWidth(), e.getHeight(), this);
			if(showShapes){
			g.setColor(Color.red);
			g.drawOval(e.getShape().getPosition().x - e.getShape().getRadius(), e.getShape().getPosition().y - e.getShape().getRadius(), e.getShape().getRadius()*2, e.getShape().getRadius()*2);
			}
		}
	}
	
	private void showScore(Graphics g)
	{
		g.setColor(VisualSettings.getInstance().getColorFontScore());
		g.setFont(new Font("ComicSans", 50, 50));
		g.drawString("Score: "+player.getPoints(), 100, 460);
	}
}
