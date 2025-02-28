package prototype;



/*







 */


class User{

    public String Fname;
    public String lname;
    private   String phone;
    private  String address;
    private  int age;


    //copy constructor
    public User(User user) {
        Fname = user.Fname;
        this.lname = user.lname;
        this.phone =user. phone;
        this.age = user.age;
        this.address = user.address;
    }

    public User(String fname, String lname, String phone, int age, String address) {
        Fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

    public User() {

    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }



//must be inside the class of the old instance so it can see its public and private fields to copy it
    public User copy(){
        User user=new User();
        user.Fname=this.Fname;
        user.lname=this.lname;
        user.address=this.address;
        user.phone=this.phone;
        user.age=this.age;
        return user;
    }

    //thus we created a clone
    public User copyByAnotherWay(){
        return new User(this);
    }





    @Override
    public String toString() {
        return "User{" +
                "Fname='" + Fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        User user=new User("Ahmad","Taher","01550140811",28,"new damietta");
        User userTwo=user.copyByAnotherWay();
        System.out.println(user);
        System.out.println(userTwo);
        System.out.println(user.hashCode());
        System.out.println(userTwo.hashCode());

    }


}
