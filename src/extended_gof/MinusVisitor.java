package extended_gof;

import traditional_gof1.*;

public interface MinusVisitor extends Visitor {
  default void visit(Minus m) {
    visit((Expression)m);
  }
}
