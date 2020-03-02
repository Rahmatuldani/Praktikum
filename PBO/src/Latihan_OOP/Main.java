package Latihan_OOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Nama : ");
        String nama1 = input.nextLine();
        System.out.println("Input Jumlah SKS : ");
        int sks = input.nextInt();
        Karyawan dosen = new Dosen(sks);
        System.out.println("Dosen : " + nama1 + " dengan gaji : " + dosen.getGaji());

        System.out.println("\nInput nama : ");
        String nama2 = input.next();
        System.out.println("Input jam : ");
        int jam = input.nextInt();
        Karyawan staff = new Staff(jam);
        System.out.println("Staff : " + nama2 + " dengan gaji : " + staff.getGaji());
    }
}
