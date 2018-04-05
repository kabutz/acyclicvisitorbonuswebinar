package scratch.remitest;

public interface Visitor {
  void visit(Number number);

  void visit(Plus plus);

//  void visit(Expression expression);
}
