package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


/**
 * Represents a visualization of the board of a given triangle marble solitaire model.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {

  private MarbleSolitaireModelState board;
  private Appendable out;

  /**
   * Creates a text view of a given model state.
   *
   * @param importedBoard provided board of the marble solitaire model state
   * @throws IllegalArgumentException if importedBoard is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState importedBoard, Appendable out)
          throws IllegalArgumentException {
    if (importedBoard == null || out == null) {
      throw new IllegalArgumentException("Null board state.");
    }
    this.board = importedBoard;
    this.out = out;
  }

  public TriangleSolitaireTextView(MarbleSolitaireModelState importedBoard) {
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

    for (int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
      for (int i = 0; i < boardSize - rowIndex - 1; i++) {
        boardVisual += " ";
      }
      for (int colIndex = 0; colIndex < boardSize; colIndex++) {
        if (board.getSlotAt(rowIndex, colIndex).
                equals(MarbleSolitaireModelState.SlotState.Marble)) {
          boardVisual += "O";
        }
        if (board.getSlotAt(rowIndex, colIndex).
                equals(MarbleSolitaireModelState.SlotState.Empty)) {
          boardVisual += "_";
        }
        if (colIndex < rowIndex) {
          boardVisual += " ";
        }
      }
      if (rowIndex < boardSize - 1) {
        boardVisual += "\n";
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

