import java.util.*;
import java.io.*;

public class SpellChecker implements SpellCheckerInterface{
    
    private HashSet<String> hashTable;
    
    public SpellChecker(String filename){
        
        try{
            
            hashTable = new HashSet<>();
            Scanner input = new Scanner(new File(filename));
            
            while(input.hasNext()){
            
                String word = input.next().toLowerCase().replaceAll("\\p{Punct}", "");
                hashTable.add(word);
            
            }
            
        }
        
        catch(Exception e){
            
            System.out.println("File Not Found!");
            
        }
           
    }
    
    public List<String> getIncorrectWords(String filename){
        
        try{
            
            LinkedList<String> incorrect = new LinkedList<>();
            Scanner in = new Scanner(new File(filename));

            while(in.hasNext()){
            
                String word = in.next().toLowerCase().replaceAll("\\p{Punct}", "");
            
                if(!hashTable.contains(word)){
                
                    incorrect.add(word);
                
                }
            
            }
        
            return incorrect;
        }
        
        catch(Exception e){
            
            System.out.println("File Not Found!");
            
        }
        
        return new LinkedList<String>();
        
    }
    
    public Set<String> getSuggestions(String word){
        
        char[] characters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        HashSet<String> suggestions = new HashSet<>();
        
        for(char ch : characters){
            
            for(int i = 0; i <= word.length(); i++){
                
                StringBuilder sb1 = new StringBuilder(word);
                sb1.insert(i, ch);
                
                if(hashTable.contains(sb1.toString())){
                    
                    suggestions.add(sb1.toString());
                    
                }
                
            }
            
        }
        
        for(int i = 0; i < word.length(); i++){
            
            StringBuilder sb2 = new StringBuilder(word);
            sb2.deleteCharAt(i);
            
            if(hashTable.contains(sb2.toString())){
                
                suggestions.add(sb2.toString());
                
            }
            
        }
        
        for(int i = 0; i < word.length() - 1; i++){
            
            StringBuilder sb3 = new StringBuilder(word);
            
            char temp = sb3.charAt(i);
            sb3.setCharAt(i, sb3.charAt(i + 1));
            sb3.setCharAt(i + 1, temp);
            
            if(hashTable.contains(sb3.toString())){
                
                suggestions.add(sb3.toString());
                
            }
            
        }
        
        return suggestions;
        
    }
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        
        for(String word : hashTable){
            
            sb.append(word + "\n");
            
        }
        
        return sb.toString();
        
    }
    
}