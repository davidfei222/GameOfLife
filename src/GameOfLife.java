import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameOfLife extends JFrame {
	//The grid of tiles
	private TileGrid grid;
	//Button control panel
	private ControlPanel controls;
	//Layout manager
	private BoxLayout layout;
	
	//Constants for the size of the window
	private static final int WIDTH = 1501;
	private static final int HEIGHT = 825;
	
	/**
	 * Constructor for the game window
	 */
	public GameOfLife(){
		setSize(WIDTH, HEIGHT);
		setTitle("Conway's Game of Life");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		getContentPane().setLayout(layout);
		grid = new TileGrid();
		grid.setMaximumSize(new Dimension(WIDTH, HEIGHT-43));
		add(grid);
		controls = new ControlPanel(grid);
		controls.setMaximumSize(new Dimension(WIDTH, 43));
		add(controls);
	}
	
	/*
	 * Main method
	 */	
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		game.setVisible(true);
	}

}
