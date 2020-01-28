/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cows_and_bulls;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author gabrys
 */
public class Cows_and_bulls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        
        boolean won = false;
        String rn = Integer.toString(rd.nextInt(9)+1);
        
        process: while(rn.length()!=4) {
        	String add = Integer.toString(rd.nextInt(9)+1);
        	for(int i = 0;i<rn.length();i++) {

        		if(Integer.parseInt(Character.toString(rn.charAt(i)))==Integer.parseInt(add)) {
        			continue process;
        		}
        	}
        	rn = rn.concat(add);
        }
                
        while(!won) {
            System.out.println("Whats your number?: ");
            String inp = sc.next();
            
            if(cows_bulls(inp, rn)) {
                System.out.println("You have won!");
                System.exit(1);
            }
        }
    }
    public static boolean cows_bulls(String minp,String mrn) {
        int inpa[] = new int[4];
        int mrna[] = new int[4];
        for(int i=0;i<4;i++) {
            
            inpa[i] = minp.charAt(i);
            mrna[i] = mrn.charAt(i);
        }
            
            int bulls = 0;
            int cows = 0;
            
            for(int i=0;i<4;i++) {
                if(inpa[i] == mrna[i]) {
                    bulls++;
                }
                else {
                    for(int x: mrna) {
                        if(inpa[i] == x) {
                            cows++;
                        }
                    }
                }

            }
            if(bulls==4) {
            	return true;
            }
            System.out.println("Cows: " + cows + " Bulls: " + bulls);
			return false;
    }
    
}
