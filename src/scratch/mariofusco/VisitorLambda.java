package scratch.mariofusco;

import java.util.*;
import java.util.function.*;

public class VisitorLambda {

  private static double square(double number) {
    return number * number;
  }

  static Function<Object, Double> areaVisitor = new LambdaVisitor<Double>()
      .on(Square.class).then(s -> square(s.getSide()))
      .on(Circle.class).then(c -> Math.PI * square(c.getRadius()))
      .on(Rectangle.class).then(r -> r.getHeight() * r.getWidth());

  static Function<Object, Double> perimeterVisitor = new LambdaVisitor<Double>()
      .on(Square.class).then(s -> 4 * s.getSide())
      .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius())
      .on(Rectangle.class).then(r -> 2 * r.getHeight() + 2 * r.getWidth());

  static ToDoubleFunction<Object> areaVisitor2 = new LambdaVisitorDouble()
      .on(Square.class).then(s -> square(s.getSide()))
      .on(Circle.class).then(c -> Math.PI * square(c.getRadius()))
      .on(Rectangle.class).then(r -> r.getHeight() * r.getWidth());

  static ToDoubleFunction<Object> perimeterVisitor2 = new LambdaVisitorDouble()
      .on(Square.class).then(s -> 4 * s.getSide())
      .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius())
      .on(Rectangle.class).then(r -> 2 * r.getHeight() + 2 * r.getWidth());

  public static void main(String[] args) {
    List<Object> figures = List.of(new Circle(4), new Square(5), new Rectangle(6, 7));

    double totalArea = figures.stream().map(areaVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
    System.out.println("Total area = " + totalArea);

    double totalArea2 = figures.stream().mapToDouble(areaVisitor2).sum();
    System.out.println("Total area2 = " + totalArea2);

    double totalPerimeter = figures.stream().map(perimeterVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
    System.out.println("Total perimeter = " + totalPerimeter);
  }
}