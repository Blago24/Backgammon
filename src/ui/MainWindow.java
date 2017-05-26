package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.ws.api.pipe.Engine;

import logic.GameEngine;
import models.Bord;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
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
	private JButton btnTrow;
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
	private JTextField whiteField;
	private JTextField blackField;
	private JTextField textField;

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
		// setBackground();

	}

	public MainWindow() {
		initialize();

	}

	public boolean areThereAnyPics() {
		if (currentPiece == null) {
			return false;
		}
		return true;

	}

	public void setBackground() {
		frame.getContentPane().add(background);
	}

	public void setMainWindow(MainWindow window) {
		engine.setWindow(this);
	}

	public void setBord(Bord bord) {
		this.bord = bord;
	}

	public void showPictureForCurrentPosition(int row, int col, int sizeOfCurrentPosition, boolean isItWhite) {
		int numberOfPictures = numberOfPicturesAtCurrentPosition(sizeOfCurrentPosition);
		System.out.println("NUMBER=====");
		for (int counterForPics = 0; counterForPics < numberOfPictures; counterForPics++) {
			System.out.println("NUMBER=" + sizeOfCurrentPosition);
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
	public void removePictures() {
		frame.getContentPane().remove(currentPiece);
	}

	public void setDice(boolean type) {
		if (type == true) {

			btnTrow.setVisible(true);

		} else {

			btnTrow.setVisible(false);
		}
	}

	private void initialize() {

		engine = new GameEngine();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);

		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\bg.jpg"));
		background.setText("");
		background.setBounds(0, 0, 910, 690);

		 //frame.getContentPane().add(background);
		setAllButtons();

		frame.setBounds(200, 200, 909, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setAllButtons() {
		firstDice = new JTextField();
		firstDice.setEditable(false);
		firstDice.setBounds(91, 302, 86, 20);

		frame.getContentPane().add(firstDice);
		firstDice.setColumns(10);

		btnTrow = new JButton("trow");
		btnTrow.setBounds(272, 301, 89, 23);
		btnTrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (engine.getFirstDice() == 0 && engine.getSecondDice() == 0) {
					engine.setWhiteTurn(!engine.isWhiteTurn());
					engine.gameRunning(bord);
				}
				int points = engine.trowDice();
				engine.setFirstDice(points);
				firstDice.setText(points + "");
				points = engine.trowDice();
				engine.setSecondDice(points);
				secondDice.setText(points + "");
				engine.hideDiceButton();
				//engine.putTakenPieces(bord);

			}
		});

		frame.getContentPane().add(btnTrow);

		secondDice = new JTextField();
		secondDice.setEditable(false);
		secondDice.setBounds(178, 302, 86, 20);
		frame.getContentPane().add(secondDice);
		secondDice.setColumns(10);

		topOne = new JButton("");
		topOne.setBounds(0, 0, 69, 255);
		topOne.setOpaque(false);
		topOne.setContentAreaFilled(false);
		topOne.setBorderPainted(false);
		// topOne.setBackground(Color.GREEN);
		topOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked(0, 0);

			}
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
				buttonClicked(0, 1);
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
				buttonClicked(0, 2);
			}
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
				buttonClicked(0, 3);
			}
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
				buttonClicked(0, 4);
			}
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
				buttonClicked(0, 5);

			}
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
				buttonClicked(0, 6);
			}
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
				buttonClicked(0, 7);
			}
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
				buttonClicked(0, 8);
			}
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
				buttonClicked(0, 9);
			}
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
				buttonClicked(0, 10);
			}
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
				buttonClicked(0, 11);
			}
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
				buttonClicked(1, 0);
			}
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
				buttonClicked(1, 1);
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
				buttonClicked(1, 2);
			}
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
				buttonClicked(1, 3);
			}
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
				buttonClicked(1, 4);
			}
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
				buttonClicked(1, 5);
			}
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
				buttonClicked(1, 6);
			}
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
				buttonClicked(1, 7);
			}
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
				buttonClicked(1, 8);
			}
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
				buttonClicked(1, 9);
			}
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
				buttonClicked(1, 10);
			}
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
				buttonClicked(1, 11);

			}
		});

		frame.getContentPane().add(botTwelve);
		
		whiteField = new JTextField();
		whiteField.setEditable(false);
		whiteField.setBounds(434, 343, 29, 20);
		frame.getContentPane().add(whiteField);
		whiteField.setColumns(10);
		whiteField.setText(engine.getTakenWhite()+"");
		
		blackField = new JTextField();
		blackField.setBackground(Color.GRAY);
		blackField.setEditable(false);
		blackField.setColumns(10);
		blackField.setBounds(434, 364, 29, 20);
		frame.getContentPane().add(blackField);
		blackField.setText(engine.getTakenBlack()+"");

	}

	public void buttonClicked(int row, int col) {
		engine.setCurrentButtonClickedRow(row);
		engine.setCurrentButtonClickedCol(col);
		System.out.println("ismoving=" + engine.isPieceIsMoveing());
		if (engine.isPieceIsMoveing()) {
			engine.movePiece(bord);

		} else {

			engine.makeTurn(bord);
			if (!engine.isCheckForPosiblePositions()) {
				engine.gameRunning(bord);
			} else {
				engine.setPieceIsMoveing(true);
				engine.setCheckForPosiblePositions(false);
			}
		}
	}

	public void setColorBotOne() {

		botOne.setOpaque(true);
		botOne.setContentAreaFilled(true);
		botOne.setBackground(Color.green);
	}

	public void setColorBotTwo() {

		botTwo.setOpaque(true);
		botTwo.setContentAreaFilled(true);
		botTwo.setBackground(Color.green);
	}

	public void setColorBotThree() {

		botThree.setOpaque(true);
		botThree.setContentAreaFilled(true);
		botThree.setBackground(Color.green);
	}

	public void setColorBotFour() {

		botFour.setOpaque(true);
		botFour.setContentAreaFilled(true);
		botFour.setBackground(Color.green);
	}

	public void setColorBotFive() {

		botFive.setOpaque(true);
		botFive.setContentAreaFilled(true);
		botFive.setBackground(Color.green);
	}

	public void setColorBotSix() {

		botSix.setOpaque(true);
		botSix.setContentAreaFilled(true);
		botSix.setBackground(Color.green);
	}

	public void setColorBotSeven() {

		botSeven.setOpaque(true);
		botSeven.setContentAreaFilled(true);
		botSeven.setBackground(Color.green);
	}

	public void setColorBotEight() {

		botEight.setOpaque(true);
		botEight.setContentAreaFilled(true);
		botEight.setBackground(Color.green);
	}

	public void setColorBotNine() {

		botNine.setOpaque(true);
		botNine.setContentAreaFilled(true);
		botNine.setBackground(Color.green);
	}

	public void setColorBotTen() {

		botTen.setOpaque(true);
		botTen.setContentAreaFilled(true);
		botTen.setBackground(Color.green);
	}

	public void setColorBotEleven() {

		botEleven.setOpaque(true);
		botEleven.setContentAreaFilled(true);
		botEleven.setBackground(Color.green);
	}

	public void setColorBotTwelve() {

		botTwelve.setOpaque(true);
		botTwelve.setContentAreaFilled(true);
		botTwelve.setBackground(Color.green);
	}

	public void setColorTopOne() {

		topOne.setOpaque(true);
		topOne.setContentAreaFilled(true);
		topOne.setBackground(Color.green);
	}

	public void setColorTopTwo() {

		topTwo.setOpaque(true);
		topTwo.setContentAreaFilled(true);
		topTwo.setBackground(Color.green);
	}

	public void setColorTopThree() {

		topThree.setOpaque(true);
		topThree.setContentAreaFilled(true);
		topThree.setBackground(Color.green);
	}

	public void setColorTopFour() {

		topFour.setOpaque(true);
		topFour.setContentAreaFilled(true);
		topFour.setBackground(Color.green);
	}

	public void setColorTopFive() {

		topFive.setOpaque(true);
		topFive.setContentAreaFilled(true);
		topFive.setBackground(Color.green);
	}

	public void setColorTopSix() {

		topSix.setOpaque(true);
		topSix.setContentAreaFilled(true);
		topSix.setBackground(Color.green);
	}

	public void setColorTopSeven() {

		topSeven.setOpaque(true);
		topSeven.setContentAreaFilled(true);
		topSeven.setBackground(Color.green);
	}

	public void setColorTopEight() {

		topEight.setOpaque(true);
		topEight.setContentAreaFilled(true);
		topEight.setBackground(Color.green);
	}

	public void setColorTopNine() {

		topNine.setOpaque(true);
		topNine.setContentAreaFilled(true);
		topNine.setBackground(Color.green);
	}

	public void setColorTopTen() {

		topTen.setOpaque(true);
		topTen.setContentAreaFilled(true);
		topTen.setBackground(Color.green);
	}

	public void setColorTopEleven() {

		topEleven.setOpaque(true);
		topEleven.setContentAreaFilled(true);
		topEleven.setBackground(Color.green);
	}

	public void setColorTopTwelve() {

		topTwelve.setOpaque(true);
		topTwelve.setContentAreaFilled(true);
		topTwelve.setBackground(Color.green);
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

	public void setFirstDiceText(int points) {
		firstDice.setText(points + "");
	}

	public void setSecondDiceText(int points) {
		secondDice.setText(points + "");
	}
}
