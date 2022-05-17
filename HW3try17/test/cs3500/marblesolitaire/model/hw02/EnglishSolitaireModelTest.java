package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

//This class has been changed to implement the abstract test methods.

/**
 * Tests the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest extends AbstractModelTest {

  private MarbleSolitaireModel defaultThrees = new EnglishSolitaireModel();

  private MarbleSolitaireModel armThicknessThree = new EnglishSolitaireModel(3);
  private MarbleSolitaireModel armThicknessFive = new EnglishSolitaireModel(5);
  private MarbleSolitaireModel emptyCenterTest = new EnglishSolitaireModel(2, 4);
  private MarbleSolitaireModel armAndCenterTest = new EnglishSolitaireModel(5, 5, 5);

  private MarbleSolitaireModel leftBlock = new EnglishSolitaireModel(3, 3, 0);
  private MarbleSolitaireModel bottomBlock = new EnglishSolitaireModel(3, 5, 3);
  private MarbleSolitaireModel rightBlock = new EnglishSolitaireModel(3, 2, 5);
  private MarbleSolitaireModel topBlock = new EnglishSolitaireModel(3, 1, 3);

  private MarbleSolitaireModel movedThree = new EnglishSolitaireModel(3, 1, 3);

  /**
   * Tests that default constructor (given no fields) is valid.
   */

  @org.junit.Test
  public void testValidDefaultConstructor() {
    assertEquals(7, defaultThrees.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, defaultThrees.getSlotAt(3, 3));
  }

  /**
   * Tests whether move() method works. Moves marble at (1,3)
   * to empty center slot of the default constructor.
   */

  @Test
  public void testOneMove() {
    //Down
    defaultThrees.move(1, 3, 3, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(defaultThrees);
    String oneMoveVisual = "    O O O"
            + "\n    O _ O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(oneMoveVisual, testView.toString());
  }


  /**
   * Tests whether the code returns true when the game is over.
   */
  @org.junit.Test
  public void testIsGameOver() {
    assertEquals(false, defaultThrees.isGameOver());
  }

  @org.junit.Test
  public void testGameOverTrue() {
    MarbleSolitaireModel wrong = new EnglishSolitaireModel(1);
    assertEquals(true, wrong.isGameOver());
  }

  /**
   * Tests whether getBoardSize()
   * indeed returns the board's longest dimension.
   */
  @org.junit.Test
  public void testGetBoardSize() {
    assertEquals(7, defaultThrees.getBoardSize());
    assertEquals(13, armThicknessFive.getBoardSize());
  }

  /**
   * Tests whether code returns Empty when given
   * the location of the empty slot.
   */
  @org.junit.Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, defaultThrees.getSlotAt(3, 3));
  }

  /**
   * Tests that code returns number of remaining marbles on the
   * board when running getScore(). Running getScore() on the
   * default 3's board should return 32 marbles.
   */
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

  @Override
  protected MarbleSolitaireModel getModel() {
    return new EnglishSolitaireModel();
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
    return 32;
  }

  @Override
  protected MarbleSolitaireModel getModelOne() {
    return new EnglishSolitaireModel(5);
  }

  @Override
  protected int getRowOne() {
    return 5;
  }

  @Override
  protected int getColOne() {
    return 5;
  }

  @Override
  protected int getScoreOne() {
    return 90;
  }

  @Override
  protected MarbleSolitaireModel getModelTwo() {
    return new EnglishSolitaireModel(2,2);
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
    return 32;
  }

  @Override
  protected MarbleSolitaireModel getModelFive() {
    return new EnglishSolitaireModel(5,5,5);
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
    return 104;
  }
}