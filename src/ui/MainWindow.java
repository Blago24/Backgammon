package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.org.apache.regexp.internal.recompile;

import models.Bord;

import java.awt.Color;
import java.awt.Rectangle;

public class MainWindow {
	private Bord bord;
	private JFrame frame;
	// private JLabel oneWhite = null;
	// private JLabel twoWhite = null;
	// private JLabel threeWhite = null;
	// private JLabel fourWhite = null;
	// private JLabel fiveWhite = null;
	// private JLabel oneBlack = null;
	// private JLabel twoBlack = null;
	// private JLabel threeBlack = null;
	// private JLabel fourBlack = null;
	// private JLabel fiveBlack = null;
	private JLabel currentPiece = null;

	private JLabel background = null;

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

		showBord();
	}

	public void showBord() {
		int sizeOfCurrentPosition;
		boolean isItWhite;
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 12; col++) {
				
				sizeOfCurrentPosition = bord.checkTheNumberOfPiecesOnCurrentPosition(row, col);
				System.out.println(sizeOfCurrentPosition);
				if(sizeOfCurrentPosition>0){
					isItWhite = bord.checkTheColorOfPiecesOnCurrentPosition(row, col);
					showPictureForCurrentPosition(row, col, sizeOfCurrentPosition, isItWhite);
				}
				

			}
		}

		frame.getContentPane().add(background);
	}

	private void showPictureForCurrentPosition(int row, int col, int sizeOfCurrentPosition, boolean isItWhite) {
		int numberOfPictures = numberOfPicturesAtCurrentPosition(sizeOfCurrentPosition);

		for (int counterForPics = 0; counterForPics < numberOfPictures; counterForPics++) {
			
			if (isItWhite == true) {
				chooseWhitePiecesPicture(row, col, sizeOfCurrentPosition, counterForPics);
			} else {
				chooseBlackPiecesPicture(row, col, sizeOfCurrentPosition, counterForPics);
			}
			sizeOfCurrentPosition-=5;
			frame.getContentPane().add(currentPiece);
			
		}
		
		// frame.getContentPane().add(oneWhite);
		// frame.getContentPane().add(twoWhite);
		// frame.getContentPane().add(threeWhite);
		// frame.getContentPane().add(fourWhite);
		// frame.getContentPane().add(fiveWhite);
		// frame.getContentPane().add(oneBlack);
	}

	private void chooseBlackPiecesPicture(int row, int col, int sizeOfCurrentPosition, int counterForPics) {

		currentPiece = new JLabel("");
		currentPiece.setText("");

		currentPiece.setBounds(new Rectangle(bord.getXPosition(col, counterForPics),
				bord.getYPosition(row, sizeOfCurrentPosition), 69, 345));
		
		String pathToPicture;
		if(sizeOfCurrentPosition>5){
			 pathToPicture = getPathToBlackPictures(5);
		}else{
			pathToPicture=  getPathToBlackPictures(sizeOfCurrentPosition);
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
		if(sizeOfCurrentPosition>5){
			 pathToPicture = getPathToWhitePictures(5);
		}else{
			pathToPicture= getPathToWhitePictures(sizeOfCurrentPosition);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);

		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Git\\BackgammonWorkspace\\Backgammon\\src\\images\\bg.jpg"));
		background.setText("");
		background.setBounds(0, 0, 910, 690);

		frame.setBounds(200, 200, 909, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
