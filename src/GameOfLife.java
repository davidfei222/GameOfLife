import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame{
	//The grid of tiles
	private TileGrid grid;
	//Button control panel
	private ControlPanel controls;
	//Constants for the size of the window
	private static final int WIDTH = 1501;
	private static final int HEIGHT = 900;
	
	/**
	 * Constructor for the game window
	 */
	public GameOfLife(){
		setSize(WIDTH, HEIGHT);
		setTitle("Conway's Game of Life");
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//setBackground(Color.RED);
		grid = new TileGrid();
		add(grid);
		controls = new ControlPanel(grid);
		add(controls);
	}
	
	/**
	 * Update the grid by calling grid's update method
	 */
	public void updateGrid(){
		grid.updateTiles();
	}
	
	/**
	 * Return the state of the grid in the window
	 */
	public boolean isActive(){
		return grid.getState();
	}
	
	/*
	 * Main method
	 */	
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		game.setVisible(true);
	}

}
