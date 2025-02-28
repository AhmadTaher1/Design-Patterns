package Factory;
/*
the wrong old way:
1->take input from user
2->based on the type or the input we create different type of object

Product p;
if(input=="Object A"){
    p=new productA();
}
else if(input=="Object B"){
 p=new productB();
}
and so on in each context
so we create the obj inside the context
what if I need to add productM ??????
so I will change the code of the context, and thus I violated open close principle
which will lead to many work on every context and may be more bugs
as I need to modify in every context

the right way is that every context will contact the factory and the factory will handle the creation process.


//modification will be only in one place #here
Factory{

    public static Product create(user input){

        Product p;
        if(input=="Object A"){
            p=new productA();
        }
        else if(input=="Object B"){
         p=new productB();
        }
        and so on

    }

}


context A {
//context here can be considered as a link just a link between the factory and user input
product xxxx=Factory.create("Object A"); and that's it.

}

I can have more than one factory



 */
public class Main {
}
