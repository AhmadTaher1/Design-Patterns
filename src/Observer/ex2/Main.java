package Observer.ex2;

public class Main {

    public static void main(String[] args) {
        Observer ahmed=new Observer("ahmed");
        Observer bahaa=new Observer("bahaa");
        Observer yosf=new Observer("yosf");
        Subject mohsen=new Subject();

        ahmed.setSubject(mohsen);
        bahaa.setSubject(mohsen);
        yosf.setSubject(mohsen);

        mohsen.attach(ahmed);
        mohsen.attach(bahaa);
        mohsen.attach(yosf);

        ahmed.hit();
        System.out.println("**************");
        yosf.hit();
        System.out.println("**************");
        ahmed.hit();
        System.out.println("**************");
        mohsen.detach(ahmed);
        yosf.hit();






    }
}
