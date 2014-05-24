/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author allegea
 */
public class Ternary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        /*line = in.readLine();
        int cases = Integer.parseInt(line);
        int act = 0;*/
        while (true) {
            int number = Integer.parseInt(in.readLine());
            if (number < 0) {
                break;
            }
            if (number == 0) {

                System.out.println(0);
                continue;
            }

            System.out.println(cambio(number, 3));


        }

        in.close();
        System.exit(0);

    }

    static String cambio(int number, int base) {
        String nuevo = "";

        while (number != 0) {
            nuevo = number % base + nuevo;
            number /= base;

        }


        return nuevo;
    }
}
