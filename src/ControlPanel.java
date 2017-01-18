import java.awt.event.*;
import javax.swing.*;

/**
 * Control panel used to set up the game
 * 
 * @author david
 *
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ActionListener, ItemListener {
	//The grid being controlled
	private TileGrid grid;
	//Start button
	private JButton start;
	//Reset button
	private JButton reset;
	//Resume button
	private JButton resume;
	//Stop button
	private JButton stop;
	
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
		
		/*itrLabel = new JLabel("Number of iterations to run:");
		add(itrLabel);
		iterations = new JTextField("50", 5);
		add(iterations);*/
		
		start = new JButton("Start game");
		start.addActionListener(this);
		add(start);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		add(reset);
		resume = new JButton("Resume");
		resume.addActionListener(this);
		add(resume);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		add(stop);
		
		presetLabel = new JLabel("Preset configurations:");
		add(presetLabel);
		String[] presetList = {"Select a preset", "Glider", "Small Explosion", "Gosper Glider Gun"};
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
			//String runs = iterations.getText();
			//int numRuns = Integer.parseInt(runs);
			//grid.setIterations(numRuns);
			grid.setActive(false);
			grid.updateTiles();
		}
		else if(e.getActionCommand().equals("Resume")){
			grid.setActive(false);
		}
		else if(e.getActionCommand().equals("Reset") && grid.getState()){
			grid.resetTiles();
		}
		else if(e.getActionCommand().equals("Stop")){
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
			else if(e.getItem().equals("Small Explosion")){
				grid.setPreset("Small Explosion");
			}
			else if(e.getItem().equals("Gosper Glider Gun")){
				grid.setPreset("Gosper Glider Gun");
			}
		}
	}
}
