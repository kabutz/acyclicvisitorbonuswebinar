package acyclic1;

public class PrintVisitor implements Visitor, PlusVisitor, NumberVisitor {
  private final StringBuilder sb = new StringBuilder();

  public void visit(Number n) {
    sb.append(n.getValue()).append(' ');
  }

  public void visit(Plus p) {
    sb.append("+ ");
  }

  public void visit(Expression expression) {
    sb.append("? ");
  }

  public String toString() {
    return sb.toString().trim();
  }
}
