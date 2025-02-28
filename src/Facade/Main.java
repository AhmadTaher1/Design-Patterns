package Facade;

/*
Yes, the Facade design pattern can be used in web APIs,
and it's actually a common practice. In web development,
the Facade pattern helps simplify complex subsystems by providing a unified and simplified interface.
clint deals with facade and facade deals with subsystem

its good in isolation ->changes doesn't affect the client
we can have more than one facade to a sigle system
 */




//the sub system classes of a cinema are:

class Amplifier{

    public void setStreamingPlayer(StreamingPlayer streamingPlayer){}
    public void on(){}
    public void setSurroundSound(){}
    public void setVolume(){}
}

class Tuner{

}

class StreamingPlayer{
    public void on(){}
    public void play(String name){}
}

class TheaterLights{

    public void dim(){}
}

class Screen{
    public void down(){}
}

class PopCornPoper{
    public void pop(){}
    public void on(){}
}

//********************************************************************************************

class CinemaFacade{

    private PopCornPoper popCornPoper=new PopCornPoper();
    private Screen screen=new Screen();
    private TheaterLights theaterLights=new TheaterLights();
    private StreamingPlayer streamingPlayer=new StreamingPlayer();
    private Tuner tuner=new Tuner();
    private Amplifier amplifier =new Amplifier();

    public void watchMovie(String name){
        popCornPoper.on();
        popCornPoper.pop();
        screen.down();
        theaterLights.dim();
        streamingPlayer.on();
        streamingPlayer.play(name);
        amplifier.on();
        amplifier.setStreamingPlayer(streamingPlayer);
    }


}






//client
public class Main {
    //I can call all the systems classes here or simply use facade Design pattern to do this for me and just call it
    public static void main(String[] args) {
        new CinemaFacade().watchMovie("tito");
    }
}



