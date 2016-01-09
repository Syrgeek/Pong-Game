import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	JPanel panel = new JPanel();
	JButton btnNewButton = new JButton("");
	JRadioButton rdbtnNewRadioButton = new JRadioButton("");
	JLabel label = new JLabel("0 hits, 0 misses");
	private final JLabel lblOsamaFathy = new JLabel("Osama & Hassan");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					View window = new View();
					
					
					
					Controller co = new Controller();
					co.model = new Model();
					co.view = window;
					window.frame.setVisible(true);
					co.play();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 628, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 398, 612, 15);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		label.setBounds(10, 0, 106, 14);
		panel.add(label);
		lblOsamaFathy.setBounds(496, 0, 116, 14);
		
		panel.add(lblOsamaFathy);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(228, 11, 150, 23);
		frame.getContentPane().add(btnNewButton);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		
	
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(Color.YELLOW);
		rdbtnNewRadioButton.setBounds(286, 328, 21, 15);
		frame.getContentPane().add(rdbtnNewRadioButton);
	}
	public void update(Model model){
		label.setText(model.hits + " hits, " + model.misses + " misses");
		System.out.println(btnNewButton.getText());
		btnNewButton.setBounds(model.paddle , 11, 150, 23);
		System.out.println(btnNewButton.getBounds());
		rdbtnNewRadioButton.setBounds(model.ballx, model.bally, 21, 15);
		frame.getContentPane().add(btnNewButton);
		frame.repaint();
		
	}
}
