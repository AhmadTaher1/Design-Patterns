package Adapter;

//there's to type of adapters with caching and without cashing
//str design pattern
/*
(object adapter)
I have components which implement old interface 3rd party for ex and now the 3rd party introduces new interface so
my component have to adapt so it can use this new I so we will provide a wrapper or adapter or converter to achieve that its just an extend
not a modification

when to use???
new interface incompatible with the old component

adapting something(adaptee)to be suitable for doing the work in general without changing the client حاجة فيشتها ثلاثية
and also without changing the old interface

we were turning the obj to card so we can view it in the listView
thus we respect open close principle

when updating the java collection that was using the enum to be using the iterator they used the adapter design pattern


often we ask the third party for the implementation of the adapter
we can get confused about adapter & decorator
 */


interface OldInterface{

    public boolean hasNext();
    public String nextElements();

}

class ComponentTypeA implements OldInterface{


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String nextElements() {
        return "";
    }
}

class ComponentTypeB implements OldInterface{


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String nextElements() {
        return "";
    }
}

interface NewInterface{

    public boolean hasMoreEements();
    public String next();
    public void remove();

}


// one adapter can adapt more than an interface as the class can implement more than an interface
//he can make the employee wear a jacket in winter and a short in summer on the beach
class OldToNewAdapter implements NewInterface{

    private OldInterface Comp;

    public OldToNewAdapter(OldInterface comp) {
        Comp = comp;
    }

    @Override
    public boolean hasMoreEements() {
        return Comp.hasNext();
    }

    @Override
    public String next() {
        return Comp.nextElements();
    }

    @Override
    public void remove() {
        //as the old interface and its components not supporting this operation and this is one of this desipn pattern cons
        throw  new UnsupportedOperationException();
    }


}


//the client were we use the components
public class Main {

    public static void main(String[] args) {

        ComponentTypeA a=new ComponentTypeA();
        ComponentTypeB b=new ComponentTypeB();
        if(a.hasNext() && b.hasNext()){
            System.out.println("every thing is okay");
        }

        //the old component didn't change it's the same but with a wrapper to adapt
        OldToNewAdapter adpata=new OldToNewAdapter(a);
        OldToNewAdapter adpatb=new OldToNewAdapter(b);
        if(adpata.hasMoreEements() && adpatb.hasMoreEements()){
            System.out.println("every thing is okay");
        }

    }


}
