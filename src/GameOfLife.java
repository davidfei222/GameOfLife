import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame{
	//The grid of tiles
	private TileGrid grid;
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
		//setBackground(Color.RED);
		grid = new TileGrid();
		add(grid);
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
		while(!game.isActive()){
			System.out.println("entered loop");
			game.updateGrid();
		}
	}

}
