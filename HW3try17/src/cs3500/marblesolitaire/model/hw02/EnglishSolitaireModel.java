/*
To-do:
Urgent:


Optional Clean-Up:
- combine the exception conditionals?
- can you use same word for class and constructor fields?

Important:
- replace instructions with comment docu

Planning:
create class field for original empty slot?
create method that makes the board after the constructor?

*/

package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a game of English Marble Solitaire.
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a {@code EnglishSolitaireModel} object with 3 arm thickness
   * and empty cell at 3,3 if no fields are provided.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs a {@code EnglishSolitaireModel} object with 3 arm thickness if thickness
   * is not provided and given empty cell.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructs a {@code EnglishSolitaireModel} object with given arm thickness and
   * empty cell position.
   */
  public EnglishSolitaireModel(int a) throws IllegalArgumentException {
    this(a, (3 * a - 2) / 2, (3 * a - 2) / 2);
    //because armThickness + half armThickness and then subtract one due to the board
    //starting at (0,0) instead of (1,1)
  }

  /**
   * Finally a fourth constructor should take the arm thickness, row and column of the empty
   * slot in that order. It should throw an IllegalArgumentException if the arm thickness is not
   * a positive odd number, or the empty cell position is invalid.
   */
  public EnglishSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    if (a < 1 || a % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness size.");
    }

    this.armThickness = a;
    this.boardSize = 2 * a + (a - 2);
    this.emptyCol = sCol;
    this.emptyRow = sRow;
    board = new SlotState[boardSize][boardSize];

    if (sRow < 0 || sRow >= boardSize || sCol < 0 || sCol >= boardSize) {
      throw new IllegalArgumentException("Invalid empty cell position.");
    }

    //Completes the left block of the board

    for (int col = 0; col < armThickness - 1; col++) {
      for (int row = 0; row < boardSize; row++) {
        if (row < (armThickness - 1) || row > ((2 * armThickness) - 2)) {
          board[row][col] = SlotState.Invalid;
        } else {
          board[row][col] = SlotState.Marble;
        }
      }
    }

    //Completes the right block of the board
    for (int col = ((2 * armThickness) - 1); col < boardSize; col++) {
      for (int row = 0; row < boardSize; row++) {
        if (row < (armThickness - 1) || row > ((2 * armThickness) - 2)) {
          board[row][col] = SlotState.Invalid;
        } else {
          board[row][col] = SlotState.Marble;
        }
      }
    }

    //Completes the top block of the board
    for (int row = 0; row < armThickness - 1; row++) {
      for (int col = 0; col < boardSize; col++) {
        if (col < armThickness - 1 || col > ((2 * armThickness) - 2)) {
          board[row][col] = SlotState.Invalid;
        } else {
          board[row][col] = SlotState.Marble;
        }
      }
    }

    //******* Completes the bottom block of the board
    // (overlaps invalids with left/right bottom *******
    for (int row = ((2 * armThickness) - 1); row < boardSize; row++) {
      for (int col = armThickness - 1; col < ((2 * armThickness) - 1); col++) {
        board[row][col] = SlotState.Marble;
      }
    }

    //Completes the center of the board
    for (int col = armThickness - 1; col < ((2 * armThickness) - 1); col++) {
      for (int row = armThickness - 1; row < ((2 * armThickness) - 1); row++) {
        board[row][col] = SlotState.Marble;
      }
    }

    //verifies that the given initial empty slot
    //is valid and if so makes given slot empty
    if (board[emptyRow][emptyCol].equals(SlotState.Invalid)) {
      throw new IllegalArgumentException("Initial empty slot provided is invalid.");
    } else {
      board[emptyRow][emptyCol] = SlotState.Empty;
    }


  }
}



