package TemplateMethod.ex2;

abstract class Game{

    protected String name;
    protected int numberOfPlayers;

    //taking the template method as final to prevent overriding
    protected final void run(){;

        start();
        while(!foundWinner()){
            takeTurn();
        }
        end();
    }


    //abstract methods to be implemented by the subclasses so the skeleton is already set but the details of the steps are left for the inheritors
    abstract void start();
    abstract boolean foundWinner();
    abstract void takeTurn();
    abstract void end();

}

class Chess extends Game{

    private String player1;
    private String player2;
    private int turns;


    public Chess(String player1, String player2) {
        this.name = "Chess";
        this.numberOfPlayers = 2;
        this.player1 = player1;
        this.player2 = player2;
        this.turns = 0;
    }


    //implementing the details of the steps we don't have to override the template method as when calling it ,it will do the same steps but this time with the concrete methods not the abstract ones.
    @Override
    void start() {
        System.out.println("Starting the Game of Chess.......");
    }

    @Override
    boolean foundWinner() {
        if(turns == 10){
            System.out.println("Found a winner");
            return true;
        }
        return false;
    }

    @Override
    void takeTurn() {
        turns++;
        System.out.println("Turn number "+turns+" for player "+(turns % 2 == 1?player1:player2));
    }

    @Override
    void end() {
        System.out.println("Game has reached an end ....and the winner is -> "+player2);
    }
}


public class Main {
    public static void main(String[] args) {
        Game chess = new Chess("ahmed", "Hashim");
        chess.run();
    }
}
