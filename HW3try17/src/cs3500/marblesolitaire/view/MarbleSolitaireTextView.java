package cs3500.marblesolitaire.view;

//import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a visualization of the board of a given marble solitaire model.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private MarbleSolitaireModelState board;
  private Appendable out;

  /**
   * Creates a text view of a given model state.
   *
   * @param importedBoard provided board of the marble solitaire model state
   * @throws IllegalArgumentException if importedBoard is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState importedBoard, Appendable out)
          throws IllegalArgumentException {
    if (importedBoard == null || out == null) {
      throw new IllegalArgumentException("Null board state.");
    }
    this.board = importedBoard;
    this.out = out;
  }

  public MarbleSolitaireTextView(MarbleSolitaireModelState importedBoard) {
    this(importedBoard, System.out);
  }

  /**
   * Returns a visual representation of the board and
   * game's state via string texts.
   *
   * @return text representation of the SlotState enum via string
   */
  @Override
  public String toString() {
    int boardSize = board.getBoardSize();
    String boardVisual = "";
    boolean trailingZero = false;
    boolean firstInRow = true;
    for (int r = 0; r < boardSize; r++) {
      for (int c = 0; c < boardSize; c++) {
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          if (!trailingZero) {
            boardVisual = boardVisual + "  ";
          }
        }
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          if (firstInRow) {
            boardVisual = boardVisual + "O";
            firstInRow = false;
          } else {
            boardVisual = boardVisual + " O";
          }
          trailingZero = true;
        }
        if (board.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          if (firstInRow) {
            boardVisual = boardVisual + "_";
            firstInRow = false;
          } else {
            boardVisual = boardVisual + " _";
          }
          trailingZero = true;
        }
      }
      trailingZero = false;
      firstInRow = true;
      if (r < boardSize - 1) {
        boardVisual = boardVisual + "\n";
      }
    }
    return boardVisual;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    out.append(toString());
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    out.append(message);
  }
}
