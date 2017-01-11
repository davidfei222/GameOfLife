import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener, ItemListener{
	//The grid being controlled
	private TileGrid grid;
	//Start button
	private JButton start;
	//Reset button
	private JButton reset;
	//Drop-down menu for presets
	private JComboBox<String> presets;
	
	//Constants for size of panel
	private static final int WIDTH = 1501;
	private static final int HEIGHT = 120;
	
	/**
	 * Constructor for the button control panel
	 * 
	 * @param grid  The grid that is being controlled by the buttons
	 */
	public ControlPanel(TileGrid grid){
		setSize(WIDTH, HEIGHT);
		//setBackground(Color.RED);
		start = new JButton("Start game");
		start.addActionListener(this);
		add(start);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		add(reset);
		String[] presetList = {"Select a preset", "Glider", "Small Explosion"};
		presets = new JComboBox<String>(presetList);
		presets.addItemListener(this);
		add(presets);
		this.grid = grid;
	}
	
	/**
	 * Event listener for button presses
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start game")){
			grid.setActive(false);
			grid.updateTiles();
				//System.out.println(grid);
				try{
					Thread.sleep(0);
				}
				catch(Exception exc){
					exc.printStackTrace();
				}
		}
		else if(e.getActionCommand().equals("Reset")){
			grid.resetTiles();
			grid.setActive(true);
		}
	}
	
	/**
	 * Event listener for drop down menu
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(grid.getState()){
			grid.resetTiles();
			if(e.getItem().equals("Glider")){
				grid.setPreset("Glider");
			}
			if(e.getItem().equals("Small Explosion")){
				grid.setPreset("Small Explosion");
			}
		}
	}
}
