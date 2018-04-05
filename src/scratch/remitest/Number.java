package scratch.remitest;

public class Number extends Expression {
  private final int value;

  public Number(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return "" + value;
  }
}
