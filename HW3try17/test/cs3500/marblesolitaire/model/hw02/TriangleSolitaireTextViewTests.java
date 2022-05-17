package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Creates tests for TriangleSolitaireTextView class.
 */
public class TriangleSolitaireTextViewTests {

  @Test
  public void defaultTriangle() {
    MarbleSolitaireModel defaultTriangle = new TriangleSolitaireModel(5);
    MarbleSolitaireView defaultTriangleView = new TriangleSolitaireTextView(defaultTriangle);
    String defaultTriangleString = "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O";
    assertEquals(defaultTriangleString, defaultTriangleView.toString());
  }

  @Test
  public void fourTriangle() {
    MarbleSolitaireModel defaultTriangle = new TriangleSolitaireModel(4);
    MarbleSolitaireView defaultTriangleView = new TriangleSolitaireTextView(defaultTriangle);
    String defaultTriangleString = "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O";
    assertEquals(defaultTriangleString, defaultTriangleView.toString());
  }

  @Test
  public void fourTriangleDifferentEmpty() {
    MarbleSolitaireModel defaultTriangle = new TriangleSolitaireModel(4, 1, 2);
    MarbleSolitaireView defaultTriangleView = new TriangleSolitaireTextView(defaultTriangle);
    String defaultTriangleString = "    O\n"
            + "   _ O\n"
            + "  O O O\n"
            + " O O O O";
    assertEquals(defaultTriangleString, defaultTriangleView.toString());
  }

  @Test
  public void viewMoveRight() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,3,2);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(3,0,3,2);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " _ _ O O\n"
            + "O O O O O", moveTriangleView.toString());

  }

  @Test
  public void viewMoveLeft() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,3,3);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(3,1,3,3);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O _ _ O\n"
            + "O O O O O", moveTriangleView.toString());
  }

  @Test
  public void viewMoveUpLeft() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,1,0);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(3,2,1,0);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O _ O\n"
            + " O O _ O\n"
            + "O O O O O", moveTriangleView.toString());

  }

  @Test
  public void viewMoveUpRight() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,2,2);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(4,2,2,2);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O _ O\n"
            + "O O _ O O", moveTriangleView.toString());
  }

  @Test
  public void viewMoveDownRight() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,4,2);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(2,0,4,2);
    assertEquals("    O\n"
            + "   O O\n"
            + "  _ O O\n"
            + " O _ O O\n"
            + "O O O O O", moveTriangleView.toString());

  }

  @Test
  public void viewMoveDownLeft() {
    MarbleSolitaireModel moveTriangle = new TriangleSolitaireModel(5,4,2);
    MarbleSolitaireView moveTriangleView = new TriangleSolitaireTextView(moveTriangle);
    moveTriangle.move(2,2,4,2);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O _\n"
            + " O O _ O\n"
            + "O O O O O", moveTriangleView.toString());
  }

}
