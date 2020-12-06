package exercise10;

public class Ellipse extends Figure implements ClickListener {
    public Ellipse() {
        super(new Point(0, 0), 1, 1);
    }

    public Ellipse(Point startPoint, double a, double b) {
        super(startPoint, a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(otherEllipse.startPoint, otherEllipse.side1, otherEllipse.side2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }
    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }
    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }
    @Override
    public boolean equal(Figure otherFigure) {
        if (otherFigure instanceof Ellipse) {
            return super.equal(otherFigure);
        } else {
            return false;
        }
    }
    @Override
    public boolean containsClick(Point click) {
        double xc = Math.pow((click.x - (side1 + startPoint.x)), 2)/(Math.pow(side1, 2));
        double yc = Math.pow((click.y - (side2 + startPoint.y)), 2)/(Math.pow(side2, 2));

        boolean condition = xc + yc <= 1;
        return condition;
    }
}
