package Bridge;

//when we have inheritance hierarchy which results in Cartesian-product duplication
// ,we want to avoid it we use The bridge pattern (very important)



//the case that needs to use the bridge pattern
//abstract class Shape
//{
//    public abstract String getName();
//}
//
//class Triangle extends Shape
//{
//    @Override
//    public String getName()
//    {
//        return "Triangle";
//    }
//}
//
//class Square extends Shape
//{
//    @Override
//    public String getName()
//    {
//        return "Square";
//    }
//}
//
//class VectorSquare extends Square
//{
//    @Override
//    public String toString()
//    {
//        return String.format("Drawing %s as lines", getName());
//    }
//}
//
//class RasterSquare extends Square
//{
//    @Override
//    public String toString()
//    {
//        return String.format("Drawing %s as pixels", getName());
//    }
//}
//
//// imagine VectorTriangle and RasterTriangle are here too
//
//
//






abstract class Shape {
    protected Renderer renderer; // Use inherited field

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

interface Renderer {
    String whatToRenderAs();
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

class Triangle extends Shape {
    public Triangle(Renderer renderer) {
        super(renderer); // Use parent constructor
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}

class Square extends Shape {
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Square";
    }
}

// Test the implementation
public class ex {
    public static void main(String[] args) {
        Shape vectorTriangle = new Triangle(new VectorRenderer());
        Shape rasterSquare = new Square(new RasterRenderer());

        System.out.println(vectorTriangle); // Drawing Triangle as lines
        System.out.println(rasterSquare);   // Drawing Square as pixels
    }
}

