package app;

import utils.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author michelle
 */
public class SampleCollisions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "Siblings";
        String b = "Teheran";
        // The above values will result in identical hashCodes 
        // and therefore are good for testing collisions
//        System.out.println(a+ " hashcode: " + a.hashCode());
//        System.out.println(b+ " hashcode: " + b.hashCode());
//        
        String c = "Michelle";
        
        HashMap map = new HashMap();
        map.put(a, "The Siblings Entry");
        System.out.println("Retrieved from map using \"" + a + "\" as key: " + map.get(a));
        map.put(c, "The Michelle Entry");
        System.out.println("Retrieved from map using \"" + c + "\" as key: " + map.get(c));
    }
    
}
