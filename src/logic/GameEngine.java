package logic;

import java.util.Random;

import com.sun.org.apache.regexp.internal.recompile;

import models.Bord;
import ui.MainWindow;

public class GameEngine {
	private MainWindow window;
	int firstDice;
	int secondDice;
	boolean isWhiteTurn;
	int currentButtonClickedRow;
	int currentButtonClickedCol;

	public GameEngine() {
		isWhiteTurn = false;
		currentButtonClickedCol = -1;
		currentButtonClickedRow = -1;
	}

	public void gameRunning(Bord bord) {

		// bord.show();

		bord.showBord(this.window);
		setTheClickablePieces(bord);
		showDiceButton();
		

	}

	public void makeTurn(Bord bord) {
		stopAllButtons();
		if (isWhiteTurn()) {
			whitePlayerTurn(bord);
		} else {
			blackPlayerTurn(bord);
		}
		
	}

	private void blackPlayerTurn(Bord bord) {

		if (getCurrentButtonClickedRow() == 1) {
			if (getCurrentButtonClickedCol() - firstDice < 0) {
				paintingThePosiblePosition(bord, Bord.TopRow, firstDice - getCurrentButtonClickedCol() - 1);

			} else {
				paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() - firstDice);
			}
			if (getCurrentButtonClickedCol() - secondDice < 0) {
				paintingThePosiblePosition(bord, Bord.TopRow, secondDice - getCurrentButtonClickedCol() - 1);

			} else {
				paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() - secondDice);

			}
		} else if (getCurrentButtonClickedRow() == 0) {
			if (getCurrentButtonClickedCol() + firstDice <= 11) {

				paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() + firstDice);
			}
			if (getCurrentButtonClickedCol() + secondDice <= 11) {

				paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() + secondDice);
			}
		}

	}

	private void whitePlayerTurn(Bord bord) {
		if (getCurrentButtonClickedRow() == 0) {
			if (getCurrentButtonClickedCol() - firstDice < 0) {
				paintingThePosiblePosition(bord, Bord.BotRow, firstDice - getCurrentButtonClickedCol() - 1);

			} else {
				paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() - firstDice);
			}
			if (getCurrentButtonClickedCol() - secondDice < 0) {
				paintingThePosiblePosition(bord, Bord.BotRow, secondDice - getCurrentButtonClickedCol() - 1);

			} else {

				paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() - secondDice);

			}
		} else if (getCurrentButtonClickedRow() == 1) {
			if (getCurrentButtonClickedCol() + firstDice <= 11) {

				paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() + firstDice);
			}
			if (getCurrentButtonClickedCol() - secondDice <= 11) {

				paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() + secondDice);
			}
		}
	}

	private void paintingThePosiblePosition(Bord bord, int row, int col) {
		if (isWhiteTurn()) {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) > 0) {
				if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					ColorThePossibleNewPosition(row, col);
					setClickablePosiblePositions(row,col);
				} else if (!bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) <= 1) {
						ColorThePossibleNewPosition(row, col);
						setClickablePosiblePositions(row,col);
					}
				}
			}else{
				ColorThePossibleNewPosition(row, col);
				setClickablePosiblePositions(row,col);
			}
		} else {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) > 0) {
				if (!bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					ColorThePossibleNewPosition(row, col);
					setClickablePosiblePositions(row,col);
				} else if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) <= 1) {
						ColorThePossibleNewPosition(row, col);
						setClickablePosiblePositions(row,col);
					}
				}
			}else{
				ColorThePossibleNewPosition(row, col);
				setClickablePosiblePositions(row,col);
			}
		}
	}
	private void stopAllButtons(){
		for (int row = 0; row < Bord.bordRows; row++) {
			for (int col = 0; col < Bord.bordCols; col++) {
				if(row==0){
					setTopButtonsClickable(col,false);
				}else{
					setBotButtonsClickable(col,false);
				}
			}
		}
	}
	private void setClickablePosiblePositions(int row, int col) {
		
		if(row==0){
			setTopButtonsClickable(col, true);
		}else{
			setBotButtonsClickable(col, true);
		}
	}

	private void ColorThePossibleNewPosition(int row, int col) {
		if (row == 0) {
			colorTopRowPosition(col);
		} else {
			colorBotRowPosition(col);
		}

	}

	private void colorBotRowPosition(int col) {
		switch (col) {
		case 0:
			window.setColorBotOne();
			break;
		case 1:
			window.setColorBotTwo();
			break;
		case 2:
			window.setColorBotThree();
			break;
		case 3:
			window.setColorBotFour();
			break;
		case 4:
			window.setColorBotFive();
			break;
		case 5:
			window.setColorBotSix();
			break;
		case 6:
			window.setColorBotSeven();
			break;
		case 7:
			window.setColorBotEight();
			break;
		case 8:
			window.setColorBotNine();
			break;
		case 9:
			window.setColorBotTen();
			break;
		case 10:
			window.setColorBotEleven();
			break;
		case 11:
			window.setColorBotTwelve();
			break;

		}
	}

	private void colorTopRowPosition(int col) {
		switch (col) {
		case 0:
			window.setColorTopOne();
			break;
		case 1:
			window.setColorTopTwo();
			break;
		case 2:
			window.setColorTopThree();
			break;
		case 3:
			window.setColorTopFour();
			break;
		case 4:
			window.setColorTopFive();
			break;
		case 5:
			window.setColorTopSix();
			break;
		case 6:
			window.setColorTopSeven();
			break;
		case 7:
			window.setColorTopEight();
			break;
		case 8:
			window.setColorTopNine();
			break;
		case 9:
			window.setColorTopTen();
			break;
		case 10:
			window.setColorTopEleven();
			break;
		case 11:
			window.setColorTopTwelve();
			break;

		}
	}

	private boolean checkForWinner(Bord bord) {
		bord.countPieces();
		if (bord.getCounterWhitePieces() == 0) {
			System.out.println("You Lose");
			return true;

		} else if (bord.getCounterBlackPieces() == 0) {
			System.out.println("You WON");
			return true;
		}
		return false;
	}

	private void showDiceButton() {
		window.setDice(true);

	}

	private void hideDiceButton() {
		window.setDice(false);

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
					} else if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col) == false
							&& !isWhiteTurn()) {
						if (row == 0) {

							setTopButtonsClickable(col, true);
						} else {

							setBotButtonsClickable(col, true);
						}
					} else {
						if (row == 0) {
							setTopButtonsClickable(col, false);
						} else {
							setBotButtonsClickable(col, false);
						}
					}
				} else {
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
		this.isWhiteTurn = isWhiteTurn;
	}

	public void setTopButtonsClickable(int col, boolean type) {
		System.out.println("COL " + col);
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

	public int getCurrentButtonClickedRow() {
		return currentButtonClickedRow;
	}

	public void setCurrentButtonClickedRow(int currentButtonClickedRow) {
		this.currentButtonClickedRow = currentButtonClickedRow;
	}

	public int getCurrentButtonClickedCol() {
		return currentButtonClickedCol;
	}

	public void setCurrentButtonClickedCol(int currentButtonClickedCol) {
		this.currentButtonClickedCol = currentButtonClickedCol;
	}

	public int getFirstDice() {
		return firstDice;
	}

	public void setFirstDice(int firstDice) {
		this.firstDice = firstDice;
	}

	public int getSecondDice() {
		return secondDice;
	}

	public void setSecondDice(int secondDice) {
		this.secondDice = secondDice;
	}

}
