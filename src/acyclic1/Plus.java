package acyclic1;

public final class Plus extends Expression {
  private final Expression first, second;
  public Plus(Expression first, Expression second) {
    this.first = first; this.second = second;
  }
  public void accept(Visitor v) {
    first.accept(v);
    second.accept(v);
    if (v instanceof PlusVisitor) {
      ((PlusVisitor)v).visit(this);
    } else {
      // yeah what???
    }
  }
}
