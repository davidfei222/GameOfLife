import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

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
	//Constant for the offset between tiles
	private static final int OFFSET = 10;
	//Constant for the grid offset relative to the window
	private static final int GRIDOFFSET = 63;
	//Constants for the size of the panel
	private static final int WIDTH = 1566;
	private static final int HEIGHT = 630;
	//Constants for the number of tiles in the grid;
	private static final int ROWS = 75;
	private static final int COLS = 150;
	
	/**
	 * Constructor for a TileGrid object
	 */
	public TileGrid(){
		setSize(WIDTH, HEIGHT);
		active = true;
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
	 */
	public void updateTiles(){
		
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
		// TODO Auto-generated method stub
		if(active){
			int x = e.getX();
			int y = e.getY();
			findTile(x, y, 0, grid.length);
			repaint();
		}
		
	}
	
	private void findTile(int x, int y, int first, int last){
		if(first >= last){
			return;
		}
		int index = (first+last)/2;
		if(y >= grid[index][0].getYUpper() && y <= grid[index][0].getYLower()){
			for(int i = 0; i < grid[index].length; i++){
				if(grid[index][i].isInTile(x, y)){
					grid[index][i].setState(true);
				}
			}
		}
		if(y < grid[index][0].getYUpper()){
			findTile(x, y, first, index);
		}
		else if(y > grid[index][0].getYUpper()){
			findTile(x, y, index+1, last);
		}
		
	}
	
	/*private Tile[] findRow(int y, int first, int last){
		if(first >= last){
			return null;
		}
		int index = (last-first)/2;
		Tile tile = grid[index][0];
		if(tile.isInTile(x, y))
		if(y < tile.getYUpper()){
			return findRow(y, first, index-1);
		}
		else if(y > tile.getYLower()){
			return findRow(y, index+1, last);
		}
		
	}
	
	private Tile findCol(int x, int first, int last, Tile[] row){
		if(first >= last){
			return null;
		}
		int index = (last-first)/2;
		Tile tile = row[index];
		if(x < tile.getXLeft()){
			return findCol(x, first, index-1, row);
		}
		else if(x > tile.getXRight()){
			return findCol(x, index+1, last, row);
		}
		return row[index];
	}*/

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
