package FlyWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

class user{
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public user(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "user{" + "fullName=" + fullName + '}';
    }
}


class User2{

   private static List<String> strings = new ArrayList<>();
   private int[] names;

    public User2(String fullName){

        Function<String,Integer> getOrAdd = s -> {
           if(!strings.contains(s)){
               strings.add(s);
                return strings.size()-1;
           }
           else{
                return strings.indexOf(s);
           }
        };

        names= Arrays.stream(fullName.split(" ")).mapToInt(s->getOrAdd.apply(s)).toArray();

    }

    public int[] getNames() {
        return names;
    }

    public String getName(int x) {
       return strings.get(x);
    }


    public static void print() {

        System.out.println();
        for(String s:strings){
            System.out.print(s);
            System.out.print("/");

        }
    }
}


public class test {


    public static void main(String[] args) {

        User2 user2= new User2("Ahmed Ali");
        User2 user3= new User2("Ahmed TAHER");

       for(int i: user2.getNames()) {
           System.out.print(user2.getName(user2.getNames()[i])+" ");
       }


        User2.print();



    }

}
