package Interpreter;


import java.util.StringTokenizer;

interface Expression{
public boolean interpret(String context);
}

class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        StringTokenizer st= new StringTokenizer(context);
        while(st.hasMoreTokens()){

            String temp=st.nextToken().toString();
            if(temp.equals(this.data)){

                return true;
            }
        }

        return false;
    }
}

class Orexpression implements Expression{

   private Expression exp1;
   private Expression exp2;

    public Orexpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    //هل الاكسبرشن الاول موجود او التاني موجود؟
    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) || exp2.interpret(context) ;
    }
}

class Andexpression implements Expression{

    private Expression exp1;
    private Expression exp2;

    public Andexpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    //هل الاكسبرشن الاول موجود و التاني موجود؟
    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) && exp2.interpret(context) ;
    }
}


class Interpreter{

public Expression BuildInterpreterTree(){

    TerminalExpression t1=new TerminalExpression("Lions");
    TerminalExpression t2=new TerminalExpression("Tigers");
    TerminalExpression t3=new TerminalExpression("Bears");

    //tigers and bears
   var alternation1= new Andexpression(t2,t3);
   //lions or (tigers and bears)
   var alternation2= new Orexpression(t1,alternation1);
   //bears and (lions or (tigers and bears))
   var alternation3= new Andexpression(t3,alternation2);

   return alternation3 ;

}

}



//zaki or the client
public class Main {

    public static void main(String[] args) {
//bears and (lions or (tigers and bears))
        String context1="Tigers Bears";
        //bears mogoda -> 1 and (lions or (tigers and bears))
        //lions msh mogoda-> 1 and (0 or (tigers and bears))
        //tigers mogoda->1 and (0 or (1 and bears))
        //bears mogoda->1 and (0 or (1 and 1))
        //1 and (0 or 1)
        //1 and 1 -> true

        String context2="Bears Lions";
        //bears mogoda -> 1 and (lions or (tigers and bears))
        //lions  mogoda-> 1 and (1 or (tigers and bears))
        //1 and 1 -> true

        String context3="Bears Tigers Bears";
        //bears mogoda -> 1 and (lions or (tigers and bears))
        //lions msh mogoda-> 1 and (0 or (tigers and bears))
        //tigers mogoda->1 and (0 or (1 and bears))
        //bears mogoda->1 and (0 or (1 and 1))
        //1 and (0 or 1)
        //1 and 1 -> true

        String context4="Bears";
        //bears mogoda -> 1 and (lions or (tigers and bears))
        //lions msh mogoda-> 1 and (0 or (tigers and bears))
        //tigers msh mogoda->1 and (0 or (0 and bears))
        //bears mogoda->1 and (0 or (0 and 1))
        //1 and (0 or 0)
        //1 and 0 -> false



        String context5="Tigers";
        //bears msh mogoda -> 0 and (lions or (tigers and bears))
        //lions msh mogoda-> 0 and (0 or (tigers and bears))
        //tigers mogoda->1 and (0 or (1 and bears))
        //bears msh mogoda->1 and (0 or (1 and 0))
        //1 and (0 or 0)
        //1 and 1 -> false


        String context6="Lions";
        //bears msh mogoda -> 0 and (lions or (tigers and bears))
        //lions  mogoda-> 0 and (1 or (tigers and bears))
        //tigers  msh mogoda->1 and (0 or (0 and bears))
        //bears msh mogoda->1 and (0 or (0 and 0))
        //1 and (0 or 0)
        //1 and 0 -> false



        String context7="Lions Lions";



        Interpreter interpreter=new Interpreter();
        System.out.println(interpreter.BuildInterpreterTree().interpret(context1));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context2));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context3));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context4));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context5));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context6));
        System.out.println(interpreter.BuildInterpreterTree().interpret(context7));


    }


}
