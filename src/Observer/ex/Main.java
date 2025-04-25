package Observer.ex;


import java.util.ArrayList;
import java.util.List;


//the event that got fired when the observable changes
class PropertyChangeEvent<T> {

    private String propertyName;
    private T oldValue;
    private T newValue;

    public PropertyChangeEvent(T oldValue, T newValue ,String propertyName) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.propertyName = propertyName;
    }

    public T getOldValue() {
        return oldValue;
    }

    public T getNewValue() {
        return newValue;
    }
    public String getPropertyName() {
        return propertyName;
    }
}




//anyone who wants to get a notification when the observable changes should implement this interface
 interface Observer<T> {

    public default void handle(PropertyChangeEvent<T> event) {
        System.out.println("Property " + event.getPropertyName() + " changed from " + event.getOldValue() + " to " + event.getNewValue());
    }
}


//the observable class that will notify the observers when it changes
abstract class Observable<T> {

    //list of observers that will be notified when the observable changes
    private List<Observer<T>> subscribers=new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        subscribers.add((Observer<T>) observer);
    }
    public void removeObserver(Observer<T> observer) {
        subscribers.remove(observer);
    }


    //this method will be called when the observable changes to notify the observers
    public void notifyObservers(PropertyChangeEvent<T> event) {
        for (Observer<T> observer : subscribers) {
            observer.handle(event);
        }
    }
}



class Person extends Observable{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        //create the event that will be fired because of the change
        PropertyChangeEvent<Integer> event = new PropertyChangeEvent<>(this.age, age, "age");
        notifyObservers(event);
        this.age = age;
    }

    public Person(int age) {
       this.age = age;
    }
    public Person () {

    }

}



public class Main implements Observer<Person> {

    public static void main(String[] args) {
        Person person = new Person();
        Main m = new Main();
        Main k = new Main();
        person.addObserver(m);
        person.addObserver(k);
        person.setAge(25);



    }


}
