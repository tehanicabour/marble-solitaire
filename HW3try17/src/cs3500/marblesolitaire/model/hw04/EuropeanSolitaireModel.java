package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.AbstractMarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a game of European Solitaire. This game has an octagonal board.
 */
public class EuropeanSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with a side length of 3
   * and empty cell at 3,3 if no fields are provided.
   */

  public EuropeanSolitaireModel() {
    this(3, 3, 3);
    //super(3, 3, 3);
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with a side length of 3 if thickness
   * is not provided and given empty cell.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
    //super(sRow, sCol);
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with given side length and
   * empty cell position.
   */
  public EuropeanSolitaireModel(int a) throws IllegalArgumentException {
    this(a, (3 * a - 2) / 2, (3 * a - 2) / 2);
    //super(a);
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} object with the arm thickness, row and column
   * of the empty slot in that order. It should throw an IllegalArgumentException
   * if the arm thickness is not a positive odd number,
   * or the empty cell position is invalid.
   */
  public EuropeanSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {

    if (a < 1 || a % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness size.");
    }

    this.armThickness = a;
    this.boardSize = 2 * a + (a - 2);
    this.emptyCol = sCol;
    this.emptyRow = sRow;
    board = new MarbleSolitaireModelState.SlotState[boardSize][boardSize];
    int dimension = boardSize - 1;

    if (sRow < 0 || sRow > dimension || sCol < 0 || sCol > dimension) {
      throw new IllegalArgumentException("Invalid empty cell position.");
    }


    //super(a, sRow, sCol);
    //Fills all spaces as invalid before placing invalids
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        board[row][col] = MarbleSolitaireModelState.SlotState.Invalid;
      }
    }

    //Completes the upper-left block of the board
    for (int col = 0; col < boardSize / 2; col++) {
      for (int row = 0; row < boardSize / 2; row++) {
        if (row + col >= (boardSize / 2) - (a / 2)) {
          board[row][col] = MarbleSolitaireModelState.SlotState.Marble;
        }
      }
    }

    //Completes the lower-left block of the board
    for (int col = 0; col < boardSize / 2; col++) {
      for (int row = boardSize / 2; row < boardSize; row++) {
        if (row - col < (boardSize - (boardSize / 2 - (a / 2)))) {
          board[row][col] = MarbleSolitaireModelState.SlotState.Marble;
        }
      }
    }

    //Completes the upper-right block of the board
    for (int col = boardSize / 2; col < boardSize; col++) {
      for (int row = 0; row < boardSize / 2; row++) {
        if (col - row <= (boardSize / 2 + (a / 2))) {
          board[row][col] = MarbleSolitaireModelState.SlotState.Marble;
        }
      }
    }

    //Completes the lower-right block of the board
    for (int col = boardSize / 2; col < boardSize; col++) {
      for (int row = boardSize / 2; row < boardSize; row++) {
        //row + col < (2*(boardSize-1)) - (a/2)
        if (row + col < boardSize + (boardSize / 2) + (a / 2)) {
          board[row][col] = MarbleSolitaireModelState.SlotState.Marble;
        }
      }

    }

    //verifies that the given initial empty slot
    //is valid and if so makes given slot empty
    if (board[emptyRow][emptyCol].equals(MarbleSolitaireModelState.SlotState.Invalid)) {
      throw new IllegalArgumentException("Initial empty slot provided is invalid.");
    } else {
      board[emptyRow][emptyCol] = MarbleSolitaireModelState.SlotState.Empty;
    }


  }
}
