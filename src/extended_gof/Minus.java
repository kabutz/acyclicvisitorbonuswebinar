package extended_gof;

import traditional_gof1.*;

public class Minus extends Expression {
  private final Expression first, second;
  public Minus(Expression first, Expression second) {
    this.first = first; this.second = second;
  }
  public void accept(Visitor v) {
    first.accept(v);
    second.accept(v);
    if (v instanceof MinusVisitor) {
      ((MinusVisitor) v).visit(this);
    } else {
      v.visit(this);
    }
  }
}
