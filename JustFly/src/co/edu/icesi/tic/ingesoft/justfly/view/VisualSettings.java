package co.edu.icesi.tic.ingesoft.justfly.view;

import java.awt.Color;

/**
 * This class contains all the customizable visual settings of the game.
 * 
 * @author lfrivera
 *
 */
public class VisualSettings {

	/**
	 * The unique instance of the class.
	 */
	private static VisualSettings instance;

	/**
	 * The background color of the GUI's buttons.
	 */
	private Color colorButton;
	
	/**
	 * The background color of the control panel.
	 */
	private Color colorControlPanel;

	/**
	 * The background color of the canvas.
	 */
	private Color colorCanvas;

	/**
	 * The background color of the buttons' font.
	 */
	private Color colorFontButton;

	/**
	 * The background color of the score's font.
	 */
	private Color colorFontScore;
	
	/**
	 * Indicates whether the collision shapes are active.
	 */
	private boolean activeShapes;

	/**
	 * Private constructor of the class.
	 */
	private VisualSettings() {

		init();
		activeShapes = false;
	}

	/**
	 * Allows to initialize the settings.
	 */
	private void init() {

	}

	/**
	 * Allows to obtain the unique instance of the class.
	 * 
	 * @return The unique instance of the class.
	 */
	public static VisualSettings getInstance() {

		if (instance == null) {

			instance = new VisualSettings();

		}

		return instance;
	}

	/*
	 * Getters and Setters of the properties.
	 */

	public Color getColorButton() {
		return colorButton;
	}

	public void setColorButton(Color colorButton) {
		this.colorButton = colorButton;
	}
	

	public Color getColorControlPanel() {
		return colorControlPanel;
	}

	public void setColorControlPanel(Color colorControlPanel) {
		this.colorControlPanel = colorControlPanel;
	}

	public Color getColorCanvas() {
		return colorCanvas;
	}

	public void setColorCanvas(Color colorCanvas) {
		this.colorCanvas = colorCanvas;
	}

	public Color getColorFontButton() {
		return colorFontButton;
	}

	public void setColorFontButton(Color colorFontButton) {
		this.colorFontButton = colorFontButton;
	}

	public Color getColorFontScore() {
		return colorFontScore;
	}

	public void setColorFontScore(Color colorFontScore) {
		this.colorFontScore = colorFontScore;
	}

	public boolean isActiveShapes() {
		return activeShapes;
	}

	public void setActiveShapes(boolean activeShapes) {
		this.activeShapes = activeShapes;
	}

}
