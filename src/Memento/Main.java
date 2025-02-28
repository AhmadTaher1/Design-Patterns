package Memento;


/*

when to use???

used to externalize object state to provide rollback functionality (creating save points like GTA)

to apply undo functionality on anything

cons:

can be expensive in large copy(if the states we saved are very large here we only saved name and score)
stack must have max number of checkpoints so the class won't be heavy
the caretaker must not access the state of the game just expose the state for the memento


 */

import java.util.Stack;

//Originator
class Game{
  private  String playerName;
  private  int playerScore;


    public Game(String playerName) {
        this.playerName = playerName;
        this.playerScore =0;
    }

    public CheckPoint save(){
        return new CheckPoint(this.playerName,this.playerScore);
    }


    public void revert(CheckPoint checkPoint){
        this.playerName=checkPoint.getPlayerName();
        this.playerScore=checkPoint.getPlayerScore();
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}

//memento
class CheckPoint{

    private  String playerName;
    private  int playerScore;

    public CheckPoint(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}


//the place where we save the momento deals with game
class CareTaker{

    //could be any collection but we prefer stack to undo
    Stack<CheckPoint> saves;

    public CareTaker() {
        saves=new Stack<>();
    }

    public void save(Game game){
        saves.push(game.save());
    }

    public void revert(Game game){
       game.revert(saves.pop());
    }

}

public class Main {
    public static void main(String[] args) {

        Game game=new Game("Ahmed Taher");
        CareTaker careTaker=new CareTaker();

        //checkpoint 1
        careTaker.save(game);

        //change in the state
        game.setPlayerName("samy");
        game.setPlayerScore(220);


        //checkpoint 2 if we forgot to do this step the progress won't be saved
        //try to comment this line to notice
      //  careTaker.save(game);


        System.out.println("before undo");
        System.out.println(game.getPlayerName());
        System.out.println(game.getPlayerScore());
        System.out.println("*******************************");


        //undo is equivalent to close the game
        careTaker.revert(game);

        System.out.println("After undo");
        System.out.println(game.getPlayerName());
        System.out.println(game.getPlayerScore());


    }
}
