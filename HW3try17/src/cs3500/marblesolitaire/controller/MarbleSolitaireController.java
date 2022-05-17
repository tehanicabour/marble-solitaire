package cs3500.marblesolitaire.controller;


/**
 * This interface represents the operations offered by the marble solitaire controller. One object
 * of the controller represents one game of marble solitaire.
 */
public interface MarbleSolitaireController {
  /**
   * This method allows the user to play a game using a MarbleSolitaireModel.
   *
   * @throws IllegalArgumentException if the model is null.
   * @throws IllegalStateException if there is an issue with Readable or Appendable.
   */
  void playGame() throws IllegalArgumentException, IllegalStateException;
}
