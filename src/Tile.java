import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * A tile object in the grid. Has two states: dead or alive.
 * @author David
 *
 */
public class Tile {
	//The color of the tile (green = alive, black = dead)
	private Color color;
	//The state of the tile (false = dead, true = alive)
	private boolean state;
	//The rectangle defining the boundaries of tile
	private Rectangle2D.Double bound;
	//Dimensions for the rectangle
	private static final int WIDTH = 5;
	
	/**
	 * Constructor for tile objects (initially set to a dead tile)
	 * 
	 * @param  x  The x coordinate of the upper left corner of the tile
	 * @param  y  The y coordinate of the upper left corner of the tile  
	 */
	public Tile(int x, int y){
		color = Color.BLACK;
		state = false;
		bound = new Rectangle2D.Double(x, y, WIDTH, WIDTH);
	}
	
	/**
	 * Sets the state of the tile (true = alive, false = dead)
	 * and changes the color correspondingly
	 * 
	 * @param  state  The new state of the tile
	 */
	public void setState(boolean state){
		this.state = state;
		if(this.state) color = Color.GREEN;
		else color = Color.BLACK;
	}
	
	/**
	 * Draws the tile onto the TileGrid
	 * 
	 * @param  g2  The graphics module
	 */
	public void drawTile(Graphics2D g2){
		g2.setColor(color);
		g2.draw(bound);
		g2.fill(bound);
	}
	
	/**
	 * Check if a given position is inside a tile
	 * @param  x  The x coordinate of the position
	 * @param  y  The y coordinate of the position
	 * @return  true if inside, false if outside
	 */
	public boolean isInTile(int x, int y){
		return bound.contains(x, y);
	}
	
	/**
	 * Returns the tile's state
	 * 
	 * @return  True if tile is alive, false if dead
	 */
	public boolean isAlive(){
		return state;
	}
	
	/**
	 * Returns the tile's color
	 * 
	 * @return  The tile's color
	 */
	public Color getColor(){
		return color;
	}
	
}
