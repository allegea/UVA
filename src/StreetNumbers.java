/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author allegea
 */
public class StreetNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {


        int cases = 0;
        for (long i = 8; i < Integer.MAX_VALUE; i++) {

            double number = (Math.sqrt((i * i + i) / 2));
            long num2 = (long) number;
            if (num2 == number) {


                System.out.printf("%10d%10d\n", num2, i);
                if (cases++ == 9) {
                    break;
                }

                i = (long) (i * 5.8);
            }
        }

        System.exit(0);

    }
}
