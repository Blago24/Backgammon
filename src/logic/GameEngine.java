package logic;

import java.util.Random;

import models.Bord;
import ui.MainWindow;

public class GameEngine {
	private MainWindow window;
	int firstDice;
	int secondDice;
	boolean isWhiteTurn;
public  GameEngine() {
	isWhiteTurn=true;
}
	

	public void gameRunning(Bord bord) {
		bord.show();
		setTheClickablePieces(bord);
		bord.showBord(this.window);
		

	}
	public void setWindow(MainWindow window) {
		System.out.println("epa");
		this.window = window;

	}

	public int trowDice() {
		Random rand = new Random();

		return rand.nextInt(6) + 1;
	}

	public void setTheClickablePieces(Bord bord) {
		for (int row = 0; row < bord.bordRows; row++) {
			for (int col = 0; col < bord.bordCols; col++) {
				if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) > 0) {
					if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col) == true && isWhiteTurn()) {
						if (row == 0) {
							setTopButtonsClickable(col, true);
						} else {
							setBotButtonsClickable(col, true);
						}
					} else if(bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col) == false && !isWhiteTurn()){
						if (row == 0) {
							setTopButtonsClickable(col, true);
						} else {
							setBotButtonsClickable(col, true);
						}
					}else{
						if (row == 0) {
							setTopButtonsClickable(col, false);
						} else {
							setBotButtonsClickable(col, false);
						}
					}
				}else{
					if (row == 0) {
						setTopButtonsClickable(col, false);
					} else {
						setBotButtonsClickable(col, false);
					}
				}
			}
		}
	}

	public boolean isWhiteTurn() {
		return isWhiteTurn;
	}
	public void setWhiteTurn(boolean isWhiteTurn) {
		this.isWhiteTurn=isWhiteTurn;
	}


	public void setTopButtonsClickable(int col, boolean type) {
		switch (col) {
		case 0:
			window.setTopOne(type);
			break;
		case 1:
			window.setTopTwo(type);
			break;
		case 2:
			window.setTopThree(type);
			break;
		case 3:
			window.setTopFour(type);
			break;
		case 4:
			window.setTopFive(type);
			break;
		case 5:
			window.setTopSix(type);
			break;
		case 6:
			window.setTopSeven(type);
			break;

		case 7:
			window.setTopEight(type);
			break;
		case 8:
			window.setTopNine(type);
			break;
		case 9:
			window.setTopTen(type);
			break;
		case 10:
			window.setTopEleven(type);
			break;
		case 11:
			window.setTopTwelve(type);
			break;

		}
	}

	public void setBotButtonsClickable(int col, boolean type) {
		switch (col) {
		case 0:
			window.setBotOne(type);
			break;
		case 1:
			window.setBotTwo(type);
			break;
		case 2:
			window.setBotThree(type);
			break;
		case 3:
			window.setBotFour(type);
			break;
		case 4:
			window.setBotFive(type);
			break;
		case 5:
			window.setBotSix(type);
			break;
		case 6:
			window.setBotSeven(type);
			break;

		case 7:
			window.setBotEight(type);
			break;
		case 8:
			window.setBotNine(type);
			break;
		case 9:
			window.setBotTen(type);
			break;
		case 10:
			window.setBotEleven(type);
			break;
		case 11:
			window.setBotTwelve(type);
			break;

		}
	}

	
}
