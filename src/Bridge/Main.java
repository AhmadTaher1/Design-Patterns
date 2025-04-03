package Bridge;


//when we have inheritance hierarchy which results in Cartesian-product duplication
// ,we want to avoid it we use The bridge pattern (very important)


/*
in the multi-platform i need to separate the O.S and the view system so that any change in the o.s will affect it and
I will have to modify in the gui side and vice versa (decoupling)


when to use???
device large classes to two separate hierarchies
switching from inheritance to composition
instead of a class shape and two classes inherits from it red circle and blue rectangle
I have a class called shape and have two classes rec and circle
and another class called color and red,blue inherits from it (separation of concerns)
and will communicate with each-other through composition

multiplatform support like flutter switching implementation at run time



***************************React Native***************************************
Native modules like ios or android-------------Bridge-----------Javascript

 */



interface OS{
    public void doOperation();
}

class Windows implements OS{

    @Override
    public void doOperation() {
        System.out.println("doing operation on windows");
    }
}

class Linux implements OS{

    @Override
    public void doOperation() {
        System.out.println("doing operation on linux");
    }
}
class Ios implements OS{

    @Override
    public void doOperation() {
        System.out.println("doing operation on ios");
    }
}


interface CommonGUI{

    public void click();
}
class Button implements CommonGUI{

    private OS operatingSystem;         //bridge

    public Button(OS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void click() {
        operatingSystem.doOperation();
    }
}

public class Main {

    public static void main(String[] args) {

        Windows w=new Windows();
        Linux l=new Linux();
        Ios ios=new Ios();

        Button b1=new Button(w);
        Button b2=new Button(l);
        Button b3=new Button(ios);

        b1.click();
        b2.click();
        b3.click();

    }





}
