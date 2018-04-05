package mh_extended_gof;

import methodhandles_gof1.*;

public class Minus extends Expression {
  private final Expression first, second;
  public Minus(Expression first, Expression second) {
    this.first = first; this.second = second;
  }

  protected Class<? extends Visitor> getVisitorClass() {
    return MinusVisitor.class;
  }

  public void accept(Visitor v) {
    first.accept(v);
    second.accept(v);
    super.accept(v);
  }
}
