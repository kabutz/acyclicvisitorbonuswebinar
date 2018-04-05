package methodhandles_gof1;

public final class Number extends Expression {
  private final int value;
  public Number(int value) { this.value = value; }
  public int getValue() { return value; }
}
