package methodhandles_gof1;

public class PrintVisitor implements Visitor {
  protected final StringBuilder sb = new StringBuilder();

  public void visit(methodhandles_gof1.Number n) {
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
