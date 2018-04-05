package traditional_gof1;

public interface Visitor {
  default void visit(Number n) {
    visit((Expression) n);
  }
  default void visit(Plus p) {
    visit((Expression) p);
  }
  default void visit(Expression expression) {
    throw new IllegalStateException("Unexpected expression: " + expression);
  }
}

