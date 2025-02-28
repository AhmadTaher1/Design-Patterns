package TemplateMethod;



/*
لو عندي ألة بتعمل بيتزا و عايز اني اعملها بس باشكال مختلفة فكل الخطوات هتبقى هي هي بس في نقطة التشكيل بس هي اللي هتختلف فنا كدة هبقى قدامي حل من 2 الاول اني اعمل 2
كلاس بحيث كل واحد فيهم يبقى لشكل من اشكال البيتزا و هيبقى كل حاجة فيهم متكررة ما عدا جزء صغير بتاع التشكيل و هنا في مشاكل كتير وهي
that i violated the DTY Principle

the good solution

to use template method design pattern
اني هعمل ابستراكت كلاس فيها كل الخطوات الاساسية زي التامبلت و الخطوة اللي هتختلف تبقى ابستراكت فنكشن كل واحد يعملها بطريقته

when to use??
when we have a certain algo and a certain steps in it can be subjected to change

cons:

that all the classes have to commit to the main steps without any exceptions

 */

abstract class MakePizza{

    public void bakePizza(){

        System.out.println("Baking pizza....");
    }

    abstract void definePizzaShape();

    public void putAddOns(){

        System.out.println("puting AddOns....");
    }

    public void HeatPizza(){

        System.out.println("Heating pizza....");
    }


    //contains all the steps of the Algo
    public void MakePizza(){

        bakePizza();
        definePizzaShape();
        putAddOns();
        HeatPizza();
    }

}

class RoundedPizza extends MakePizza {

    @Override
    void definePizzaShape() {
        System.out.println("MAKING THE PIZZA ROUNDED....");
    }
}

class SquarePizza extends MakePizza {
    @Override
    void definePizzaShape() {
        System.out.println("MAKING THE PIZZA Square shaped....");
    }
}




public class Main {
    public static void main(String[] args) {

        SquarePizza squarePizza=new SquarePizza();
        squarePizza.MakePizza();

        System.out.println("**********************************************");

        RoundedPizza roundedPizza=new RoundedPizza();
        roundedPizza.MakePizza();
    }
}
