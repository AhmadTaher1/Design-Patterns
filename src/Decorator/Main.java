package Decorator;

/*
facilitates adding new functionality to an object without altering its structure or inheriting from it
when to use?
extra behavior at runtime instead of using static inheritance
also for final classes that can't be extended
makes the components reusable
java io is an example for the decorator design pattern
 */




interface PizzaComponent{
    public double cost();
    public String printDescription();
}
class BasicPizza implements PizzaComponent{

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String printDescription() {
        return "BasicPizza";
    }
}

class ShrimpComponent implements PizzaComponent{

   private PizzaComponent com;

    public ShrimpComponent(PizzaComponent com) {
        this.com = com;
    }

    @Override
    public double cost() {
        return com.cost()+5;
    }

    @Override
    public String printDescription() {
        return com.printDescription()+" + shrimp";
    }
}

class HotdogComponent implements PizzaComponent{

    private PizzaComponent com;

    public HotdogComponent(PizzaComponent com) {
        this.com = com;
    }

    @Override
    public double cost() {
        return com.cost()+3;
    }

    @Override
    public String printDescription() {
        return com.printDescription()+" + Hotdog";
    }
}


class Kiricomponent implements PizzaComponent{

    private PizzaComponent com;

    public Kiricomponent(PizzaComponent com) {
        this.com = com;
    }

    @Override
    public double cost() {
        return com.cost()+1.5;
    }

    @Override
    public String printDescription() {
        return com.printDescription()+" + Kiri";
    }
}



public class Main {
//حاليا انا عايز بيتزا عليها جمبري و بعدين حطلي عليها هوت دوج بعدين حطلي عليها كيري

    public static void main(String[] args) {
        BasicPizza basicPizza=new BasicPizza();
        ShrimpComponent shrimpComponent=new ShrimpComponent(basicPizza);
        HotdogComponent hotdogComponent=new HotdogComponent(shrimpComponent);
        Kiricomponent kiricomponent=new Kiricomponent(hotdogComponent);
        System.out.println(kiricomponent.cost());
        System.out.println(kiricomponent.printDescription());


        //or
        var customPizza=new Kiricomponent(new HotdogComponent(new ShrimpComponent(new BasicPizza())));
        System.out.println(customPizza.cost());
        System.out.println(customPizza.printDescription());
    }






}
