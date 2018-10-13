package dictionarycomanlines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DictionaryManagement extends Dictionary {

    protected ArrayList insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        String s = sc.nextLine();
        String c;
        for (int i = 0; i < size; ++i) {
            s = sc.nextLine();
            c = sc.nextLine();
            super.list.add(new Word(s,c));
        }
        return list;
    }

    protected ArrayList insertFromFile() {
        File file = new File("testfile.txt");
        FileReader fr;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            String s;
            while ((line = br.readLine()) != null) {
               String [] ss;
               s = line;
               ss = s.split("\t",2);                        
               list.add(new Word(ss[0],ss[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return super.list;
    }

    protected String DictionaryLookup(String c) {
        String a = null;
        for (Word wr : super.list) {
            if (c.equalsIgnoreCase(wr.get_word())) {
                    a = wr.get_mean();
                }
            }
        return a;    
    }

    protected void DictionaryAddWord(){
        System.out.println("\tEnter word that you want add");
        System.out.print("\t");
        Scanner sc = new Scanner(System.in);
        String word_add = sc.nextLine();
        int d=0;
        for (Word wr : super.list){
            if (!word_add.equalsIgnoreCase(wr.get_word())) d++;
            else break;
        }
        
        if (d != list.size()) System.out.println("\tyour word had in databse");
        else
        {
            System.out.println("\tThis mean is");
            System.out.print("\t");
            String this_mean = sc.nextLine();
            list.add(new Word(word_add, this_mean));
        }
    }

    protected void DictionaryDeleteWord(){
        System.out.println("\tEnter the word you want delete");
        System.out.print("\t");
        Scanner sc = new Scanner(System.in);
        String word_delete = sc.nextLine();
        int d=0;
        for (Word wr : list){
            if (!word_delete.equalsIgnoreCase(wr.get_word())) d++;
        }
        if (d == list.size()) System.out.println("\tyour word do not have in databse");
        else{
        int j = 0;
        for (Word wr : list) {
            if (wr.get_word().equalsIgnoreCase(word_delete)) {
                break;
            } else {
                        ++j;
                    }
        }
        list.remove(j);
        }
    }
    
    protected void DictionaryFixWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\tEnter the word you want Fix");
        System.out.print("\t");
        String word_want_fix = sc.nextLine();
        int d=0;
        for (Word wr : list){
            if (!word_want_fix.equalsIgnoreCase(wr.get_word())) d++;
        }
        if (d == list.size())
            System.out.println("\tyour word do not have in databse");
        else{
            System.out.println("\tword be fix is");
            System.out.print("\t");
            String word_new = sc.nextLine();
            for (Word wr : list) {
                if (wr.get_word().equalsIgnoreCase(word_want_fix)) {
                    wr.set_word(word_new);
                }
            }
        }
    }
    
    protected void DictionaryFixMean(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\tEnter the word you want to fix this mean");
        System.out.print("\t");
        String word_want_fix = sc.nextLine();
        int d=0;
        for (Word wr : list){
            if (!word_want_fix.equalsIgnoreCase(wr.get_word())) d++;
        }
        if (d == list.size()) System.out.println("\tYour word not have in databse");
        else 
        {
        System.out.println("\tNew mean of word is");
        System.out.print("\t");
        String new_word_mean = sc.nextLine();
            for (Word wr : list) {
                if (wr.get_word().equalsIgnoreCase(word_want_fix)) {
                    wr.set_mean(new_word_mean);
                }
            }
        }
    }

    protected void DictionaryExportToFile() {
        try {
            File fileDir = new File("testfile.txt");

            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), "UTF8"));
            for (Word wr : list) {
                out.append(wr.get_word()+"\t"+wr.get_mean() + "\r\n");
            }
            out.flush();
            out.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
