//package ChainOfResponsibility;
//
//class Creature{
//
//     String name;
//     int attack;
//     int defense;
//
//    public Creature(String name, int attack, int defense) {
//        this.name = name;
//        this.attack = attack;
//        this.defense = defense;
//    }
//
//    @Override
//    public String toString() {
//        return "Creature{" +
//                "name='" + name + '\'' +
//                ", attack=" + attack +
//                ", defense=" + defense +
//                '}';
//    }
//}
//
//
//
//class CreatureModifier{
//
//    protected Creature creature;
//    protected CreatureModifier next;
//
//    public CreatureModifier(Creature creature) {
//        this.creature = creature;
//    }
//    public void add(CreatureModifier cm){
//        if(next!=null){
//            next.add(cm); // this is the recursive call
//        }
//        else{
//            next=cm;
//        }
//    }
//
//    public void handle() {
//        if (next != null) {
//            next.handle();
//        }
//    }
//
//}
//
//
//  class DoubleAttackModifier extends CreatureModifier{
//
//      public DoubleAttackModifier(Creature creature) {
//          super(creature);
//      }
//
//      @Override
//        public void handle() {
//            System.out.println("doubling the attack");
//            creature.attack*=2;
//            super.handle();
//        }
//
//
//  }
//
//class IncreaseDefenseModifier extends CreatureModifier{
//
//    public IncreaseDefenseModifier(Creature creature) {
//        super(creature);
//    }
//
//    @Override
//    public void handle() {
//        System.out.println("Increasing the defense");
//        creature.defense+=3;
//        super.handle();
//    }
//
//
//}
//
//
//class NoIncreaseModifier extends CreatureModifier{
//
//
//
//    public NoIncreaseModifier(Creature creature) {
//        super(creature);
//    }
//
//    @Override
//    public void handle() {
//        System.out.println("U R cursed");
//    }
//
//
//}
//
//
//public class ex {
//    public static void main(String[] args) {
//        Creature creature=new Creature("Vampire",10,10);
//        System.out.println(creature);
//
//        CreatureModifier cm=new CreatureModifier(creature);
//      //  cm.add(new NoIncreaseModifier(creature));    this breaks the chain as calling handle on it will not call the next one
//        cm.add(new DoubleAttackModifier(creature));
//        cm.add(new IncreaseDefenseModifier(creature));
//        cm.handle();
//        System.out.println(creature);
//    }
//}
