/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roughWorking;

import java.util.*;

public class sample1 {
    
    public static void main(String[] args) {
        
        TreeSet<Integer>set = new TreeSet<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        
        set.add(10);
        set.add(20);
        set.add(30);set.add(40);
        
        System.out.println(set.ceiling(41));
        System.out.println(set.floor(9));
        
    }
    
    
}
