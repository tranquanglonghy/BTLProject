package dictionarycomanlines;
import java.util.Scanner;
public class DictionaryComanlines extends DictionaryManagement{
    
    public void showAllWords(){
        for (Word wr: list ){
            System.out.println(wr.get_word());
            System.out.println(wr.get_mean());
        }           
    }
    
    public void DictionaryBasic(){
        super.insertFromFile();
        showAllWords();
    }
    
    public void DictionaryAdvanced(){
        super.insertFromFile();
        showAllWords();
        Scanner sc = new Scanner(System.in);
        String s ;
        while (!(s = sc.nextLine()).equalsIgnoreCase("Exit")){
            System.out.println("Enter the word that you want Search");
            String a = sc.nextLine(); 
            System.out.println(super.DictionaryLookup(a));
        }
       
        
    }
    public void DictionarySearcher(String c){
        for (Word wr: list){
            int d=0;
            for (int i=0; i<c.length(); ++i){
                if (wr.get_word().charAt(i) == c.charAt(i)) d++;
            }
            if (d>=3) System.out.println(wr.get_word());        
        }
    }
    
    public void DictionaryMain(){
        Scanner sc = new Scanner(System.in);
        super.insertFromFile();
        String s;
         while (!(s = sc.nextLine()).equalsIgnoreCase("Exit")){
           
           if (s.equalsIgnoreCase("Search")){
               System.out.println("Enter the word that you want Search");
               String a = sc.nextLine();
               System.out.println(super.DictionaryLookup(a));              
           }
           if (s.equalsIgnoreCase("Delete"))
               super.DictionaryDeleteWord();
           if (s.equalsIgnoreCase("Fix Word"))
               super.DictionaryFixWord();
           if (s.equalsIgnoreCase("Fix mean"))
               super.DictionaryFixMean();
           if (s.equalsIgnoreCase("Show all"))
               showAllWords();
           if (s.equalsIgnoreCase("Export to file"))
               super.DictionaryExportToFile();        
           if (s.equalsIgnoreCase("Large Search")){
               System.out.println("Enter the word that you want Search");
               String a = sc.nextLine();
               DictionarySearcher(a);
           }
               
       }
    }
    public static void main(String[] args) {
       DictionaryComanlines cml = new DictionaryComanlines();
       cml.DictionaryMain();
     
    }
    
}
