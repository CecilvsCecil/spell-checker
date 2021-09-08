import java.util.*;

public class SpellTest{
    
    public static void main(String[] args){
        
        SpellChecker sc = new SpellChecker("words.txt");
        // System.out.println(sc);
        
        List<String> incorrect = sc.getIncorrectWords("test.txt");
        
        for(String word : incorrect){
            
            System.out.println(word);
            
        }
        
        Set<String> suggested = sc.getSuggestions("words");
        
        for(String word : suggested){
            
            System.out.println(word);
            
        }
        
    }
    
}