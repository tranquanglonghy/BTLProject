package dictionarycomanlines;
import java.util.Scanner;
public class DictionaryComanlines extends DictionaryManagement{
    
    public void showAllWords(){
        for (Word wr: list ){
            System.out.println("\t" + wr.get_word() + "\t" + wr.get_mean());
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
            System.out.println("\tEnter the word that you want Search");
            System.out.print("\t");
            String a = sc.nextLine(); 
            System.out.println("\t" + super.DictionaryLookup(a));
        }
       
        
    }
    public void DictionarySearcher(String c){
        for (Word wr: list){
            int d=0;
            for (int i=0; i<c.length(); ++i){
                if (wr.get_word().charAt(i) == c.charAt(i)) d++;
            }
            if (d>=3) System.out.println("\t" + wr.get_word());        
        }
    }
    
    public void DictionaryMain(){
        Scanner sc = new Scanner(System.in);
        super.insertFromFile();
        String s;
         while (!(s = sc.nextLine()).equalsIgnoreCase("Exit")){
           
           if (s.equalsIgnoreCase("Search")){
               System.out.println("\tEnter the word that you want Search");
               System.out.print("\t");
               String a = sc.nextLine();
               System.out.println("\t" + super.DictionaryLookup(a));
           }
           if (s.equalsIgnoreCase("Add"))
               super.DictionaryAddWord();
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
               System.out.println("\tEnter the word that you want Search");
               System.out.print("\t");
               String a = sc.nextLine();
               DictionarySearcher(a);}         
       }
    }
    public static void main(String[] args) {
       System.out.println("\t\t WELCOME TO DICTIONARY OF PHONENIX TEAM!");
       System.out.println("\t * Please enter Search to search word.");
       System.out.println("\t * Please enter Add to add word");
       System.out.println("\t * Please enter Delete to delete word");
       System.out.println("\t * Please enter Fix Word to fix word");
       System.out.println("\t * Please enter Fix mean to fix mean of word");
       System.out.println("\t * Please enter Large Search to search more word");
       System.out.println("\t * Please enter Show all to show all word");
       System.out.println("\t * Please enter Export to file to export to file");
       System.out.println("\t * Please enter Exit to Exit");
       DictionaryComanlines cml = new DictionaryComanlines();
       cml.DictionaryMain();
     
    }
    
}
