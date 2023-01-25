interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

interface Color {
    void fill();
}

class Red implements Color {
    public void fill() {
        System.out.println("Filling with red color.");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Filling with blue color.");
    }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
    abstract Color getColor(String colorType);
}

class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }

    public Color getColor(String colorType) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        return null;
    }

    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        //get color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Color color1 = colorFactory.getColor("RED");

        //call fill method of Red
        color1.fill();

        //get an object of Color Blue
        Color color2 = colorFactory.getColor("BLUE");

        //call fill method of Color Blue
        color2.fill();
    }
}
