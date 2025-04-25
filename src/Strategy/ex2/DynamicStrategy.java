package Strategy.ex2;

import java.util.Arrays;
import java.util.List;

enum OutputFormat {
    HTML,
    Normal
}


//general interface for the list strategy
interface ListStrategy {
 public default void start(StringBuilder sb){};
 public  void addListItem(String item,StringBuilder sb);
 public default void end(StringBuilder sb){};
}



//each one implements it in its own way
class HTMLListStrategy implements ListStrategy {
    @Override
    public void start(StringBuilder sb) {
       sb.append("<ul>");
       sb.append("\n");
    }

    @Override
    public void addListItem(String item, StringBuilder sb) {
        sb.append("  <li>" + item + "</li>");
        sb.append("\n");
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>");
        sb.append("\n");
    }
}



class NormalListStrategy implements ListStrategy {


    @Override
    public void addListItem(String item, StringBuilder sb) {
        sb.append("*  " + item);
        sb.append("\n");
    }
}



//the Algo that uses the strategy
class textEditor {
    private StringBuilder sb;
    //have a reference to the strategy generic interface
    private ListStrategy listStrategy;



    //must set the type of strategy when constructing the obj
    public textEditor(OutputFormat outputFormat) {
        sb = new StringBuilder();
        setFormat(outputFormat);
    }


    //to make it dynamic strategy pattern
    public void setFormat(OutputFormat outputFormat) {
        if (outputFormat == OutputFormat.HTML) {
            listStrategy = new HTMLListStrategy();
        }
        else {
            listStrategy = new NormalListStrategy();
        }
    }

    public void clear(){
        sb = new StringBuilder();
    }

    public void append(List<String> l){
        listStrategy.start(sb);
        for (String str : l) {
            listStrategy.addListItem(str,sb);
        }
        listStrategy.end(sb);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}



public class DynamicStrategy {
    public static void main(String[] args) {
        textEditor editor = new textEditor(OutputFormat.HTML);
        editor.append(Arrays.asList(new String[]{"Hello", "World"}));
        System.out.println(editor.toString());

        editor.setFormat(OutputFormat.Normal);
        editor.clear();
        editor.append(Arrays.asList(new String[]{"Hello", "World"}));
        System.out.println(editor.toString());
    }
}
