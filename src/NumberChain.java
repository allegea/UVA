/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class NumberChain {

    static int asc = 0;
    static int dsc = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


       
        while (true) {
            int number = Integer.parseInt(in.readLine());
            HashMap<Integer, Integer> chain = new HashMap<Integer, Integer>();
            if (number == 0) {
                break;
            }
 
            System.out.println("Original number was " + number);

            int len = 0;
            while (!chain.containsKey(number)) {
                // ant=act;
                chain.put(number, number);
                sort(number);
                number = dsc - asc;
                System.out.println(dsc + " - " + asc + " = " + number);

                len++;
            }
            System.out.println("Chain length " + len+"\n");


        }

        in.close();
        System.exit(0);

    }

    static void sort(int x) {

        ArrayList<Integer> number = new ArrayList<Integer>();
        while (x != 0) {
            number.add(x % 10);
            x /= 10;
        }
        Collections.sort(number);
        int curr = 0;
        asc = 0;
        dsc = 0;
        while (curr < number.size()) {
            asc = asc * 10 + number.get(curr);
            dsc = dsc * 10 + number.get(number.size() - 1 - curr);
            curr++;
        }
        //System.out.println(asc+" - "+dsc);
    }
}
