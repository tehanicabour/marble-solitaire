package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;


//Changes: This class has been changed to add methods which check the
//text view of the European model.

/**
 * Creates tests for MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextViewTests {

  @Test
  public void testToString() {
    MarbleSolitaireModel testBoard = new EnglishSolitaireModel();
    MarbleSolitaireView testView = new MarbleSolitaireTextView(testBoard);
    String testBoardString = "    O O O" +
            "\n    O O O" +
            "\nO O O O O O O" +
            "\nO O O _ O O O" +
            "\nO O O O O O O" +
            "\n    O O O" +
            "\n    O O O";
    assertEquals(testBoardString, testView.toString());

    MarbleSolitaireModel testBoardTwo = new EnglishSolitaireModel(2, 2);
    MarbleSolitaireView testViewTwo = new MarbleSolitaireTextView(testBoardTwo);
    String testBoardStringTwo = "    O O O" +
            "\n    O O O" +
            "\nO O _ O O O O" +
            "\nO O O O O O O" +
            "\nO O O O O O O" +
            "\n    O O O" +
            "\n    O O O";
    assertEquals(testBoardStringTwo, testViewTwo.toString());

  }

  @Test
  public void testEuropeanModelThreeFields() {
    MarbleSolitaireModel threeFields = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireView threeFieldsView = new MarbleSolitaireTextView(threeFields);
    String threeFieldsViewString = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(threeFieldsViewString, threeFieldsView.toString());
  }

  @Test
  public void testEuropeanModelDefaultThree() {
    MarbleSolitaireModel defaultThree = new EuropeanSolitaireModel(3);
    MarbleSolitaireView testViewDefaultThree = new MarbleSolitaireTextView(defaultThree);
    String viewDefaultThree = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(viewDefaultThree, testViewDefaultThree.toString());
  }

  @Test
  public void testEuropeanModelThreeDifferentOrigin() {
    MarbleSolitaireModel oneTwo = new EuropeanSolitaireModel(3, 1, 2);
    MarbleSolitaireView oneTwoView = new MarbleSolitaireTextView(oneTwo);
    String oneTwoViewString = "    O O O\n"
            + "  O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(oneTwoViewString, oneTwoView.toString());
  }

  @Test
  public void testEuropeanModelDefaultMove() {
    MarbleSolitaireModel defaultThree = new EuropeanSolitaireModel(3);
    defaultThree.move(3, 1, 3, 3);
    MarbleSolitaireView testViewDefaultThree = new MarbleSolitaireTextView(defaultThree);
    String viewDefaultThree = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(viewDefaultThree, testViewDefaultThree.toString());
  }


  @Test
  public void testMoveDown() {
    MarbleSolitaireModel defaultThrees = new EuropeanSolitaireModel();
    defaultThrees.move(1, 3, 3, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(defaultThrees);
    String oneMoveVisual = "    O O O\n"
            + "  O O _ O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(oneMoveVisual, testView.toString());
  }

  @Test
  public void testMoveUp() {
    MarbleSolitaireModel defaultThrees = new EuropeanSolitaireModel();
    defaultThrees.move(5, 3, 3, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(defaultThrees);
    String oneMoveVisual = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O _ O O\n"
            + "    O O O";
    assertEquals(oneMoveVisual, testView.toString());
  }

  @Test
  public void testMoveRight() {
    MarbleSolitaireModel defaultThrees = new EuropeanSolitaireModel();
    defaultThrees.move(3, 1, 3, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(defaultThrees);
    String oneMoveVisual = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(oneMoveVisual, testView.toString());
  }

  @Test
  public void testMoveLeft() {
    MarbleSolitaireModel defaultThrees = new EuropeanSolitaireModel();
    defaultThrees.move(5, 3, 3, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(defaultThrees);
    String oneMoveVisual = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
    assertEquals(oneMoveVisual, testView.toString());
  }


  @Test
  public void testEuropeanModelFive() {
    MarbleSolitaireModel euroBoardFive = new EuropeanSolitaireModel(5, 5, 5);
    MarbleSolitaireView testViewEuroFive = new MarbleSolitaireTextView(euroBoardFive);
    String testEuroBoardFive = "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O";
    assertEquals(testEuroBoardFive, testViewEuroFive.toString());
  }

}
