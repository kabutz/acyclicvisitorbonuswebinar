package scratch.remitest;

public class Plus extends Expression {
  private final Expression exp1, exp2;

  public Plus(Expression exp1, Expression exp2) {
    this.exp1 = exp1;
    this.exp2 = exp2;
  }

  public void accept(Visitor visitor) {
//    exp1.accept(visitor);
//    exp2.accept(visitor);
    visitor.visit(this);
  }
}
