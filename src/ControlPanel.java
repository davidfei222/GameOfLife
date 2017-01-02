import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel{
	//Start button
	JButton start;
	//Reset button
	JButton reset;
	
	
	/**
	 * Constructor for the button control panel
	 * 
	 * @param grid  The grid that is being controlled by the buttons
	 */
	public ControlPanel(TileGrid grid){
		start = new JButton("Start game");
		reset = new JButton("Reset grid");
	}
}
