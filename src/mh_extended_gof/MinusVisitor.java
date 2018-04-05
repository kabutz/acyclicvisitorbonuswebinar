package mh_extended_gof;

import methodhandles_gof1.*;

public interface MinusVisitor extends Visitor {
  default void visit(Minus m) {
    visit((Expression)m);
  }
}
