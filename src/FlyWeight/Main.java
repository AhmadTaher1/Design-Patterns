package FlyWeight;



/*
when to use?
->Many objects that shares charactestics that don't change by time to save memory
->games
->word processing apps like word
->Drawing apps
->efficient software to save memory if we are talking about players it keeps in memory one player to render
every time he needs one and if some of its characteristics changes will modify in this object and render it

also called chache
uses factory pattern





 */


import java.util.HashMap;
import java.util.Map;

abstract class Player{
    private String mision;
    private String weapon;
    public abstract void render();
    public abstract void setMision(String mision);
    public abstract void setWeapon(String weapon);
    public abstract  String getMision();
    public abstract  String getWeapon();
}

class RedTeamPlayer extends Player{
    private String mision;
    private String weapon;
    @Override
    public void setMision(String mision) {
        this.mision = mision;
    }
    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    @Override
    public String getMision() {
        return mision;
    }
    @Override
    public String getWeapon() {
        return weapon;
    }

    public RedTeamPlayer() {
        this.mision = "capture red flag";
        this.weapon = "";
    }

    @Override
    public void render() {
        System.out.println(weapon +" and "+mision);
    }
}

class BlueTeamPlayer extends Player{
    private String mision;
    private String weapon;

    public BlueTeamPlayer() {
        this.mision = "capture blue flag";
        this.weapon = "";
    }
    @Override
    public void setMision(String mision) {
        this.mision = mision;
    }
    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    @Override
    public String getMision() {
        return mision;
    }
    @Override
    public String getWeapon() {
        return weapon;
    }


    @Override
    public void render() {
        System.out.println(weapon +" and "+mision);
    }
}


//Max the factory will have one refernce for redteam player and one reference for the blueteam player
//يعني مفيش غير 2 بلايرز في الميموري بس انا بقعد اشكلهم و اعملهم ريسيكلنج recycling
class PlayerFactory{

    private Map<String,Player> players;


    public PlayerFactory() {
        players=new HashMap<>();
    }

    public Player getPlayer(String type){

        if(players.containsKey(type)){
            return players.get(type);
        }
        else{
            if(type=="RedTeam"){
               Player p=new RedTeamPlayer();
               players.put("RedTeam",p);
               return p;
            }
            if(type=="BlueTeam"){
                Player p=new BlueTeamPlayer();
                players.put("BlueTeam",p);
                return p;
            }
            else{
                throw new  IllegalArgumentException();
            }
        }

    }


}






//client
public class Main {

    public static void main(String[] args) {
        PlayerFactory pf=new PlayerFactory();
        Player p1=pf.getPlayer("BlueTeam");
        p1.setWeapon("AkM47");//changing some characteristics
        System.out.println("player one");
        p1.render();
        System.out.println(p1);//same object in the same place in memory

        System.out.println("*********************************************");

        Player p2=pf.getPlayer("BlueTeam");
        p2.setWeapon("Auzi");                   //changing some characteristics
        p2.setMision("kill the red king");    //changing some characteristics
        System.out.println("player two");
        p2.render();
        System.out.println(p2);  //same object in the same place in memory




    }


}
