package ChainOfResponsibility;


import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
    protected Game game;

    public Creature(Game game) {
        this.game = game;
        game.creatures.add(this);
       // System.out.println("Inside Creature, this.getClass(): " + this.getClass().getSimpleName());
        //if this constructor worked due to chaining while creating Goblin for ex so  this.getClass() will be Goblin
        //as this will always point to the actual object that has been created

    }

    public abstract int getAttack();
    public abstract int getDefense();
}

class Goblin extends Creature
{
    public Goblin(Game game)
    {
        super(game);

    }

    @Override
    public int getAttack()
    {
        int attack = 1;
        for (Creature creature : game.creatures)
        {
            if (creature instanceof GoblinKing)
            {
                attack++;
            }
        }
        return attack;
    }

    @Override
    public int getDefense()
    {
        int defense =1;
        for(Creature creature : game.creatures)
        {
            if(!creature.equals(this) ){
                defense++;
            }


        }

        return defense;
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game);
    }
    @Override
    public int getAttack()
    {
        return 3;
    }

    @Override
    public int getDefense()
    {
        int defense =3;
        for(Creature creature : game.creatures)
        {
            if(!creature.equals(this)){
                defense++;
            }
        }

        return defense;
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}


public class ex2 {

    public static void main(String[] args) {
        Game game = new Game();
        Goblin g1 = new Goblin(game);
        Goblin g2 = new Goblin(game);
        GoblinKing gk = new GoblinKing(game);

        System.out.println("g1 attack: "+g1.getAttack()); //2
        System.out.println("g1 defense: "+g1.getDefense());//3

        System.out.println("g2 attack: "+g2.getAttack()); //2
        System.out.println("g2 defense: "+g2.getDefense());//3

        System.out.println("gk attack: "+gk.getAttack()); //3
        System.out.println("gk defense: "+gk.getDefense());//5
    }
}
