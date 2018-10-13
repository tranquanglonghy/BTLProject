package dictionarycomanlines;

import java.util.ArrayList;

public class Dictionary {
    
    protected int size;
    protected ArrayList <Word> list = new ArrayList<Word>();
    
    public void set_size(int size){
        this.size = size;
    }
    public int get_size(){
        return this.size;
    } 
}
