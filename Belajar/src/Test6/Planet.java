package Test6;

import java.util.Scanner;

public class Planet {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Thread t;
        char kembali = 'n';
        double jari;
        do {
            int pilih;
            System.out.println("1. Merkurius");
            System.out.println("2. Venus");
            System.out.println("3. Bumi");
            System.out.println("Pilihan");
            pilih = input.nextInt();

            switch (pilih){
                case 1:
                    System.out.println("Merkurius");
                    System.out.println("Masukan jari-jari : ");
                    jari = input.nextDouble();

                    t = new Thread(new Bola(jari,"Merkurius"));
                    t.start();

                    System.out.println("Venus");
                    System.out.println("Masukan jari-jari : ");
                    jari = input.nextDouble();

                    t = new Thread(new Bola(jari,"Venus"));
                    t.start();

                    System.out.println("Kembali? ");
                    kembali = input.next().charAt(0);
                    break;

                case 2:


                    System.out.println("Kembali? ");
                    kembali = input.next().charAt(0);
                    break;

                case 3:
                    System.out.println("Bumi");
                    System.out.println("Masukan jari-jari : ");
                    jari = input.nextDouble();

                    t = new Thread(new Bola(jari,"Bumi"));
                    t.start();

                    System.out.println("Kembali? ");
                    kembali = input.next().charAt(0);
                    break;

                default:
                    System.out.println("Pilihan salah");

                    kembali = 'y';
                    break;
            }
        } while (kembali == 'y');
    }
}
