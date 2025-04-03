package Composite;

/*
it's a mechanism for treating a group of objects in the same way as a single instance of an object
foo and List<foo> are treated the same way
we use it to create a tree structure
Usage???

when I want to have Single source of truth
when the core can be represented by a tree
if I will treat all the classes as one type so that I can apply polymorphism
helps with open close principle

 */


import java.util.ArrayList;
import java.util.List;

interface Component{

    String getname();
}


//leaf Node
class Textview implements Component{

  private String name;

    public Textview(String name) {
        this.name = name;
    }

    @Override
    public String getname() {
        return name;
    }
}

//leaf Node
class Webview implements Component{
   private String name;
    public Webview(String name) {
        this.name = name;
    }
    @Override
    public String getname() {
        return name;
    }
}


//not a leaf node
class Container implements Component{

    private List<Component> componentList;  //this is the most important par tof the pattern
    private String name;

    public Container(String name) {
      componentList=new ArrayList<>();
        this.name = name;
    }
    @Override
    public String getname() {
        return name;
    }

    public void addChild(Component c){
        componentList.add(c);
    }
    public void RemoveChild(Component c){
        componentList.remove(c);
    }

    public void getAllChildren(){
        for(Component c:this.componentList){
            if(c instanceof Container){
                ((Container) c).getAllChildren();

            }
            System.out.println(c.getname());
        }
    }

}


public class Main {

    public static void main(String[] args) {

        Textview textview = new Textview("text1");
        Textview textview2 = new Textview("text2");
        Webview webview = new Webview("web1");
        Container one = new Container("c1");
        Container two = new Container("c2");
        one.addChild(textview);
        one.addChild(webview);
        two.addChild(one);
        two.addChild(textview2);

        two.getAllChildren();



    }

}