package Bab2.Tugas.package1;

import Bab2.Tugas.package2.*;

public class Tema1 {
    public static void main(String[] args) {
        Bab2.Tugas.package2.Tema1 m = new Bab2.Tugas.package2.Tema1();
        Bab2.Tugas.package1.Tema2 n = new Bab2.Tugas.package1.Tema2();
        Bab2.Tugas.package2.Tema2 o = new Bab2.Tugas.package2.Tema2();

        System.out.println("\nPackage 1 Tema 1");
        System.out.print(n.tampil() + "\n");
        System.out.print(m.tampil() + "\n");
        System.out.print(o.tampil() + "\n");

    }
}
