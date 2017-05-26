package models;

import java.util.ArrayList;

import ui.MainWindow;

public class Bord {
	public final static int bordRows = 2;
	public final static int bordCols = 12;
	public final static int BlackPiece = 0;
	public final static int WhitePiece = 1;
	public final static int TopRow = 0;
	public final static int BotRow = 1;
	public int counterWhitePieces;
	public int counterBlackPieces;
	// one piece , two pieces , three pieces , four and five
	final static int[] topRowYPositions = { -275, -206, -137, -69, 1 };
	final static int botRowYPosition = 345;
	final static int[] rowXPosition = { 6, 77, 148, 219, 290, 361, 468, 539, 610, 681, 752, 823 };

	public static int getRowXposition(int col) {
		return rowXPosition[col];

	}

	// ArrayList <Piece> [][] pieces = new ArrayList[bordRows][bordCols];
	ArrayList<Piece>[][] pieces = new ArrayList[bordRows][bordCols];;

	public Bord() {
		this.counterBlackPieces=15;
		this.counterWhitePieces=15;
		createTheArray();

	}

	private void createTheArray() {
		for (int row = 0; row < bordRows; row++) {
			for (int col = 0; col < bordCols; col++) {
				pieces[row][col] = new ArrayList<>();
			}
		}

	}

	public void show() {
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				System.out.print(" " + pieces[i][j].size());

			}
			System.out.println();
		}
	}

	public void showColor() {
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {

				if (pieces[i][j].size() != 0) {
					System.out.print(this.pieces[i][j].get(0).getColor());
				} else {
					System.out.print("*");
				}

			}
			System.out.println();
		}
	}

	public void countPieces() {
		int currentCounterWhitePieces=0;
		int currentCounterBlackPieces=0;
		for (int row = 0; row < pieces.length; row++) {
			for (int col = 0; col < pieces[0].length; col++) {
				
				if (pieces[row][col].size() != 0) {
					if(this.pieces[row][col].get(0).getColor()==WhitePiece){
						currentCounterWhitePieces+=pieces[row][col].size();
					}else{
						currentCounterBlackPieces+=pieces[row][col].size();
					}
				} 

				
			}
		}
		this.counterWhitePieces=currentCounterWhitePieces;
		this.counterBlackPieces=currentCounterBlackPieces;
	}

	

	public void showBord(MainWindow window) {
		
		window.getFrame().getContentPane().removeAll();
		window.setAllButtons();
		
	
		
		int sizeOfCurrentPosition;
		boolean isItWhite;
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 12; col++) {

				sizeOfCurrentPosition = checkTheNumberOfPiecesOnCurrentPosition(row, col);
				System.out.println(sizeOfCurrentPosition);
				if (sizeOfCurrentPosition > 0) {
					isItWhite = checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col);
					window.showPictureForCurrentPosition(row, col, sizeOfCurrentPosition, isItWhite);
				}

			}
		}
		window.setBackground();
		

	}

	public ArrayList<Piece>[][] getPieces() {
		return pieces;
	}

	public void iniBord() {
		for (int row = 0; row < pieces.length; row++) {
			for (int col = 0; col < pieces[0].length; col++) {
				int numberOfPieces = numberOfPiecesInCurrentCol(col);
				if (row == 0) {

					fillTopRow(col, numberOfPieces);
				} else {

					fillBotRow(col, numberOfPieces);
				}

			}
		}
	}

	private int numberOfPiecesInCurrentCol(int col) {
		switch (col) {
		case 11:
			return 1;
		case 4:
			return 3;
		case 0:
		case 6:
			return 5;

		}
		return -1;
	}

	private void fillTopRow(int col, int numberOfPieces) {
		switch (col) {
		case 0:
		case 11:
			// System.out.println("white");
			fillColWithWhitePieces(TopRow, col, numberOfPieces);
			break;
		case 4:
		case 6:
			// System.out.println("black");
			fillColWithBlackPieces(TopRow, col, numberOfPieces);
			break;
		}

	}
	public void addPiece(int row , int col , int type){
		if(type==WhitePiece){
			this.pieces[row][col].add(new Piece(WhitePiece));
		}else{
			this.pieces[row][col].add(new Piece(BlackPiece));
		}
	}

	private void fillColWithBlackPieces(int row, int col, int numberOfPieces) {
		for (int i = 0; i < numberOfPieces; i++) {
			this.pieces[row][col].add(new Piece(BlackPiece));
		}
	}
	
	private void fillColWithWhitePieces(int row, int col, int numberOfPieces) {
		for (int i = 0; i < numberOfPieces; i++) {
			this.pieces[row][col].add(new Piece(WhitePiece));
		}
	}

	private void fillBotRow(int col, int numberOfPieces) {
		switch (col) {
		case 0:
		case 11:
			// System.out.println("black");
			fillColWithBlackPieces(BotRow, col, numberOfPieces);
			break;
		case 4:
		case 6:
			// System.out.println("white");
			fillColWithWhitePieces(BotRow, col, numberOfPieces);
			break;
		}

	}

	public int checkTheNumberOfPiecesOnCurrentPosition(int row, int col) {
		System.out.println("SIZE=" + pieces[row][col].size());
		return pieces[row][col].size();
	}

	public boolean checkIfTheColorOfPiecesOnCurrentPositionIsWhite(int row, int col) {
		if (pieces[row][col].get(0).getColor() == WhitePiece) {
			return true;
		}
		return false;
	}

	public int getYPosition(int row, int sizeOfCurrentPosition) {

		if (row == BotRow) {
			return botRowYPosition;
		} else {
			if (sizeOfCurrentPosition > 5) {
				return topRowYPositions[topRowYPositions.length - 1];
			} else {
				return topRowYPositions[sizeOfCurrentPosition - 1];
			}

		}

	}

	public int getXPosition(int col, int counterForPics) {
		// counterForPics*4 is for the shift
		return getRowXposition(col) + counterForPics * 4;
	}

	public void removeOnePiece(int row, int col) {
		System.out.println("da");
		System.out.println(pieces[row][col].size());

		pieces[row][col].remove(0);
		System.out.println(pieces[row][col].size());

	}
	public int getCounterWhitePieces() {
		return counterWhitePieces;
	}

	public int getCounterBlackPieces() {
		return counterBlackPieces;
	}

}
