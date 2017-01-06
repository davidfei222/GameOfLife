import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener{
	//The grid being controlled
	private TileGrid grid;
	//Start button
	private JButton start;
	//Reset button
	private JButton reset;
	
	//Constants for size of panel
	private static final int WIDTH = 1501;
	private static final int HEIGHT = 100;
	
	/**
	 * Constructor for the button control panel
	 * 
	 * @param grid  The grid that is being controlled by the buttons
	 */
	public ControlPanel(TileGrid grid){
		setSize(WIDTH, HEIGHT);
		start = new JButton("Start game");
		start.addActionListener(this);
		add(start);
		reset = new JButton("Reset grid");
		reset.addActionListener(this);
		add(reset);
		this.grid = grid;
	}
	
	/**
	 * Event listener for button presses
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Start game")){
			//System.out.println("start");
			grid.setActive(false);
			for(int i = 0; i < 10; i++){
				grid.updateTiles();
				/*try{
					Thread.sleep(200);
				}
				catch(Exception exc){
					exc.printStackTrace();
				}*/
			}
		}
		else if(e.getActionCommand().equals("Reset grid")){
			//System.out.println("reset");
			grid.resetTiles();
			grid.setActive(true);
		}
	}
}
