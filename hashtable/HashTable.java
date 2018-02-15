/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author hannah.goett
 */
public class HashTable implements HashInterface {
     int size;
    String string;

    public HashTable(int size){
     this.size = size;
    }
    
    @Override
    public void report(){
    
    }
    
    @Override
    public int size(){
        return  size;
    }
    
    @Override
    public String find(String s){
        return s;
    }
    
    @Override
    public String remove(String s){
        return s;
    }
    
    @Override
    public void insert(String s){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
