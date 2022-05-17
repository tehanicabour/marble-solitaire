package cs3500.marblesolitaire.model.hw02;

/**
 * Creates a marble solitaire model.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {
  protected SlotState[][] board;
  protected int armThickness;
  protected int boardSize;
  protected int emptyRow;
  protected int emptyCol;

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int rowDistance = 0;
    int colDistance = 0;
    int newRow = 0;
    int newCol = 0;
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0
            || fromRow >= boardSize || fromCol >= boardSize || toRow >= boardSize
            || toCol >= boardSize) {
      throw new IllegalArgumentException("Out of bounds.");
    }
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Move is not valid.");
    } else {
      board[fromRow][fromCol] = SlotState.Empty;
      if (toRow - fromRow != 0) {
        rowDistance = toRow - fromRow;
      }
      if (toCol - fromCol != 0) {
        colDistance = toCol - fromCol;
      }
      newRow = fromRow + rowDistance / 2;
      newCol = fromCol + colDistance / 2;
      board[newRow][newCol] = SlotState.Empty;
      board[toRow][toCol] = SlotState.Marble;
    }
  }


  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  /*
  Changes: This method has been changed to incorporate moves that are both vertical and horizontal.
  This eliminates the need to duplicate the entirety of the method in the Triangle class,
  and does not affect the European or English classes as it would not pass as a valid
  move in the first place and as so would be disregarded.
   */
  @Override
  public boolean isGameOver() {
    boolean over = true;
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col].equals(SlotState.Marble)) {
          if (isValidMove(row, col, row, col + 2) || //moves right
                  isValidMove(row, col, row, col - 2) || //moves left
                  isValidMove(row, col, row + 2, col) ||
                  isValidMove(row, col, row - 2, col) ||
                  isValidMove(row, col, row - 2, col + 2) ||
                  isValidMove(row, col, row - 2, col - 2) ||
                  isValidMove(row, col, row + 2, col + 2) ||
                  isValidMove(row, col, row + 2, col - 2)) {
            over = false;//moves down
          }
        }
      }
    }

    return over;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return boardSize;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int countMarbles = 0;
    for (int row = 0; row < boardSize; row++) {
      for (int col = 0; col < boardSize; col++) {
        if (board[row][col].equals(SlotState.Marble)) {
          countMarbles++;
        }
      }
    }
    return countMarbles;
  }

  /**
   * Determines whether a given move is a valid one.
   *
   * @param fromRow number of the row at which marble is originally situated
   * @param fromCol number of the column at which marble is originally situated
   * @param toRow   number of the row where marble will be moved
   * @param toCol   number of the column where marble will be moved
   * @return true is move is valid, false if otherwise
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
    if (Math.abs(rowDistance) >= 2 && Math.abs(colDistance) >= 2) {
      return false;
    }
    if ((Math.abs(rowDistance) == 2 && colDistance != 0)
            || (Math.abs(colDistance) == 2 && rowDistance != 0)) {
      return false;
    }
    if (Math.abs(rowDistance) == 2 &&
            board[fromRow + (rowDistance / 2)][fromCol].equals(SlotState.Empty)) {
      return false;
    }
    if (Math.abs(colDistance) == 2 &&
            board[fromRow][fromCol + (colDistance / 2)].equals(SlotState.Empty)) {
      //return false;
      return !(Math.abs(colDistance) == 2 &&
              board[fromRow][fromCol + (colDistance / 2)].equals(SlotState.Empty));
    }

    return true;
  }
}
