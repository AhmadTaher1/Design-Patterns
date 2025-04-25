package Strategy.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

enum OutputFormat {
    HTML,
    Normal
}

interface ListStrategy {
 public default void start(StringBuilder sb){};
 public  void addListItem(String item,StringBuilder sb);
 public default void end(StringBuilder sb){};
}

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


class textEditor {
    private StringBuilder sb;
    private ListStrategy listStrategy;

    public textEditor(Supplier<ListStrategy> supplier) {
        sb = new StringBuilder();
        this.listStrategy = supplier.get();
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



public class StaticStrategy {
    public static void main(String[] args) {


        textEditor editor = new textEditor(()->new HTMLListStrategy());
        editor.append(Arrays.asList(new String[]{"Hello", "World"}));
        System.out.println(editor.toString());





    }
}
