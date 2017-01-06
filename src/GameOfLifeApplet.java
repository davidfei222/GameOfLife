import java.applet.*;
import java.awt.*;

public class GameOfLifeApplet extends Applet{
	@Override
	public void init(){
		TileGrid grid = new TileGrid();
		this.add(grid);
	}
}
