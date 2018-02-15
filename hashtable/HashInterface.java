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
public interface HashInterface {
    public void insert(String s);
    public String remove(String s);
    public String find(String s);
    public int size();
    public void report();
}
