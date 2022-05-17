package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.AbstractMarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a game of Triangle Marble Solitaire.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {
  /**
   * Constructs a {@code TriangleSolitaireModel} object with 5 rows
   * and empty cell at 0,0 if no fields are provided.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object with 5 rows and
   * an empty cell at sRow, sCol if number of slots in the bottom-most row
   * is not specified.
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5, sRow, sCol);
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object with given number of slots in the
   * bottom-most row and empty cell position at 0,0 if empty starting cell not specified.
   */
  public TriangleSolitaireModel(int a) throws IllegalArgumentException {
    this(a, 0, 0);
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} object according to the number of slots
   * in the bottom row and an empty cell. It should throw an IllegalArgumentException if the
   * given values are out of bounds (invalid).
   */
  public TriangleSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    if (a <= 0 || sRow < 0 || sCol < 0 || sRow >= a || sCol >= a) {
      throw new IllegalArgumentException("Invalid value.");
    }

    this.armThickness = a;
    this.boardSize = a;
    this.emptyRow = sRow;
    this.emptyCol = sCol;
    board = new MarbleSolitaireModelState.SlotState[boardSize][boardSize];

    for (int row = 0; row < armThickness; row++) {
      for (int column = 0; column < armThickness; column++) {
        if (column > row) {
          board[row][column] = SlotState.Invalid;
        } else {
          board[row][column] = SlotState.Marble;
        }
      }
    }

    if (board[emptyRow][emptyCol].equals(SlotState.Invalid)) {
      throw new IllegalArgumentException("Initial empty slot provided is invalid.");
    } else {
      board[emptyRow][emptyCol] = SlotState.Empty;
    }
  }

  /**
   * Returns true if a move is valid and false if it isn't.
   *
   * @param fromRow number of the row at which marble is originally situated
   * @param fromCol number of the column at which marble is originally situated
   * @param toRow   number of the row where marble will be moved
   * @param toCol   number of the column where marble will be moved
   * @return true if move is valid
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    int rowDistance = toRow - fromRow;
    int colDistance = toCol - fromCol;

    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0
            || fromRow >= boardSize || fromCol >= boardSize || toRow >= boardSize
            || toCol >= boardSize) {
      return false;
    }
    //verifies that the selected slots are both valid
    if (board[fromRow][fromCol].equals(SlotState.Invalid)
            || board[toRow][toCol].equals(SlotState.Invalid)) {
      return false;
    }
    //verifies that origin slot isn't empty and that destination slot isn't full
    if (board[fromRow][fromCol].equals(SlotState.Empty)
            || board[toRow][toCol].equals(SlotState.Marble)) {
      return false;
    }
    //verifies that either the column or row distance (but not both) is 2 and
    //that there is a marble between the from and to marbles
    if (rowDistance == 0 && colDistance == 0) {
      return false;
    }
    if (Math.abs(rowDistance) != 2 && Math.abs(colDistance) != 2) {
      return false;
    }
    if (Math.abs(rowDistance) == 2 && !(Math.abs(colDistance) == 2 || colDistance == 0)) {
      return false;
    }
    if (Math.abs(colDistance) == 2 && !(Math.abs(rowDistance) == 2 || rowDistance == 0)) {
      return false;
    }
    if (Math.abs(rowDistance) == 2
            && Math.abs(colDistance) == 2
            && board[fromRow +
            (rowDistance / 2)][fromCol + (colDistance / 2)].equals(SlotState.Empty)) {
      return false;
    }
    if (Math.abs(rowDistance) == 2
            && colDistance == 0
            && board[fromRow + (rowDistance / 2)][fromCol].equals(SlotState.Empty)) {
      return false;
    }
    if (Math.abs(colDistance) == 2
            && rowDistance == 0
            && board[fromRow][fromCol + (colDistance / 2)].equals(SlotState.Empty)) {
      //return false;
      return !(Math.abs(colDistance) == 2 &&
              board[fromRow][fromCol + (colDistance / 2)].equals(SlotState.Empty));
    }
    return true;
  }
}
