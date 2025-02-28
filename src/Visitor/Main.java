package Visitor;

/*
when to use??
when we need to perform an operation on all elements of a complex object str.

programming scenarios:
store app ex



cons:
when needing to add a new Taxholder we will violate the open close principle for the visitor and will need
to add code to the VisitorA class

may be visitor needs to access the class private fields but as he is from outside so he won't be able to so it's a must to have a getter for those needed fields

 */


import java.util.ArrayList;
import java.util.List;

interface Taxholder{
    public void accept(Visitor visitor);
}
class House implements Taxholder{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Company implements Taxholder{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Factory implements Taxholder{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class TaxCollectorCompany implements Taxholder{

    List<Taxholder> taxholderList=new ArrayList<Taxholder>();
    @Override
    public void accept(Visitor visitor) {
            for(Taxholder taxholder:taxholderList){
                taxholder.accept(visitor);
            }
            //after visiting the tax holder the visitor will visit the tax collector co. to report
            visitor.visit(this);
    }



    public void addFacilityToCollectTaxes(Taxholder taxholder){
        taxholderList.add(taxholder);
    }
}

//visitor
interface Visitor{
    public void visit(Company c);
    public void visit(Factory f);
    public void visit(House h);
    public void visit(TaxCollectorCompany taxCollectorCompany);
}

class VisitorA implements Visitor{

    int collectedMoney=0;

    @Override
    public void visit(Company c) {
        collectedMoney+=10;
        System.out.println("collecting tax money from a company");
    }

    @Override
    public void visit(Factory f) {
        collectedMoney+=15;
        System.out.println("collecting tax money from a Factory");
    }

    @Override
    public void visit(House h) {
        collectedMoney+=5;
        System.out.println("collecting tax money from a house");
    }

    @Override
    public void visit(TaxCollectorCompany taxCollectorCompany) {
        System.out.println("Money collected => "+collectedMoney);
    }
}

public class Main {
    public static void main(String[] args) {
        Company c=new Company();
        Company c2=new Company();
        Factory f1=new Factory();
        Factory f2=new Factory();
        House h1=new House();
        House h2=new House();


        TaxCollectorCompany taxCollectorCompany=new TaxCollectorCompany();
        taxCollectorCompany.addFacilityToCollectTaxes(c);
        taxCollectorCompany.addFacilityToCollectTaxes(c2);
        taxCollectorCompany.addFacilityToCollectTaxes(f1);
        taxCollectorCompany.addFacilityToCollectTaxes(f2);
        taxCollectorCompany.addFacilityToCollectTaxes(h1);
        taxCollectorCompany.addFacilityToCollectTaxes(h2);



        VisitorA Taher=new VisitorA();
        //hire a visitor
        taxCollectorCompany.accept(Taher);



    }
}
