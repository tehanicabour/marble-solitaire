package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.util.Scanner;

/**
 * Implementation of the Marble Solitaire Controller in which user can
 * interact and play with the marble solitaire game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private Readable rd;
  private MarbleSolitaireView view;
  private MarbleSolitaireModel model;

  /**
   * Constructor for the Marble Solitaire Controller.
   *
   * @param model that is being used
   * @param view  of the model
   * @param rd    user input
   * @throws IllegalArgumentException if either of these are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable rd) throws IllegalArgumentException {
    if (rd == null || view == null || model == null) {
      throw new IllegalArgumentException("Bad argument to controller constructor.");
    }
    this.rd = rd;
    this.view = view;
    this.model = model;
  }

  /**
   * This method allows the user to play a game using a MarbleSolitaireModel.
   *
   * @throws IllegalArgumentException if the model is null.
   * @throws IllegalStateException    if there is an issue with Readable or Appendable.
   */
  @Override
  public void playGame() throws IllegalArgumentException, IllegalStateException {
    Scanner in = new Scanner(this.rd);
    String currentInput;
    int count = 0;
    int[] inputArray = new int[4];
    boolean quitGame = false;

    helperRenderBoard();
    try {
      view.renderMessage("Score: " + model.getScore());
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }

    while (!model.isGameOver() && !quitGame) {
      while (count < 4) {
        if (in.hasNext()) {
          currentInput = in.next();
          if (currentInput.equals("Q") || currentInput.equals("q")) {
            quitGame = true;
            helperRenderMessage("\nGame quit!\n" + "State of game when quit:\n");
            break;
          }
          try {
            inputArray[count] = Integer.parseInt(currentInput);
            count++;
          } catch (Exception e) {
            //catches non-integers
          }
        }
        else {
          throw new IllegalStateException("Insufficient values.");
        }
      }

      if (!quitGame) {
        try {
          model.move(inputArray[0] - 1, inputArray[1] - 1, inputArray[2] - 1,
                  inputArray[3] - 1);
        } catch (IllegalArgumentException e) {
          helperRenderMessage("Invalid move. Play again. The move could not be completed.");
        }
      }
      count = 0;
      if (!model.isGameOver()) {
        helperRenderMessage(view.toString() + "\nScore: " + model.getScore() + "\n");
      }
    }
    if (!quitGame) {
      helperRenderMessage("Game over!\n" + view.toString() + "\nScore: " + model.getScore() + "\n");
    }
  }

  private void helperRenderBoard() {
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }
  }

  private void helperRenderMessage(String message) {
    try {
      view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }
  }
}


