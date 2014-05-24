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
public class AllInAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String line;
        /*line = in.readLine();
        int cases = Integer.parseInt(line);
        int act = 0;*/
        while ((line = in.readLine()) != null) {
            StringTokenizer read = new StringTokenizer(line);
            char[] or = read.nextToken().toCharArray();
            char[] re = read.nextToken().toCharArray();

            int size = 0;
            for (int i = 0; i < re.length && size < or.length; i++) {
                if (or[size] == re[i]) {
                    size++;
                }
            }
            if (size == or.length) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

        in.close();
        System.exit(0);

    }
}
