import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Grid of all the tiles in a JPanel
 * @author David
 *
 */
@SuppressWarnings("serial")
public class TileGrid extends JPanel implements MouseListener{
	//2D array containing the grid of tiles
	private Tile[][] grid;
	//Whether the grid is active or not (true = active, false = inactive)
	private boolean active;
	//Hash map that records active tiles
	private HashMap<Integer, Tile> activeTiles;
	//Constant for the offset between tiles
	private static final int OFFSET = 10;
	//Constant for the grid offset relative to the window
	private static final int GRIDOFFSET = 1;
	//Constants for the size of the panel
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 630;
	//Constants for the number of tiles in the grid;
	private static final int ROWS = 77;
	private static final int COLS = 150;
	
	/**
	 * Constructor for a TileGrid object
	 */
	public TileGrid(){
		setSize(WIDTH, HEIGHT);
		active = true;
		activeTiles = new HashMap<Integer, Tile>(225);
		grid = new Tile[ROWS][COLS];
		int x = GRIDOFFSET;
		int y = GRIDOFFSET;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Tile(x, y, i, j);
				x += OFFSET;
			}
		x = GRIDOFFSET;
		y += OFFSET;
		}
		addMouseListener(this);
	}
	
	/**
	 * Set the grid as active or inactive
	 * 
	 * @param state  boolean for the new state
	 */
	public void setActive(boolean state){
		active = state;
	}
	
	/**
	 * Reset the grid to its starting state
	 */
	public void resetTiles(){
		grid = new Tile[ROWS][COLS];
		int x = GRIDOFFSET;
		int y = GRIDOFFSET;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Tile(x, y, i, j);
				x += OFFSET;
			}
		x = GRIDOFFSET;
		y += OFFSET;
		}
	}
	
	/**
	 * Update the tiles around each tile that is alive
	 * 
	 * Rules of the game:
	 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * Any live cell with more than three live neighbours dies, as if by overpopulation.
	 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 */
	public void updateTiles(){
		//if(!active){
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				int numAlive = 0;
				ArrayList<Tile> neighbors = new ArrayList<Tile>();
				neighbors.add(grid[x][y-1]);
				neighbors.add(grid[x-1][y-1]);
				neighbors.add(grid[x+1][y-1]);
				neighbors.add(grid[x-1][y]);
				neighbors.add(grid[x+1][y]);
				neighbors.add(grid[x][y+1]);
				neighbors.add(grid[x-1][y+1]);
				neighbors.add(grid[x+1][y+1]);
				for(int i = 0; i < neighbors.size(); i++){
					if(neighbors.get(i).isAlive()){
						numAlive++;
					}
				}
				if(grid[x][y].isAlive() && (numAlive < 2 || numAlive > 3)){
					grid[x][y].setState(false);
					repaint(grid[x][y].getXLeft(), grid[x][y].getYUpper(), OFFSET, OFFSET);
				}
				else if(!grid[x][y].isAlive() && numAlive == 3){
					grid[x][y].setState(true);
					repaint(grid[x][y].getXLeft(), grid[x][y].getYUpper(), OFFSET, OFFSET);
				}
			}	
		}
		//}
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
	
	////////////////////////////////////
	// METHODS FOR THE MOUSE LISTENER //
	////////////////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
		if(active){ 
			int x = e.getX();
			int y = e.getY();
			Tile tile = findTile(x, y, 0, grid.length);
			repaint(tile.getXLeft(), tile.getYUpper(), OFFSET, OFFSET);
			activeTiles.put(tile.hashCode(), tile);
		}
		
	}
	
	//Private helper method for mouseClicked
	//Uses binary search to find the row of the tile clicked
	//Then uses a linear search to find the tile within that row and set it to be alive
	//Complexity: O(NlogN)
	private Tile findTile(int x, int y, int first, int last){
		if(first >= last){
			return null;
		}
		int index = (first+last)/2;
		if(y >= grid[index][0].getYUpper() && y <= grid[index][0].getYLower()){
			for(int i = 0; i < grid[index].length; i++){
				if(grid[index][i].isInTile(x, y)){
					grid[index][i].setState(true);
					return grid[index][i];
				}
			}
		}
		if(y < grid[index][0].getYUpper()){
			return findTile(x, y, first, index);
		}
		else if(y > grid[index][0].getYUpper()){
			return findTile(x, y, index+1, last);
		}
		return null;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
