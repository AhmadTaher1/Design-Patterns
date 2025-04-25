package Observer.ex2;




//when to use??
//when having an object which needs to be observed by one or more observer
//decoupling oberver and observable  -> when modifing each side i don't have to change anything in the other side
//used in MVC pattern
//observable doesn't know which observer updates its status
//difficult debugging


import java.util.ArrayList;
import java.util.List;

 class Observer{


   private String name;
   private Subject subject;

     public Observer(String name) {
         this.name = name;
     }

     public void setSubject(Subject subject) {
        this.subject = subject;
    }


    void hit(){
        subject.setState("Mohsen's AIIIY");
    }

   void update(){

       System.out.println(name+" heard "+subject.getState());

   }
}




public class Subject {

   private List<Observer> observers=new ArrayList<>();
   private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){

        for(Observer obs:observers){
            obs.update();
        }

    }

}
