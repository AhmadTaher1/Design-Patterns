package FlyWeight;


import java.util.*;

class Sentence
{

    private List<WordToken> l=new ArrayList<>();
    String[] strings;


    public Sentence(String plainText)
    {
        strings=plainText.split(" ");
        for(String st:strings){
            WordToken wt=new WordToken(st);
            l.add(wt);
        }
    }

    public WordToken getWord(int index)
    {
        return l.get(index);
    }

    @Override
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        for(WordToken w: l){
            if(w.capitalize==true){
                sb.append(w.word.toUpperCase());
                sb.append(" ");
            }
            else{
                sb.append(w.word);
                sb.append(" ");

            }


        }
        return sb.toString();
    }

    //this is the fly weight pattern part
    class WordToken
    {

        public String word;
        public boolean capitalize;
        public WordToken(String s){
            word=s;
        }
    }
}
public class ex {
    public static void main(String[] args) {
        Sentence sentence=new Sentence("ahmed taher taher yassen");
        sentence.getWord(0).capitalize=true;
        System.out.println(sentence.toString());
    }

}
