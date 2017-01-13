import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener, ItemListener {
	//The grid being controlled
	private TileGrid grid;
	//Start button
	private JButton start;
	//Reset button
	private JButton reset;
	//Drop-down menu and label for presets
	private JLabel presetLabel;
	private JComboBox<String> presets;
	//Text field and label for number iterations to run
	private JLabel itrLabel;
	private JTextField iterations;
	
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
		
		itrLabel = new JLabel("Number of iterations to run:");
		add(itrLabel);
		iterations = new JTextField("50", 5);
		add(iterations);
		
		start = new JButton("Start game");
		start.addActionListener(this);
		add(start);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		add(reset);
		
		presetLabel = new JLabel("Preset configurations:");
		add(presetLabel);
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
			String runs = iterations.getText();
			int numRuns = Integer.parseInt(runs);
			for(int i = 0; i < numRuns; i++){
				grid.updateTiles();
				try{
					Thread.sleep(30);
				}
				catch(Exception exc){
					exc.printStackTrace();
				}
			}
			grid.setActive(true);
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
