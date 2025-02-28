package AbstractFactory;



/*
 */


import java.awt.*;

class GeneralFactory {

    public static Button createButton(Type type) {
        Button result=null;
        if(type==Type.WINDOWS){
            result=WinFactory.createButton();

        } else if (type==Type.MAC) {
            result=MacFactory.createButton();
        }
        return result;
    }

    public static Box createBox(Type type) {
        Box result=null;
        if(type==Type.WINDOWS){
            result=WinFactory.createBox();

        } else if (type==Type.MAC) {
            result=MacFactory.createBox();
        }
        return result;
    }



}


class WinFactory{

    public static WinButton createButton(){

        return new WinButton();
    }
    public static WinBox createBox(){

        return new WinBox();
    }

}

class MacFactory{
    public static MacButton createButton(){

        return new MacButton();
    }
    public static MacBox createBox(){

        return new MacBox();
    }

}


class Button{
    @Override
    public String toString() {
        return "Button{}";
    }
}
class Box{}

class MacButton extends Button {
    @Override
    public String toString() {
        return "Button{Mac}";
    }
}
class MacBox extends Box{

}
class WinButton extends Button{
    @Override
    public String toString() {
        return "Button{Win}";
    }
}
class WinBox extends Box{}

enum Type{
    WINDOWS,
    LINUXL,
    MAC
}


public class Main {
    public static void main(String[] args) {
        Button b=GeneralFactory.createButton(Type.WINDOWS);
        System.out.println(b);

        Button b2=GeneralFactory.createButton(Type.MAC);
        System.out.println(b2);

    }
}
