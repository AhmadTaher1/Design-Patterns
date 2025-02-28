package Iterator;


/*The Iterator Design Pattern is used to traverse elements in a collection
 without exposing the underlying structure.
  It provides a way to access elements sequentially
   while keeping the collection's details hidden.
 */

import java.util.Iterator;
import java.util.Stack;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}



class BookIterator implements Iterable<Book> {
    private Stack<Book> books;     //the data str that stores the data

    public BookIterator() {         //filling it
       books=new Stack<>();
    }

    public void Add(Book b){

        books.push(b);
    }



    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {       //Anonymous inner class
            private int index = 0;

            @Override
            public boolean hasNext() {  //this implementation differs from data str to another
                return index < books.size();
            }

            @Override
            public Book next() { //this implementation differs from data str to another


                if (hasNext()) {

                    return books.get(index++);


                }
                else{
                    return null;
                }

            }

        };
    }
}


//client that wants to iterate
public class Main {


    public static void main(String[] args) {
       Stack<Book> s=new Stack<>();

        BookIterator bookIterator=new BookIterator();
        bookIterator.Add(new Book("taher1"));
        bookIterator.Add(new Book("taher2"));
        bookIterator.Add(new Book("taher3"));
        bookIterator.Add(new Book("taher4"));

        bookIterator.forEach(b-> System.out.println(b.getTitle()));

        //or i can use enhanced for loop and the client doesn't care or know the details of how the data stored
    }


}
