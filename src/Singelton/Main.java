package Singelton;


/*
cons:-
Classes are highly coupled to the singleton
 */

class Singlton{

    private static Singlton singlton;

    private Singlton() {
    }

    public static Singlton getInstance(){

        if(singlton==null){              // First check (without locking so that not making the requests that won't create new onj wait)
            synchronized (Singlton.class) {
                if(singlton==null){    // Second check (inside lock) so if two threads enter from the first check which was unlocked the second won't create new instances
                    singlton = new Singlton();
                }
            }
        }
        return singlton;
    }


}

public class Main {

    public static void main(String[] args) {
       Singlton s= Singlton.getInstance();
       Singlton b= Singlton.getInstance();
       Singlton z= Singlton.getInstance();
        System.out.println(s);
        System.out.println(b);
        System.out.println(z);
        //s&b&z are pointing at the same object
    }

}
