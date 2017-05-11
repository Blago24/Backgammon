package models;

import java.util.ArrayList;

public class Bord {
	final static int bordRows = 2;
	final static int bordCols = 10;
	final static int BlackPiece = 0;
	final static int WhitePiece = 1;
	final static int TopRow = 0;
	final static int BotRow = 1;

	// ArrayList <Piece> [][] pieces = new ArrayList[bordRows][bordCols];
	ArrayList<Piece>[][] pieces = new ArrayList[bordRows][bordCols];;

	public Bord() {
		createTheArray();

	}

	private void createTheArray() {
		for (int row = 0; row < bordRows; row++) {
			for (int col = 0; col < bordCols; col++) {
				pieces[row][col] = new ArrayList<>();
			}
		}

	}
 public void show(){
	 for (int i = 0; i < pieces.length; i++) {
		for (int j = 0; j < pieces[0].length; j++) {
			System.out.print(" "+pieces[i][j].size());
			//System.out.println(" "+pieces[i][j].get(0).getColor());
		}
		System.out.println();
	}
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
		case 0:
		case 5:
			return 5;
		case 3:
			return 3;
		case 9:
			return 2;

		}
		return 0;
	}

	private void fillTopRow(int col, int numberOfPieces) {
		switch (col) {
		case 0:
		case 9:
			fillColWithWhitePieces(TopRow, col, numberOfPieces);
			break;
		case 3:
		case 5:
			fillColWithBlackPieces(TopRow, col, numberOfPieces);
			break;
		}

	}

	private void fillColWithBlackPieces(int row, int col, int numberOfPieces) {
		for (int i = 0; i < numberOfPieces; i++) {
			pieces[row][col].add(new Piece(BlackPiece));
		}
	}

	private void fillColWithWhitePieces(int row, int col, int numberOfPieces) {
		for (int i = 0; i < numberOfPieces; i++) {
			pieces[row][col].add(new Piece(WhitePiece));
		}
	}

	private void fillBotRow(int col, int numberOfPieces) {
		switch (col) {
		case 0:
		case 9:
			fillColWithBlackPieces(BotRow, col, numberOfPieces);
			break;
		case 3:
		case 5:
			fillColWithWhitePieces(BotRow, col, numberOfPieces);
			break;
		}

	}

}
