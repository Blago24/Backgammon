package ui;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Bord;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\background.jpg"));
		lblNewLabel.setBounds(0, 0, 900, 690);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(200, 200, 900, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}
