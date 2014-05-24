/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;


import java.util.*;

/**
 * @author allegea
 */
public class TheBlocksProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.parseInt(in.readLine());

        ArrayList<Stack<Integer>> pila = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < n; i++) {
            pila.add(i, new Stack<Integer>());
            pila.get(i).push(i);

        }

        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }

        while (true) {
            String line = in.readLine();
            if (line.equals("quit")) {
                break;
            }
            String[] inst = line.split("[ ]");
            int ini = Integer.parseInt(inst[1]);
            int fin = Integer.parseInt(inst[3]);
            if (ini == fin || pos[ini] == pos[fin]) {
                continue;
            }


            if (inst[0].equals("move")) {

                if (inst[2].equals("onto")) {

                    while (pila.get(pos[fin]).peek() != fin) {
                        int val = pila.get(pos[fin]).pop();
                        pila.get(val).push(val);
                        pos[val] = val;
                    }

                    while (pila.get(pos[ini]).peek() != ini) {
                        int val = pila.get(pos[ini]).pop();
                        pila.get(val).push(val);
                        pos[val] = val;
                    }
                    int val = pila.get(pos[ini]).pop();

                    pila.get(pos[fin]).push(val);
                    pos[val] = pos[fin];

                } else {
                    while (pila.get(pos[ini]).peek() != ini) {
                        int val = pila.get(pos[ini]).pop();
                        pila.get(val).push(val);
                        pos[val] = val;
                    }
                    int val = pila.get(pos[ini]).pop();

                    pila.get(pos[fin]).push(val);
                    pos[val] = pos[fin];

                }

            } else {
                if (inst[2].equals("onto")) {
                    while (pila.get(pos[fin]).peek() != fin) {
                        int val = pila.get(pos[fin]).pop();
                        pila.get(val).push(val);
                        pos[val] = val;
                    }

                    int posi = pila.get(pos[ini]).indexOf(ini);
                    int lin = pos[ini];
                    int[] elem = new int[pila.get(pos[ini]).size() - posi];
                    int i = 0;

                    while (pila.get(lin).size() > posi) {

                        int val = pila.get(lin).pop();
                        elem[i++] = val;

                        pos[val] = pos[fin];

                    }
                    for (i = elem.length - 1; i >= 0; i--) {
                        pila.get(pos[fin]).push(elem[i]);
                    }
                } else {


                    int posi = pila.get(pos[ini]).indexOf(ini);
                    int lin = pos[ini];
                    int[] elem = new int[pila.get(pos[ini]).size() - posi];
                    int i = 0;

                    while (pila.get(lin).size() > posi) {

                        int val = pila.get(lin).pop();
                        elem[i++] = val;

                        pos[val] = pos[fin];

                    }
                    for (i = elem.length - 1; i >= 0; i--) {
                        pila.get(pos[fin]).push(elem[i]);
                    }

                }

            }


        }


        for (int i = 0; i < n; i++) {
            StringBuffer out = new StringBuffer("");
            out.append(i + ":");
            for (int j = 0; j < pila.get(i).size(); j++) {
                out.append(" " + pila.get(i).get(j));
            }
            System.out.println(out);
        }

        in.close();
        System.exit(0);

    }
}
