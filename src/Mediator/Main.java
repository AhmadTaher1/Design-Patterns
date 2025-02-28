package Mediator;

/*
when to use??
interactions between objects without having to refer to each-others explicitly
loose coupling between objects
may be used as router to route or managing resource access
communication management
often used with the observer and also with other patterns

used to manage objects in the same context maybe they are in the same type and may be not

programming scenario:chatroom




 */


import java.util.ArrayList;
import java.util.List;

interface AirportTower{


    public void registerAirCraft(AirCraft airCraft);
    public void requestLanding(AirCraft airCraft);
    public void notifySuccess();

}
interface AirCraft{

    public void getNotified(String msg);
    public void requestLanding();
    public void notifySuccess();
    public int getID();
}


class AirBus implements AirCraft{

    private int id;
   private AirportTower myTower;

    public AirBus(int id) {
        this.id = id;
    }

    public void setMyTower(AirportTower myTower) {
        this.myTower = myTower;
        myTower.registerAirCraft(this);
    }

    @Override
    public void getNotified(String msg) {
        System.out.println(msg+"->MSG TO:AirBus");
    }

    @Override
    public void requestLanding() {
        myTower.requestLanding(this);
    }

    @Override
    public void notifySuccess() {
        myTower.notifySuccess();
    }

    @Override
    public int getID() {
        return id;
    }
}

class MiniAirBus implements AirCraft{

    private int id;
    private AirportTower myTower;


    public MiniAirBus(int id) {
        this.id = id;
    }
    public void setMyTower(AirportTower myTower) {
        this.myTower = myTower;
        myTower.registerAirCraft(this);
    }

    @Override
    public void getNotified(String msg) {
        System.out.println(msg+"->MSG TO:MiniAirBus");
    }

    @Override
    public void requestLanding() {
        myTower.requestLanding(this);
    }

    @Override
    public void notifySuccess() {
        myTower.notifySuccess();
    }

    @Override
    public int getID() {
        return id;
    }
}

class NozhaTower implements AirportTower{

    List<AirCraft> registeredAirCrafts;
    Boolean isTerminalEmpty;
    String towerName;

    public NozhaTower() {
        registeredAirCrafts=new ArrayList<>();
        isTerminalEmpty=true;
        towerName="AL NOZHA TOWER";

    }

    @Override
    public void registerAirCraft(AirCraft airCraft) {
        registeredAirCrafts.add(airCraft);
        System.out.println("Register Success"+airCraft.getClass().getName());
    }

    @Override
    public void requestLanding(AirCraft airCraft) {
        if(!isTerminalEmpty){
            airCraft.getNotified("The terminal is busy ,plz wait");
        }
        else{
            isTerminalEmpty=false;
            airCraft.getNotified(towerName+" okay u can land");

            for(AirCraft a:registeredAirCrafts){
                if(a.getID()!=airCraft.getID()){
                    a.getNotified("An Aircraft will land soon with ID : " +airCraft.getID());
                }


            }
        }

    }

    @Override
    public void notifySuccess() {
        isTerminalEmpty=true;
        for(AirCraft a:registeredAirCrafts){

            a.getNotified("NOZHA AIR TOWER TERMIAL IS NOW EMPTY");
        }
    }
}






//client
public class Main {
    public static void main(String[] args) {

        AirBus airBus1=new AirBus(1);
        MiniAirBus miniAirBus1=new MiniAirBus(2);
        NozhaTower nozhaTower=new NozhaTower();

        System.out.println("Rigertering planes");
        airBus1.setMyTower(nozhaTower);
        miniAirBus1.setMyTower(nozhaTower);
        System.out.println();

        System.out.println("airbus 1 Requests Landing");
        airBus1.requestLanding();
        System.out.println("minairbus 1 Requests Landing");
        miniAirBus1.requestLanding();
        System.out.println();

        System.out.println("airbus 1 landed successfully");
        airBus1.notifySuccess();
        System.out.println();


        System.out.println("minairbus 1 Requests Landing again");
        miniAirBus1.requestLanding();
        System.out.println();



        System.out.println("miniairbus 1 landed successfully");
        airBus1.notifySuccess();



    }
}
