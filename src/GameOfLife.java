import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame{
	//Constants for the size of the window
	private static final int WIDTH = 1360;
	private static final int HEIGHT = 700;
	
	public GameOfLife(){
		setSize(WIDTH, HEIGHT);
		TileGrid grid = new TileGrid();
		add(grid);
		grid.setBackground(Color.RED);
		
	}
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		game.setVisible(true);

	}

}
