package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest extends AbstractModelTest {
  MarbleSolitaireModel testTriangle = new TriangleSolitaireModel(5, 0, 0);
  MarbleSolitaireModel testTriangleSix = new TriangleSolitaireModel(6, 4, 1);
  MarbleSolitaireModel oneTriangle = new TriangleSolitaireModel(1);
  MarbleSolitaireModel testTriangleSeven = new TriangleSolitaireModel(7,6,3);
  MarbleSolitaireModel testTriangleFour = new TriangleSolitaireModel(4,2,1);
  MarbleSolitaireModel defaultTriangle = new TriangleSolitaireModel();
  private MarbleSolitaireModel e;



  @Test(expected = IllegalArgumentException.class)
  public void negativeInitialRow() {
    new TriangleSolitaireModel(-1,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeInitialColumn() {
    new TriangleSolitaireModel(2,-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooBigInitialRow() {
    new EuropeanSolitaireModel(7, 32,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooBigInitialColumn() {
    new TriangleSolitaireModel(9,3, 45);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidLengthNegative() {
    new TriangleSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidLengthZero() {
    new TriangleSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidStarting() {
    testTriangle.move(-3, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDestination() {
    testTriangle.move(2, 2, 2, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDistance() {
    testTriangle.move(3, 0, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDistanceTwo() {
    testTriangle.move(5, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDestinationEmpty() {
    testTriangle.move(0,0, 0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidAcrossEmpty() {
    testTriangleSeven.move(6,4,6,2);
  }

  @Test
  public void testMoveLeftOnly() {
    MarbleSolitaireModel testTriangleSix = new TriangleSolitaireModel(6, 4, 1);
    testTriangleSix.move(4,3,4,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(4, 2));
  }

  @Test
  public void testMoveRightOnly() {
    MarbleSolitaireModel testTriangleFour = new TriangleSolitaireModel(4,2,3);
    testTriangleFour.move(2,1,2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleFour.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleFour.getSlotAt(2, 2));
  }

  @Test
  public void testMoveUpOnly() {
    MarbleSolitaireModel testTriangle = new TriangleSolitaireModel(5, 0, 0);
    testTriangle.move(2,0,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangle.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangle.getSlotAt(1, 0));
  }

  @Test
  public void testMoveDownOnly() {
    MarbleSolitaireModel testTriangleFour = new TriangleSolitaireModel(4,2,1);
    testTriangleFour.move(0,0,2,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleFour.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleFour.getSlotAt(1, 0));
  }

  @Test
  public void testMoveUpRight() {
    MarbleSolitaireModel testTriangleSix = new TriangleSolitaireModel(6, 4, 1);
    testTriangleSix.move(4,3,2,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(3, 2));
  }

  @Test
  public void testMoveUpLeft() {
    MarbleSolitaireModel testTriangleSix = new TriangleSolitaireModel(6, 4, 1);
    testTriangleSix.move(4,3,2,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(4, 3));
  }

  @Test
  public void testMoveDownRight() {
    MarbleSolitaireModel testTriangleSix = new TriangleSolitaireModel(6, 4, 1);
    testTriangleSix.move(4,3,6,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleSix.getSlotAt(5, 2));
  }

  @Test
  public void testMoveDownLeft() {
    MarbleSolitaireModel testTriangleOne = new TriangleSolitaireModel(5, 3, 1);
    testTriangleOne.move(1,0,3,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            testTriangleOne.getSlotAt(2, 2));
  }


  @org.junit.Test
  public void issGameOver() {
    assertEquals(false, testTriangleFour.isGameOver());
  }

  @org.junit.Test
  public void isGameOverTrue() {
    assertEquals(true, oneTriangle.isGameOver());
  }

  @Test
  public void isGameOverDefault() {
    MarbleSolitaireModel defaultTriangle = new TriangleSolitaireModel(5,0,0);
    assertEquals(false, defaultTriangle.isGameOver());
  }

  @Test
  public void completedGame() {
    MarbleSolitaireModel completeGame = new TriangleSolitaireModel(5,4,2);
    e.move(4,4,4,2);
    e.move(4,1,4,3);
    e.move(2,1,4,1);
    e.move(2,2,4,2);
    e.move(4,2,4,4);
    e.move(4,4,2,2);
    e.move(1,1,3,3);
    e.move(4,0,4,2);
    e.move(2,0,4,0);
    e.move(0,0,2,0);
    assertEquals(true, e.isGameOver());
  }

  @Override
  protected MarbleSolitaireModel getModel() {
    return new TriangleSolitaireModel();
  }

  @Override
  protected int getDefaultRow() {
    return 0;
  }

  @Override
  protected int getDefaultCol() {
    return 0;
  }

  @Override
  protected int getDefaultScore() {
    return 14;
  }

  @Override
  protected MarbleSolitaireModel getModelOne() {
    return new TriangleSolitaireModel(6);
  }

  @Override
  protected int getRowOne() {
    return 0;
  }

  @Override
  protected int getColOne() {
    return 0;
  }

  @Override
  protected int getScoreOne() {
    return 20;
  }

  @Override
  protected MarbleSolitaireModel getModelTwo() {
    return new TriangleSolitaireModel(2,2);
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
    return 14;
  }

  @Override
  protected MarbleSolitaireModel getModelFive() {
    return new TriangleSolitaireModel(5,1,1);
  }

  @Override
  protected int getRowFive() {
    return 1;
  }

  @Override
  protected int getColFive() {
    return 1;
  }

  @Override
  protected int getScoreFive() {
    return 14;
  }
}
