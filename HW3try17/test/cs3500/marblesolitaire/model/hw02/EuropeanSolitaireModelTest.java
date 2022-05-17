package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Tests the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest extends AbstractModelTest {

  private MarbleSolitaireModel defaultThrees = new EuropeanSolitaireModel();

  private MarbleSolitaireModel threes = new EuropeanSolitaireModel(3, 3, 3);

  @Test(expected = IllegalArgumentException.class)
  public void negativeInitialRow() {
    new EuropeanSolitaireModel(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeInitialColumn() {
    new EuropeanSolitaireModel(3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooBigInitialRow() {
    new EuropeanSolitaireModel(5, 29, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooBigInitialColumn() {
    new EuropeanSolitaireModel(5, 3, 29);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidLengthEven() {
    new EuropeanSolitaireModel(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidLength() {
    new EuropeanSolitaireModel(-1);
  }

  @org.junit.Test
  public void testGetScore() {
    assertEquals(32, defaultThrees.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidStarting() {
    defaultThrees.move(3, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDestination() {
    defaultThrees.move(0, 2, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDistance() {
    defaultThrees.move(3, 0, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDistanceTwo() {
    defaultThrees.move(5, 2, 3, 3);
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
  public void testScore() {
    assertEquals(36, threes.getScore());
    threes.move(1, 3, 3, 3);
    assertEquals(35, threes.getScore());

  }

  /**
   * Tests whether the code returns true when the game is over.
   */
  @org.junit.Test
  public void testIsGameOverFalse() {
    assertEquals(false, defaultThrees.isGameOver());
  }

  @org.junit.Test
  public void testGameOverTrue() {
    MarbleSolitaireModel one = new EnglishSolitaireModel(1);
    assertEquals(true, one.isGameOver());
  }

  @Test
  public void testIsGameOverMoveFalse() {
    assertEquals(false, defaultThrees.isGameOver());
    threes.move(5, 3, 3, 3);
    assertEquals(false, defaultThrees.isGameOver());

  }

  @Test
  public void completedGame() {
    MarbleSolitaireModel completedGame = new EuropeanSolitaireModel(3, 3, 3);
    completedGame.move(1, 3, 3, 3);
    completedGame.move(3, 3, 5, 3);
    completedGame.move(5, 3, 5, 1);
    completedGame.move(5, 1, 3, 1);
    completedGame.move(3, 1, 1, 1);
    completedGame.move(1, 1, 1, 3);
    completedGame.move(1, 3, 1, 5);
    completedGame.move(1, 5, 3, 5);
    completedGame.move(3, 5, 5, 5);
    completedGame.move(5, 5, 5, 3);
    assertEquals(true, completedGame.isGameOver());
  }

  @Override
  protected MarbleSolitaireModel getModel() {
    return new EuropeanSolitaireModel();
  }

  @Override
  protected int getDefaultRow() {
    return 3;
  }

  @Override
  protected int getDefaultCol() {
    return 3;
  }

  @Override
  protected int getDefaultScore() {
    return 36;
  }

  @Override
  protected MarbleSolitaireModel getModelOne() {
    return new EuropeanSolitaireModel(9);
  }

  @Override
  protected int getRowOne() {
    return 9;
  }

  @Override
  protected int getColOne() {
    return 9;
  }

  @Override
  protected int getScoreOne() {
    return 90;
  }

  @Override
  protected MarbleSolitaireModel getModelTwo() {
    return new EuropeanSolitaireModel(2, 2);
  }

  @Override
  protected int getRowTwo() {
    return 2;
  }

  @Override
  protected int getColTwo() {
    return 2;
  }

  @Override
  protected int getScoreTwo() {
    return 36;
  }

  @Override
  protected MarbleSolitaireModel getModelFive() {
    return new EuropeanSolitaireModel(5, 5, 5);
  }

  @Override
  protected int getRowFive() {
    return 5;
  }

  @Override
  protected int getColFive() {
    return 5;
  }

  @Override
  protected int getScoreFive() {
    return 128;
  }
}


