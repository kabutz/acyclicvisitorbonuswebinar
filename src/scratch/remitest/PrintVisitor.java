package scratch.remitest;

public class PrintVisitor implements Visitor {
  private final StringBuilder sb = new StringBuilder();

  protected void append(String s) {
    sb.append(s);
  }

  public void visit(scratch.remitest.Number number) {
    sb.append(number).append(' ');
  }

  public void visit(Plus plus) {
    sb.append("+ ");
  }

  public String toString() {
    return sb.toString().trim();
  }
}