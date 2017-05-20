package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.sun.java.swing.plaf.windows.resources.windows;

import models.Bord;

import javax.swing.JButton;

public class StartingWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingWindow window = new StartingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(175, 131, 89, 23);

		frame.getContentPane().add(btnStart);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bord gameBord = new Bord();
				gameBord.iniBord();
				gameBord.show();
				gameBord.showColor();
				frame.dispose();
					MainWindow mainWindow = new MainWindow();
					mainWindow.setBord(gameBord);
					mainWindow.setMainWindow(mainWindow);
					mainWindow.runTheGame();
					mainWindow.getFrame().setVisible(true);
				
			}

		});
	}
}
