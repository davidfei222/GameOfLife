import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame{
	//Constants for the size of the window
	private static final int WIDTH = 1800;
	private static final int HEIGHT = 900;
	
	public GameOfLife(){
		setSize(WIDTH, HEIGHT);
		setTitle("Conway's Game of Life");
		TileGrid grid = new TileGrid();
		grid.setBackground(Color.RED);
		add(grid);
		
		
	}
	
	/*
	 * Main method
	 */	
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		game.setVisible(true);

	}

}
