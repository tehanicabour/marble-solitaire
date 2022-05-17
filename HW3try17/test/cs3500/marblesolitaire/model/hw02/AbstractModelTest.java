package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Provides abstract test methods to be implemented by marble solitaire test classes.
 */
public abstract class AbstractModelTest {

  protected MarbleSolitaireModel model;

  protected abstract MarbleSolitaireModel getModel();

  protected abstract int getDefaultRow();

  protected abstract int getDefaultCol();

  protected abstract int getDefaultScore();

  protected abstract MarbleSolitaireModel getModelOne();

  protected abstract int getRowOne();

  protected abstract int getColOne();

  protected abstract int getScoreOne();

  protected abstract MarbleSolitaireModel getModelTwo();

  protected abstract int getRowTwo();

  protected abstract int getColTwo();

  protected abstract int getScoreTwo();

  protected abstract MarbleSolitaireModel getModelFive();

  protected abstract int getRowFive();

  protected abstract int getColFive();

  protected abstract int getScoreFive();


  @Before
  public void setUp() {
    model = getModel();
  }

  @Test
  public void testDefaultConstructor() {
    model = getModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            model.getSlotAt(getDefaultRow(), getDefaultCol()));
    assertEquals(getDefaultScore(), model.getScore());
  }

  @Test
  public void testConstructorFive() {
    model = getModelFive();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            model.getSlotAt(getRowFive(), getColFive()));
    assertEquals(getScoreFive(), model.getScore());
  }

  @Test
  public void testConstructorOne() {
    model = getModelOne();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            model.getSlotAt(getRowOne(), getColOne()));
    assertEquals(getScoreOne(), model.getScore());
  }

  @Test
  public void testConstructorTwo() {
    model = getModelTwo();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            model.getSlotAt(getRowTwo(), getColTwo()));
    assertEquals(getScoreTwo(), model.getScore());
  }

}
