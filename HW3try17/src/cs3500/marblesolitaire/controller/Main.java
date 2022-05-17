package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Main class to run controller classes.
 */
public class Main {

  /**
   * Main method for main class.
   *
   * @param args taken in fields
   * @throws IOException if inputs or outputs are invalid
   */
  public static void main(String[] args) throws IOException {
    //sets initial values if it is an English or European model
    if (args[0].equalsIgnoreCase("english") || args[0].equalsIgnoreCase("european")) {
      int initialRow;
      int initialCol;
      int arm = setSize(args, 3);
      int defaultEmpty = 3;
      if (arm != 3) {
        defaultEmpty = (3 * arm - 2) / 2;
      }
      initialRow = setRow(args, defaultEmpty);
      initialCol = setCol(args, defaultEmpty);

      //creates an English model
      if (args[0].equalsIgnoreCase("english")) {
        MarbleSolitaireModel model = new EnglishSolitaireModel(arm, initialRow, initialCol);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
                model, view, new InputStreamReader(System.in));
        controller.playGame();
      }
      //creates a European model
      if (args[0].equalsIgnoreCase("european")) {
        MarbleSolitaireModel model = new EuropeanSolitaireModel(arm, initialRow, initialCol);
        MarbleSolitaireView view = new MarbleSolitaireTextView(model);
        MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
                model, view, new InputStreamReader(System.in));
        controller.playGame();
      }
    }

    //creates a Triangle model and sets its starter values
    if (args[0].equalsIgnoreCase("triangle")) {
      int initialRow;
      int initialCol;
      int arm = setSize(args, 5);
      int defaultEmpty = 0;

      initialRow = setRow(args, defaultEmpty);
      initialCol = setCol(args, defaultEmpty);

      MarbleSolitaireModel model = new TriangleSolitaireModel(arm, initialRow, initialCol);
      MarbleSolitaireView view = new TriangleSolitaireTextView(model);
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
              model, view, new InputStreamReader(System.in));
      controller.playGame();
    }
  }

  //sets the size as either default or as specified by the user
  private static int setSize(String[] args, int defaultSize) {
    int size = defaultSize;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-size")) {
        size = Integer.parseInt(args[i + 1]);
      }
    }
    return size;
  }

  //sets the initial row as either default or as specified by the user
  private static int setRow(String[] args, int defaultRow) {
    int initialRow = defaultRow;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-hole")) {
        initialRow = Integer.parseInt(args[i + 1]);
      }
    }
    return initialRow;
  }

  //sets the initial column as either default or as specified by the user
  private static int setCol(String[] args, int defaultCol) {
    int initialCol = defaultCol;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-hole")) {
        initialCol = Integer.parseInt(args[i + 2]);
      }
    }
    return initialCol;
  }

}

