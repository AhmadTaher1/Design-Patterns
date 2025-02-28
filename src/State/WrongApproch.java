package State;

class Worker{

    String currentBook="zoo";

    public void getNextBook() {
        if (currentBook == "zoo") {
            currentBook = "Math";
            System.out.println("Getting math");
        } else if (currentBook == "Math") {
            currentBook = "Science";
            System.out.println("Getting Science");
        } else if (currentBook == "Science") {
            currentBook = "Arabic";
            System.out.println("Getting Arabic");
        } else if (currentBook == "Arabic") {
            currentBook = "Eng";
            System.out.println("Getting English");
        }

    }
}

public class WrongApproch {
    public static void main(String[] args) {
        Worker abdo=new Worker();
        abdo.getNextBook();
        abdo.getNextBook();
        abdo.getNextBook();
        abdo.getNextBook();


    }
}



