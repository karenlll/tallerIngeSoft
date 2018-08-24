package co.edu.icesi.tic.ingesoft.justfly.control;

import co.edu.icesi.tic.ingesoft.justfly.model.Player;
import co.edu.icesi.tic.ingesoft.justfly.view.Canvas;

/**
 * Class that manages the animation of the main player.
 * 
 * @author lfrivera
 *
 */
public class AnimationThread extends Thread {

	/**
	 * Player to be managed.
	 */
	private Player player;

	/**
	 * Animation rate.
	 */
	private long rate;

	/**
	 * Canvas of the game.
	 */
	private Canvas canvas;

	public AnimationThread(Player player, long rate, Canvas canvas) {
		this.player = player;
		this.rate = rate;
		this.canvas = canvas;
	}

	@Override
	public void run() {
		while(true)
		{
			animate();
			try {
				sleep(rate);
			} catch (InterruptedException e) {
				System.exit(0);
			}
			canvas.repaint();
		}
	}
	
	/**
	 * Method that allows to animate the player.
	 */
	private void animate()
	{
		int actualSprite = player.getActualSprite();
		
		if(actualSprite == player.getMaxSprites())
		{
			player.setActualSprite(1);
		}
		else
		{
			actualSprite += 1;
			player.setActualSprite(actualSprite);
		}
	}

}
