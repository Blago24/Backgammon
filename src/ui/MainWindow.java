package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.ws.api.pipe.Engine;

import logic.GameEngine;
import models.Bord;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.JButton;

public class MainWindow {
	private Bord bord;
	private GameEngine engine;

	private JFrame frame;

	private JLabel currentPiece = null;

	private JLabel background = null;
	private JTextField firstDice;
	
	private JTextField secondDice;
	
	private JButton topOne;
	private JButton topTwo;
	private JButton topThree;
	private JButton topFour;
	private JButton topFive;
	private JButton topSix;
	private JButton topSeven;
	private JButton topEight;
	private JButton topNine;
	private JButton topTen;
	private JButton topEleven;
	private JButton topTwelve;

	private JButton botOne;
	private JButton botTwo;
	private JButton botThree;
	private JButton botFour;
	private JButton botFive;
	private JButton botSix;
	private JButton botSeven;
	private JButton botEight;
	private JButton botNine;
	private JButton botTen;
	private JButton botEleven;
	private JButton botTwelve;

	/**
	 * Launch the application.
	 */

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public void runTheGame() {
		engine.gameRunning(this.bord);
		setBackground();

	}

	public MainWindow() {
		initialize();

	}

	public void setBackground() {
		frame.getContentPane().add(background);
	}

	public void setMainWindow(MainWindow window) {
		engine.setWindow(window);
	}

	public void setBord(Bord bord) {
		this.bord = bord;
	}

	public void showPictureForCurrentPosition(int row, int col, int sizeOfCurrentPosition, boolean isItWhite) {
		int numberOfPictures = numberOfPicturesAtCurrentPosition(sizeOfCurrentPosition);

		for (int counterForPics = 0; counterForPics < numberOfPictures; counterForPics++) {

			if (isItWhite == true) {
				chooseWhitePiecesPicture(row, col, sizeOfCurrentPosition, counterForPics);
			} else {
				chooseBlackPiecesPicture(row, col, sizeOfCurrentPosition, counterForPics);
			}
			sizeOfCurrentPosition -= 5;
			frame.getContentPane().add(currentPiece);

		}

	}

	private void chooseBlackPiecesPicture(int row, int col, int sizeOfCurrentPosition, int counterForPics) {

		currentPiece = new JLabel("");
		currentPiece.setText("");

		currentPiece.setBounds(new Rectangle(bord.getXPosition(col, counterForPics),
				bord.getYPosition(row, sizeOfCurrentPosition), 69, 345));

		String pathToPicture;
		if (sizeOfCurrentPosition > 5) {
			pathToPicture = getPathToBlackPictures(5);
		} else {
			pathToPicture = getPathToBlackPictures(sizeOfCurrentPosition);
		}
		currentPiece.setIcon(new ImageIcon(pathToPicture));

	}

	private String getPathToBlackPictures(int sizeOfCurrentPosition) {
		switch (sizeOfCurrentPosition) {
		case 1:
			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\black1.png";

		case 2:
			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\black2.png";
		case 3:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\black3.png";
		case 4:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\black4.png";
		case 5:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\black5.png";

		}
		return null;

	}

	private void chooseWhitePiecesPicture(int row, int col, int sizeOfCurrentPosition, int counterForPics) {

		currentPiece = new JLabel("");
		currentPiece.setText("");

		currentPiece.setBounds(new Rectangle(bord.getXPosition(col, counterForPics),
				bord.getYPosition(row, sizeOfCurrentPosition), 69, 345));
		String pathToPicture;
		if (sizeOfCurrentPosition > 5) {
			pathToPicture = getPathToWhitePictures(5);
		} else {
			pathToPicture = getPathToWhitePictures(sizeOfCurrentPosition);
		}

		currentPiece.setIcon(new ImageIcon(pathToPicture));

	}

	private String getPathToWhitePictures(int sizeOfCurrentPosition) {
		switch (sizeOfCurrentPosition) {
		case 1:
			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\white1.png";

		case 2:
			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\white2.png";
		case 3:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\white3.png";
		case 4:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\white4.png";
		case 5:

			return "C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\white5.png";

		}
		return null;

	}

	private int numberOfPicturesAtCurrentPosition(int sizeOfCurrentPosition) {
		if (sizeOfCurrentPosition <= 5) {
			return 1;
		} else if (sizeOfCurrentPosition > 5 && sizeOfCurrentPosition <= 10) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		engine = new GameEngine();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);

		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\bg.jpg"));
		background.setText("");
		background.setBounds(0, 0, 910, 690);

		frame.getContentPane().add(background);

		firstDice = new JTextField();
		firstDice.setEditable(false);
		firstDice.setBounds(91, 302, 86, 20);
		frame.getContentPane().add(firstDice);
		firstDice.setColumns(10);

