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
	int takenWhite;
	int takenBlack;
	int oldRow;
	int oldCol;
	boolean pieceIsMoveing;
	boolean checkForPosiblePositions;

	public GameEngine() {
		firstDice = 0;
		secondDice = 0;
		takenBlack = 0;
		takenWhite = 0;
		// first is White , but at the beginning we have to set the boolean
		// isWhiteTurn = false;
		// and when is clicked the trow dice btn isWhiteTurn changes to opposite
		// type
		isWhiteTurn = false;
		pieceIsMoveing = false;
		checkForPosiblePositions = false;
		currentButtonClickedCol = -1;
		currentButtonClickedRow = -1;
		oldRow = currentButtonClickedRow;
		oldCol = currentButtonClickedCol;
	}

	public void gameRunning(Bord bord) {

		// bord.show();

		bord.showBord(this.window);
		setTheClickablePieces(bord);
		checkTheDice();

	}

	private void checkTheDice() {
		if (firstDice == 0 && secondDice == 0) {
			showDiceButton();
			// setWhiteTurn(!isWhiteTurn());
		} else {
			hideDiceButton();

		}

	}

	public void makeTurn(Bord bord) {
		setOldCol(getCurrentButtonClickedCol());
		setOldRow(getCurrentButtonClickedRow());
		stopAllButtons();
		if (isWhiteTurn() && getTakenWhite() == 0) {
			whitePlayerTurn(bord);
		} else if (!isWhiteTurn() && getTakenBlack() == 0) {
			blackPlayerTurn(bord);
		}

	}

	public boolean putTakenPieces(Bord bord) {

		if (isWhiteTurn() && getTakenWhite() != 0) {
			stopAllButtons();
			putTakenWhite(bord);
			// bord.showBord(this.window);
			return true;

		}
		if (!isWhiteTurn() && getTakenBlack() != 0) {
			stopAllButtons();
			putTakenBlack(bord);
			// bord.showBord(this.window);
			return true;
		}

		return false;
	}

	private void putTakenBlack(Bord bord) {

		if (paintingThePosiblePosition(bord, Bord.BotRow, Bord.bordCols - firstDice)) {
			setFirstDice(0);
			setBotButtonsClickable(Bord.bordCols - firstDice, false);
			//bord.showBord(this.window);
		}
		if (paintingThePosiblePosition(bord, Bord.BotRow, Bord.bordCols - secondDice)) {
			setSecondDice(0);
			setBotButtonsClickable(Bord.bordCols - firstDice, false);
		//	bord.showBord(this.window);
		}

		setTakenBlack(getTakenBlack() - 1);
		// removeTheUsedDicePutOnBord();
		// gameRunning(bord);
		// bord.showBord(this.window);
	}

	private void putTakenWhite(Bord bord) {
		if (paintingThePosiblePosition(bord, Bord.TopRow, Bord.bordCols - firstDice)) {

			setFirstDice(0);
			setTopButtonsClickable(Bord.bordCols - firstDice, false);
			//bord.showBord(this.window);

		}
		if (paintingThePosiblePosition(bord, Bord.TopRow, Bord.bordCols - secondDice)) {

			setSecondDice(0);
			setTopButtonsClickable(Bord.bordCols - firstDice, false);
			//bord.showBord(this.window);

		}
		setTakenWhite(getTakenWhite() - 1);
		// removeTheUsedDicePutOnBord();
		// gameRunning(bord);
		// bord.showBord(this.window);
	}

	public int getOldRow() {
		return oldRow;
	}

	public void setOldRow(int oldRow) {
		this.oldRow = oldRow;
	}

	public int getOldCol() {
		return oldCol;
	}

	public void setOldCol(int oldCol) {
		this.oldCol = oldCol;
	}

	private void blackPlayerTurn(Bord bord) {

		if (getCurrentButtonClickedRow() == 1) {
			if (firstDice != 0) {
				if (getCurrentButtonClickedCol() - firstDice < 0) {
					paintingThePosiblePosition(bord, Bord.TopRow, firstDice - getCurrentButtonClickedCol() - 1);

				} else {
					paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() - firstDice);
				}
			}
			if (secondDice != 0) {
				if (getCurrentButtonClickedCol() - secondDice < 0) {
					paintingThePosiblePosition(bord, Bord.TopRow, secondDice - getCurrentButtonClickedCol() - 1);

				} else {
					paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() - secondDice);

				}
			}

		} else if (getCurrentButtonClickedRow() == 0) {
			if (firstDice != 0) {
				if (getCurrentButtonClickedCol() + firstDice <= 11) {

					paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() + firstDice);
				}
			}
			if (secondDice != 0) {
				if (getCurrentButtonClickedCol() + secondDice <= 11) {

					paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() + secondDice);
				}
			}

		}

	}

	private void whitePlayerTurn(Bord bord) {

		if (getCurrentButtonClickedRow() == 0) {
			if (firstDice != 0) {
				if (getCurrentButtonClickedCol() - firstDice < 0) {
					paintingThePosiblePosition(bord, Bord.BotRow, firstDice - getCurrentButtonClickedCol() - 1);

				} else {
					paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() - firstDice);
				}
			}
			if (secondDice != 0) {
				if (getCurrentButtonClickedCol() - secondDice < 0) {
					paintingThePosiblePosition(bord, Bord.BotRow, secondDice - getCurrentButtonClickedCol() - 1);

				} else {

					paintingThePosiblePosition(bord, Bord.TopRow, getCurrentButtonClickedCol() - secondDice);
				}
			}

		} else if (getCurrentButtonClickedRow() == 1) {
			if (firstDice != 0) {
				if (getCurrentButtonClickedCol() + firstDice <= 11) {

					paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() + firstDice);
				}
			}
			if (secondDice != 0) {
				if (getCurrentButtonClickedCol() + secondDice <= 11) {

					paintingThePosiblePosition(bord, Bord.BotRow, getCurrentButtonClickedCol() + secondDice);
				}
			}

		}
	}

	private boolean paintingThePosiblePosition(Bord bord, int row, int col) {
		if (isWhiteTurn()) {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) > 0) {
				if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					ColorThePossibleNewPosition(row, col);
					setClickablePosiblePositions(row, col);
					setCheckForPosiblePositions(true);
					return true;
				} else if (!bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) <= 1) {
						ColorThePossibleNewPosition(row, col);
						setClickablePosiblePositions(row, col);
						setCheckForPosiblePositions(true);
						return true;
					}
				}
			} else {
				ColorThePossibleNewPosition(row, col);
				setClickablePosiblePositions(row, col);
				setCheckForPosiblePositions(true);
				return true;
			}
		} else {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) > 0) {
				if (!bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					ColorThePossibleNewPosition(row, col);
					setClickablePosiblePositions(row, col);
					setCheckForPosiblePositions(true);
					return true;
				} else if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(row, col)) {
					if (bord.checkTheNumberOfPiecesOnCurrentPosition(row, col) <= 1) {
						ColorThePossibleNewPosition(row, col);
						setClickablePosiblePositions(row, col);
						setCheckForPosiblePositions(true);
						return true;
					}
				}
			} else {
				ColorThePossibleNewPosition(row, col);
				setClickablePosiblePositions(row, col);
				setCheckForPosiblePositions(true);
				return true;
			}
		}
		return false;
	}

	private void stopAllButtons() {
		for (int row = 0; row < Bord.bordRows; row++) {
			for (int col = 0; col < Bord.bordCols; col++) {
				if (row == 0) {
					setTopButtonsClickable(col, false);
				} else {
					setBotButtonsClickable(col, false);
				}
			}
		}
	}

	private void setClickablePosiblePositions(int row, int col) {

		if (row == 0) {
			setTopButtonsClickable(col, true);
		} else {
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

	public void hideDiceButton() {
		window.setDice(false);
		if (firstDice != 0) {
			window.setFirstDiceText(firstDice);
		}
		if (secondDice != 0) {
			window.setSecondDiceText(secondDice);
		}
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

	public boolean isPieceIsMoveing() {
		return pieceIsMoveing;
	}

	public void setPieceIsMoveing(boolean pieceIsMoveing) {
		this.pieceIsMoveing = pieceIsMoveing;
	}

	public void movePiece(Bord bord) {
		bord.removeOnePiece(getOldRow(), getOldCol());
		if (isWhiteTurn()) {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(getCurrentButtonClickedRow(),
					getCurrentButtonClickedCol()) > 0) {
				if (!bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(getCurrentButtonClickedRow(),
						getCurrentButtonClickedCol())) {
					bord.removeOnePiece(getCurrentButtonClickedRow(), getCurrentButtonClickedCol());
					setTakenBlack(getTakenBlack() + 1);
				}

			}
			bord.addPiece(getCurrentButtonClickedRow(), getCurrentButtonClickedCol(), Bord.WhitePiece);
			removeTheUsedDiceMove();
			bord.showBord(this.window);
		} else {
			if (bord.checkTheNumberOfPiecesOnCurrentPosition(getCurrentButtonClickedRow(),
					getCurrentButtonClickedCol()) > 0) {
				if (bord.checkTheNumberOfPiecesOnCurrentPosition(getCurrentButtonClickedRow(),
						getCurrentButtonClickedCol()) > 0) {
					if (bord.checkIfTheColorOfPiecesOnCurrentPositionIsWhite(getCurrentButtonClickedRow(),
							getCurrentButtonClickedCol())) {
						bord.removeOnePiece(getCurrentButtonClickedRow(), getCurrentButtonClickedCol());
						setTakenWhite(getTakenWhite() + 1);
					}

				}
			}
			bord.addPiece(getCurrentButtonClickedRow(), getCurrentButtonClickedCol(), Bord.BlackPiece);
			removeTheUsedDiceMove();
			bord.showBord(this.window);
		}
		setPieceIsMoveing(false);
		gameRunning(bord);

	}

	private void removeTheUsedDiceMove() {
		if (getOldRow() == getCurrentButtonClickedRow()) {
			if (Math.abs(getOldCol() - getCurrentButtonClickedCol()) == firstDice) {
				setFirstDice(0);
			}
			if (Math.abs(getOldCol() - getCurrentButtonClickedCol()) == secondDice) {
				setSecondDice(0);
			}
		} else {

			if (getCurrentButtonClickedCol() + getOldCol() + 1 == firstDice) {
				setFirstDice(0);
			}
			if (getCurrentButtonClickedCol() + getOldCol() + 1 == secondDice) {
				setSecondDice(0);
			}

		}

	}

	private void removeTheUsedDicePutOnBord() {
		System.out.println("dadaadadhadkajdaldna-  " + getCurrentButtonClickedCol());
		if (Bord.bordCols - getCurrentButtonClickedCol() - 1 == firstDice) {
			System.out.println("getCOL1----------------------------------" + getCurrentButtonClickedCol());
			setFirstDice(0);
		}
		if (Bord.bordCols - getCurrentButtonClickedCol() - 1 == secondDice) {
			System.out.println("getCOL2---------------" + getCurrentButtonClickedCol());
			setSecondDice(0);
		}
		System.out.println("getCOL222---------------" + getCurrentButtonClickedCol());
	}

	public boolean isCheckForPosiblePositions() {
		return checkForPosiblePositions;
	}

	public void setCheckForPosiblePositions(boolean checkForPosiblePositions) {
		this.checkForPosiblePositions = checkForPosiblePositions;
	}

	public int getTakenWhite() {
		return takenWhite;
	}

	public void setTakenWhite(int takenWhite) {
		this.takenWhite = takenWhite;
	}

	public int getTakenBlack() {
		return takenBlack;
	}

	public void setTakenBlack(int takenBlack) {
		this.takenBlack = takenBlack;
	}

}
