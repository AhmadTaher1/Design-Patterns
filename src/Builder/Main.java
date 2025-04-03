package Builder;

//fluent builder pattern allows chaining by returning the same object "return this;" @ the end of each method

/*
used for piecewise construction of an object

when we have a class with many parameters
I don't need every time I create object to set values for all of its parameters
solutions??
we may pass nulls to unnecessary att.
we can create multiple constructors
the best solution is to create a builder

why using it ???
1️⃣ Only specify needed parameters
You don’t have to pass null or default values explicitly.
You can choose to set only what’s needed.

2️⃣ Improves Readability
Instead of multiple constructors, you use chained method calls.

3️⃣ Immutable Object Creation
The builder allows setting values before object creation, ensuring immutability.

4️⃣ Easier to Extend
If you add more fields later, you don’t need to modify or add constructors.

🔥 Summary
Builder Pattern solves the Telescoping Constructor Problem.
Makes object creation clearer and flexible.
Helps maintain immutable objects.
Better extensibility for future attributes.
Final Thought


Using multiple constructors seems simpler at first,
 but as complexity increases,
 the Builder Pattern makes code more maintainable and easier to read.
  If you're working on a project where objects have many optional fields,
  the builder is a better long-term choice.

  عشان مضطرش احفظ ترتيب و تبقى عملية الكرييشن اسهل

 */







class User{

    private final String Fname;
    private final  String lname;
    private  final String phone;
    private final String address;
    private final int age;

    private User(UserBuilder builder){
        this.Fname=builder.Fname;
        this.lname= builder.lname;
        this.age= builder.age;
        this.address=builder.address;
        this.phone=builder.phone;


    }

    public static class UserBuilder{

        private  String Fname="";
        private  String lname="";
        private  String phone="";
        private  String address="";
        private  int age=30;

        //we put in the constructor the att. which is a must in any user
        public UserBuilder(String fname, String lname) {
            Fname = fname;
            this.lname = lname;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this; //we return the same user builder so that we can call another method on it
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }


        public User build(){
            User user=new User(this);
            //we can validate user here
            return user;

        }
    }

}
public class Main {

    public static void main(String[] args) {

        User user1 = new User.UserBuilder("Ahmad", "Taher")
                .setAge(29)
                .setAddress("damietta")
                .setPhone("01118559515")
                .build();

        System.out.println(user1);

    }



}
