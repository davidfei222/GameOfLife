import java.applet.*;

@SuppressWarnings("serial")
public class GameOfLifeApplet extends Applet{
	@Override
	public void init(){
		TileGrid grid = new TileGrid();
		this.add(grid);
	}
}
