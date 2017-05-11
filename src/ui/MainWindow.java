package ui;

import javax.swing.JFrame;

import models.Bord;

import java.awt.Color;

public class MainWindow {
	 private Bord bord;
	private JFrame frame;

	/**
	 * Launch the application.
	 */


	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public MainWindow(Bord bord) {
		this.bord = bord;
		bord.show();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
