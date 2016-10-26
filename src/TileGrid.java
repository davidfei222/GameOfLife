import java.awt.*;
import javax.swing.*;

/**
 * Grid of all the tiles in a JPanel
 * @author David
 *
 */
public class TileGrid extends JPanel{
	//2D array containing the grid of tiles
	private Tile[][] grid;
	//Constant for the offset between tiles
	private static final int OFFSET = 7;
	//Constants for the size of the panel
	private static final int WIDTH = 1566;
	private static final int HEIGHT = 630;
	//Constants for the number of tiles in the grid;
	private static final int ROWS = 70;
	private static final int COLS = 174;
	
	/**
	 * Constructor for a TileGrid object
	 */
	public TileGrid(){
		setSize(WIDTH, HEIGHT);
		//setBackground(Color.RED);
		grid = new Tile[ROWS][COLS];
		int x = OFFSET*9;
		int y = OFFSET*9;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Tile(x, y);
				x += OFFSET;
			}
		x = OFFSET*9;
		y += OFFSET;
		}
	}
	
	/**
	 * Draws the grid onto the panel
	 * 
	 * @param  g  The graphics module
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j].drawTile(g2);
			}
		}
	}
}
