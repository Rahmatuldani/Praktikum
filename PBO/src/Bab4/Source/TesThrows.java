package Bab3.Source;

import java.util.Scanner;

public class TesThrows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukan inputan : ");
        String input = sc.next();
        try {
            if (input.equals("Java")) {
                throw new RuntimeException(input + " dilempar");
            } else {
                System.out.println(input + " tidak dilempar");
            }
            System.out.println("Maka tulisan ini muncul");
        } catch (RuntimeException e) {
            System.out.println(input + " ditangkap disini");
            System.out.println(e);
        }
    }
}
