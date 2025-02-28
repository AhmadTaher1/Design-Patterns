package Command;

import java.util.ArrayList;
import java.util.List;



/*

when to use??


if i hava a class with too many lines and i need to reduce its code

1-to encapsulate a request in an object
2-Decouple sender from processor or reciever
3-Undo operation
4-when we have to much fumctionality within a class

cons:

1-usually used with another design patterns
2-to achieve the goal it requries large number of classes and objects
3-each command is an object


*/





//3am ali
class Receiver{

    private int id;
    private int money;



    public Receiver(int id) {
        money=0;
        this.id = id;
    }

    public void sendMoney(int money){

        this.money+=money;
        System.out.println("reciever "+id+" total money = "+this.money);
    }

}

//osama
class Invoker{

    public void excute(Command command) {
       command.excut();
    }

}



 interface Command{
   public void excut();
}

 class SendMOneyCommand implements Command {

    private  Receiver receiver;

     public SendMOneyCommand(Receiver receiver) {
         this.receiver = receiver;
     }

     @Override
     public void excut() {
         receiver.sendMoney(500);
     }
 }

class SendMOneyToAllCommand implements Command {

    private List<Receiver> Receivers;

    public SendMOneyToAllCommand(Receiver[] receivers) {
        Receivers=new ArrayList<>();
        for(Receiver r:receivers){

            Receivers.add(r);
        }

    }

    public void AddReceiver(Receiver receiver) {
      Receivers.add(receiver);
    }

    @Override
    public void excut() {
        for(Receiver receiver:Receivers){
            receiver.sendMoney(500);
        }
    }
}


//3am ahmed
public class Main {

    public static void main(String[] args) {

        Invoker Osama=new Invoker();
        Receiver ali=new Receiver(0);
        SendMOneyCommand sendMOneyCommand=new SendMOneyCommand(ali);
        Osama.excute(sendMOneyCommand);
        Osama.excute(sendMOneyCommand);

        System.out.println("********************");

        Receiver kmal=new Receiver(1);
        Receiver mos3ad=new Receiver(2);
        Receiver[]receivers={ali,kmal,mos3ad};
        SendMOneyToAllCommand sendMOneyToAllCommand=new SendMOneyToAllCommand(receivers);
        Osama.excute(sendMOneyToAllCommand);


    }







}