		JButton btnTrow = new JButton("trow");
		btnTrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int points = engine.trowDice();

				firstDice.setText(points + "");
			}
		});
		btnTrow.setBounds(272, 301, 89, 23);
		frame.getContentPane().add(btnTrow);

		
		secondDice = new JTextField();
		secondDice.setEditable(false);
		secondDice.setBounds(178, 302, 86, 20);
		// myFirstDice.setVisible(false);
		frame.getContentPane().add(secondDice);
		secondDice.setColumns(10);

		

		topOne = new JButton("");
		topOne.setBounds(0, 0, 69, 255);
		topOne.setOpaque(false);
		topOne.setContentAreaFilled(false);
		topOne.setBorderPainted(false);
		topOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");			}
		});
		frame.getContentPane().add(topOne);
		
		topTwo = new JButton("");
		topTwo.setBounds(76, 0, 69, 255);
		topTwo.setOpaque(false);
		topTwo.setContentAreaFilled(false);
		topTwo.setBorderPainted(false);
		topTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});
		frame.getContentPane().add(topTwo);

		topThree = new JButton("");
		topThree.setBounds(149, 0, 69, 255);
		topThree.setOpaque(false);
		topThree.setContentAreaFilled(false);
		topThree.setBorderPainted(false);
		topThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("3");			}
		});

		frame.getContentPane().add(topThree);

		topFour = new JButton("");
		topFour.setBounds(221, 0, 69, 255);
		topFour.setOpaque(false);
		topFour.setContentAreaFilled(false);
		topFour.setBorderPainted(false);
		topFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("4");			}
		});
		topFour.setBounds(221, 0, 69, 255);
		frame.getContentPane().add(topFour);

		topFive = new JButton("");
		topFive.setBounds(291, 0, 69, 255);
		topFive.setOpaque(false);
		topFive.setContentAreaFilled(false);
		topFive.setBorderPainted(false);
		topFive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("5");			}
		});

		frame.getContentPane().add(topFive);

		topSix = new JButton("");
		topSix.setBounds(362, 0, 69, 255);
		topSix.setOpaque(false);
		topSix.setContentAreaFilled(false);
		topSix.setBorderPainted(false);
		topSix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("6");			}
		});

		frame.getContentPane().add(topSix);

		topSeven = new JButton("");
		topSeven.setBounds(463, 0, 69, 255);
		topSeven.setOpaque(false);
		topSeven.setContentAreaFilled(false);
		topSeven.setBorderPainted(false);
		topSeven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("7");			}
		});

		frame.getContentPane().add(topSeven);

		topEight = new JButton("");
		topEight.setBounds(533, 0, 69, 255);
		topEight.setOpaque(false);
		topEight.setContentAreaFilled(false);
		topEight.setBorderPainted(false);
		topEight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("8");			}
		});

		frame.getContentPane().add(topEight);

		topNine = new JButton("");
		topNine.setBounds(605, 0, 69, 255);
		topNine.setOpaque(false);
		topNine.setContentAreaFilled(false);
		topNine.setBorderPainted(false);
		topNine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("9");			}
		});

		frame.getContentPane().add(topNine);

		topTen = new JButton("");
		topTen.setBounds(676, 0, 69, 255);
		topTen.setOpaque(false);
		topTen.setContentAreaFilled(false);
		topTen.setBorderPainted(false);
		topTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("10");			}
		});

		frame.getContentPane().add(topTen);

		topEleven = new JButton("");
		topEleven.setBounds(748, 0, 69, 255);
		topEleven.setOpaque(false);
		topEleven.setContentAreaFilled(false);
		topEleven.setBorderPainted(false);
		topEleven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("11");			}
		});

		frame.getContentPane().add(topEleven);

		topTwelve = new JButton("");
		topTwelve.setBounds(820, 0, 69, 255);
		topTwelve.setOpaque(false);
		topTwelve.setContentAreaFilled(false);
		topTwelve.setBorderPainted(false);
		topTwelve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("12");			}
		});

		frame.getContentPane().add(topTwelve);

		botOne = new JButton("");
		botOne.setBounds(0, 435, 69, 255);
		botOne.setOpaque(false);
		botOne.setContentAreaFilled(false);
		botOne.setBorderPainted(false);
		botOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");			}
		});
		frame.getContentPane().add(botOne);
		botTwo = new JButton("");
		botTwo.setBounds(76, 435, 69, 255);
		botTwo.setOpaque(false);
		botTwo.setContentAreaFilled(false);
		botTwo.setBorderPainted(false);
		botTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});
		frame.getContentPane().add(botTwo);

		botThree = new JButton("");
		botThree.setBounds(149, 435, 69, 255);
		botThree.setOpaque(false);
		botThree.setContentAreaFilled(false);
		botThree.setBorderPainted(false);
		botThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("3");			}
		});

		frame.getContentPane().add(botThree);

		botFour = new JButton("");
		botFour.setBounds(221, 435, 69, 255);
		botFour.setOpaque(false);
		botFour.setContentAreaFilled(false);
		botFour.setBorderPainted(false);
		botFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("4");			}
		});
		
		frame.getContentPane().add(botFour);

		botFive = new JButton("");
		botFive.setBounds(291, 435, 69, 255);
		botFive.setOpaque(false);
		botFive.setContentAreaFilled(false);
		botFive.setBorderPainted(false);
		botFive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("5");			}
		});

		frame.getContentPane().add(botFive);

		botSix = new JButton("");
		botSix.setBounds(362, 435, 69, 255);
		botSix.setOpaque(false);
		botSix.setContentAreaFilled(false);
		botSix.setBorderPainted(false);
		botSix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("6");			}
		});

		frame.getContentPane().add(botSix);

		botSeven = new JButton("");
		botSeven.setBounds(463, 435, 69, 255);
		botSeven.setOpaque(false);
		botSeven.setContentAreaFilled(false);
		botSeven.setBorderPainted(false);
		botSeven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("7");			}
		});

		frame.getContentPane().add(botSeven);

		botEight = new JButton("");
		botEight.setBounds(533, 435, 69, 255);
		botEight.setOpaque(false);
		botEight.setContentAreaFilled(false);
		botEight.setBorderPainted(false);
		botEight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("8");			}
		});

		frame.getContentPane().add(botEight);

		botNine = new JButton("");
		botNine.setBounds(605, 435, 69, 255);
		botNine.setOpaque(false);
		botNine.setContentAreaFilled(false);
		botNine.setBorderPainted(false);
		botNine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("9");			}
		});

		frame.getContentPane().add(botNine);

		botTen = new JButton("");
		botTen.setBounds(676, 435, 69, 255);
		botTen.setOpaque(false);
		botTen.setContentAreaFilled(false);
		botTen.setBorderPainted(false);
		botTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("10");			}
		});

		frame.getContentPane().add(botTen);

		botEleven = new JButton("");
		botEleven.setBounds(748, 435, 69, 255);
		botEleven.setOpaque(false);
		botEleven.setContentAreaFilled(false);
		botEleven.setBorderPainted(false);
		botEleven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("11");			}
		});

		frame.getContentPane().add(botEleven);

		botTwelve = new JButton("");
		botTwelve.setBounds(820, 435, 69, 255);
		botTwelve.setOpaque(false);
		botTwelve.setContentAreaFilled(false);
		botTwelve.setBorderPainted(false);
		botTwelve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("12");			}
		});

		frame.getContentPane().add(botTwelve);
		
		
		frame.setBounds(200, 200, 909, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void setBotOne(Boolean type) {
		botOne.setEnabled(type);
	}
	public void setBotTwo(Boolean type) {
		botTwo.setEnabled(type);
	}
	public void setBotThree(Boolean type) {
		botThree.setEnabled(type);
	}
	public void setBotFour(Boolean type) {
		botFour.setEnabled(type);
	}
	public void setBotFive(Boolean type) {
		botFive.setEnabled(type);
	}
	public void setBotSix(Boolean type) {
		botSix.setEnabled(type);
	}
	public void setBotSeven(Boolean type) {
		botSeven.setEnabled(type);
	}
	public void setBotEight(Boolean type) {
		botEight.setEnabled(type);
	}
	public void setBotNine(Boolean type) {
		botNine.setEnabled(type);
	}
	public void setBotTen(Boolean type) {
		botTen.setEnabled(type);
	}
	public void setBotEleven(Boolean type) {
		botEleven.setEnabled(type);
	}
	public void setBotTwelve(Boolean type) {
		botTwelve.setEnabled(type);
	}
	
	public void setTopOne(Boolean type) {
		topOne.setEnabled(type);
	}
	public void setTopTwo(Boolean type) {
		topTwo.setEnabled(type);
	}
	public void setTopThree(Boolean type) {
		topThree.setEnabled(type);
	}
	public void setTopFour(Boolean type) {
		topFour.setEnabled(type);
	}
	public void setTopFive(Boolean type) {
		topFive.setEnabled(type);
	}
	public void setTopSix(Boolean type) {
		topSix.setEnabled(type);
	}
	public void setTopSeven(Boolean type) {
		topSeven.setEnabled(type);
	}
	public void setTopEight(Boolean type) {
		topEight.setEnabled(type);
	}
	public void setTopNine(Boolean type) {
		topNine.setEnabled(type);
	}
	public void setTopTen(Boolean type) {
		topTen.setEnabled(type);
	}
	public void setTopEleven(Boolean type) {
		topEleven.setEnabled(type);
	}
	public void setTopTwelve(Boolean type) {
		topTwelve.setEnabled(type);
	}
}
