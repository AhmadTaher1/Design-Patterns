package State;


/*
if an object have more than a state then when the state changes the obj behavior will change instead of using
(if-else) over and over we can use state DB

as a summary an object which behaves differently according to its state

ex: traffic lights
its state-> light color
and according to the color the behavior changes
apply open close principle
cons:
More classes ->more code

 */

import java.util.Objects;

class SmartWorker{

   private Book currentBook=new Book1(this);


    public void setCurrentBook(Book currentBook) {
        this.currentBook = currentBook;
    }

    public void getNextBook() {
        Book old=currentBook;
        //the next line is the only one that matter in the context of DP
        currentBook.nextBook();
        if(old!= currentBook)
        System.out.println("getting "+currentBook.getClass().getName());

    }




}

//state
abstract class Book{
    public abstract void nextBook();
}


class Book1 extends Book{
    private SmartWorker SmartWorker;

    public Book1(SmartWorker SmartWorker) {
        this.SmartWorker = SmartWorker;
    }

    @Override
    public void nextBook() {
        SmartWorker.setCurrentBook(new Book2(SmartWorker));
        //the worker that deals with the second book is the one who deals with the first book
    }
}

class Book2 extends Book{
    private SmartWorker SmartWorker;

    public Book2(SmartWorker SmartWorker) {
        this.SmartWorker = SmartWorker;
    }

    @Override
    public void nextBook() {
        SmartWorker.setCurrentBook(new Book3(SmartWorker));
        //the worker that deals with the third book is the one who deals with the second book
    }
}

class Book3 extends Book{
    private SmartWorker SmartWorker;

    public Book3(SmartWorker SmartWorker) {
        this.SmartWorker = SmartWorker;
    }

    @Override
    public void nextBook() {
        SmartWorker.setCurrentBook(new Book4(SmartWorker));
        //the worker that deals with the fourth book is the one who deals with the third book

    }
}

class Book4 extends Book{
    private SmartWorker SmartWorker;

    public Book4(SmartWorker SmartWorker) {
        this.SmartWorker = SmartWorker;
    }

    @Override
    public void nextBook() {
        SmartWorker.setCurrentBook(new Book5(SmartWorker));
        //the worker that deals with the fifth book is the one who deals with the fourth book

    }
}

class Book5 extends Book{
    private SmartWorker SmartWorker;

    public Book5(SmartWorker SmartWorker) {
        this.SmartWorker = SmartWorker;
    }

    @Override
    public void nextBook() {
        System.out.println("the fifth is the last one");
    }
}



//manager
public class Main {
    public static void main(String[] args) {
        SmartWorker Zaki=new SmartWorker();
        Zaki.getNextBook();
        Zaki.getNextBook();
        Zaki.getNextBook();
        Zaki.getNextBook();
        Zaki.getNextBook();
        Zaki.getNextBook();
        Zaki.getNextBook();





    }
}
