package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;


import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Tests the controller methods from the MarbleSolitaireControllerImpl class.
 */
public class ControllerImplTests {

  private MarbleSolitaireModel defaultThrees;
  private Appendable out;
  private MarbleSolitaireView threeView;

  /**
   * Sets up malleable variables to use in tests.
   */
  @Before
  public void setUp() {
    defaultThrees = new EnglishSolitaireModel();
    out = new StringBuilder();
    threeView = new MarbleSolitaireTextView(defaultThrees, out);
  }


  String testBoard = "    O O O" +
          "\n    O O O" +
          "\nO O O O O O O" +
          "\nO O O _ O O O" +
          "\nO O O O O O O" +
          "\n    O O O" +
          "\n    O O O\nScore: 32";
  String testBoard4244 = "    O O O" +
          "\n    O O O" +
          "\nO O O O O O O" +
          "\nO _ _ O O O O" +
          "\nO O O O O O O" +
          "\n    O O O" +
          "\n    O O O\nScore: 31\n";
  String quitBoard4244 = "\nGame quit!\n" + "State of game when quit:\n" +
          "    O O O" +
          "\n    O O O" +
          "\nO O O O O O O" +
          "\nO _ _ O O O O" +
          "\nO O O O O O O" +
          "\n    O O O" +
          "\n    O O O\nScore: 31\n";
  String quitBoardDefault = "\nGame quit!\n" + "State of game when quit:\n" +
          "    O O O" +
          "\n    O O O" +
          "\nO O O O O O O" +
          "\nO O O _ O O O" +
          "\nO O O O O O O" +
          "\n    O O O" +
          "\n    O O O\nScore: 32\n";

  /**
   * Tests that getting a null readable in the controller class results in an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullReadable() {
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            null);
  }

  /**
   * Tests that getting a null view in the controller class results in an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullView() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, null,
            in);
  }

  /**
   * Tests that getting a null model in the controller class results in an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullModel() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(null, threeView,
            in);
  }

  /**
   * Tests the Insufficient Values error.
   */
  @Test(expected = IllegalStateException.class)
  public void insufficientValuesError() {
    Reader in = new StringReader("4 2 4 5 3 5 6 7 6 3 4 5 6 7");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);
  }

  /**
   * Tests the Invalid Move error.
   */
  @Test(expected = IllegalStateException.class)
  public void invalidMove() {
    Reader in = new StringReader("4 2 5 3 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);
  }

  /**
   * Tests the Unable to Transmit Output error.
   */
  @Test(expected = IllegalStateException.class)
  public void unableTransmitOutput() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel wrong = new EnglishSolitaireModel(1);
    MarbleSolitaireView oneView = new MarbleSolitaireTextView(wrong, out);
  }

  /**
   * Tests the case where one invalid value is placed after a couple of valid values.
   */
  @Test
  public void invalidInputOne() {
    Reader in = new StringReader("4 2 4 j 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + testBoard4244 + quitBoard4244;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case when q is in the fromCol field.
   */
  @Test
  public void quitTestOne() {
    Reader in = new StringReader("4 q 2 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + quitBoardDefault;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case when q is in the fromRow field.
   */
  @Test
  public void quitTestTwo() {
    Reader in = new StringReader("q 4 2 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + quitBoardDefault;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case when q is in the toRow field.
   */
  @Test
  public void quitTestThree() {
    Reader in = new StringReader("4 2 q 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + quitBoardDefault;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case when q is in the toCol field.
   */
  @Test
  public void quitTestTFour() {
    Reader in = new StringReader("4 2 4 q q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + quitBoardDefault;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case where one marble is being moved.
   */
  @Test
  public void testMoveOne() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);

    test.playGame();

    String oneInvalid = testBoard + testBoard4244 + quitBoard4244;

    assertEquals(oneInvalid, out.toString());
  }

  /**
   * Tests case of complete game with game over.
   */
  @Test
  public void testModelGameCompleteOver() {
    /*
    Reader in = new StringReader("4 2 4 4 2 3 4 3 4 4 4 2 4 1 4 3 3 1 3 3 3 4 3 2" +
            "1 4 3 4 3 5 3 3 1 5 3 5 4 3 2 3 1 3 3 3 3 2 3 4 3 5 3 3 3 7 3 5 4 5 4 3" +
            "4 7 4 5 5 5 5 3 2 5 4 5 6 3 4 3 3 3 5 3 6 4 4 4 4 4 4 6 5 6 3 6 5 2 5 4" +
            "7 5 5 5 5 5 5 3 7 3 7 5 q");

            424445434745244454347454
     */
    Reader in = new StringReader("4 2 4 4 4 5 4 3 4 7 4 5 2 4 4 4 5 4 3 4 7 4 5 4 q");
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(defaultThrees, threeView,
            in);
    test.playGame();
    String gameOver = "Game over!\n" +
            "    _ _ _" +
            "\n    _ _ _" +
            "\n_ _ _ _ _ O _" +
            "\n_ _ _ _ _ _ _" +
            "\nO _ O _ _ _ O" +
            "\n    _ _ _" +
            "\n    _ _ O\nScore: 5\n";

    assertTrue(out.toString().contains(gameOver));
  }






}

