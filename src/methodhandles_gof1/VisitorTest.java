package methodhandles_gof1;

import org.junit.*;

import static org.junit.Assert.*;

public class VisitorTest {
  @Test
  public void testOnePlusTwoPlusThree() {
    // 1 2 3 + +
    Expression exp = new Plus(
        new methodhandles_gof1.Number(1), new Plus(new methodhandles_gof1.Number(2), new methodhandles_gof1.Number(3))
    );
    EvalVisitor ev = new EvalVisitor();
    exp.accept(ev);
    assertEquals(6, ev.getValue());

    PrintVisitor print = new PrintVisitor();
    exp.accept(print);
    assertEquals("1 2 3 + +", print.toString());
  }

  @Test
  public void testOnePlusTwoPlusThreePlusFour() {
    // 1 2 3 4 + + +
    Expression exp = new Plus(
        new methodhandles_gof1.Number(1), new Plus(new methodhandles_gof1.Number(2), new Plus(new methodhandles_gof1.Number(3), new methodhandles_gof1.Number(4)))
    );
    EvalVisitor ev = new EvalVisitor();
    exp.accept(ev);
    assertEquals(10, ev.getValue());

    PrintVisitor print = new PrintVisitor();
    exp.accept(print);
    assertEquals("1 2 3 4 + + +", print.toString());
  }

  @Test
  public void testOnePlusTwoPlusThreePlusFourOther() {
    // 1 2 + 3 4 + +
    Expression exp = new Plus(
        new Plus(new methodhandles_gof1.Number(1), new methodhandles_gof1.Number(2)), new Plus(new methodhandles_gof1.Number(3), new methodhandles_gof1.Number(4))
    );
    EvalVisitor ev = new EvalVisitor();
    exp.accept(ev);
    assertEquals(10, ev.getValue());

    PrintVisitor print = new PrintVisitor();
    exp.accept(print);
    assertEquals("1 2 + 3 4 + +", print.toString());
  }
}

