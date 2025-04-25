package Strategy.ex1;
/*

when to use??

لو عندي اوبجكت بيستخدم خوارزميات مختلفة و بيحتاج يبدل بينهم في الruntime فبدل ما احطهم كلهم في الاوبجكت
و استخدم الس و اف الس كتير ببساطة هخلي كل خوارزميى في كلاس معين و الاوبجكت بتاعي يدوب هينفذ الخوارزمية اللي انا باعتهاله بس من غير ما يبقى عارف تفاصيلها و انواعها
المعلومات دي اللي عارفها بس هو الكونتكست (المهندس)


class Mechanic2{
    private String carType="";

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public void disassembleCar(){
        if(carType=="TOYOTA"){
            System.out.println("Performing toyota disassembly ALGO.");
        }
        else if (carType=="CHEV"){
            System.out.println("Performing chev disassembly ALGO.");
        }
    }

    //and so on so every time i add an algo i will violate the open close principle
    //and this class will be complex
    //and now the algo and the mechanic are tightly coupled
    //what about testing as i'd like to tset each ALGO alone
}

programming senarios?
Gaming if evety level uses a certrain algo.
Sorting if i will have to sort my work according to differenet algo

cons:
increased no. of classes
client has to know about Stratigies

 */

abstract class Algorithm{
    public abstract void  performAlgo();
}

class Toyota extends Algorithm{

    @Override
    public void performAlgo() {
        System.out.println("Performing toyota disassembly ALGO.");
    }
}


class Chev extends Algorithm{

    @Override
    public void performAlgo() {
        System.out.println("Performing Chev disassembly ALGO.");
    }
}



class Mechanic{

    private Algorithm algo;

    public void setAlgo(Algorithm algo) {
        this.algo = algo;
    }
    public void disassembleCar(){
        algo.performAlgo();
    }

}

//context(Engineer) who tells blya which algo. to use
public class Main {

    public static void main(String[] args) {
        Mechanic BLYA =new Mechanic();


        System.out.println("toyota car entered the garage");
        BLYA.setAlgo(new Toyota());
        BLYA.disassembleCar();

        System.out.println("****************************************************");

        System.out.println("Chev car entered the garage");
        BLYA.setAlgo(new Chev());
        BLYA.disassembleCar();



    }




}
