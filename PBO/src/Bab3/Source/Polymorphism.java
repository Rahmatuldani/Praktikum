package Bab3.Source;

public class Polymorphism {
    public static void main(String[] args) {
        Karyawan K[] = new Karyawan[3];
        K[0] = new Manager();
        K[1] = new Receptionist();
        K[2] = new Manager();

        for (int i = 0; i < 3; i++) {
            System.out.println("Gaji karyawan : " + i + " adalah Rp " + K[i].gettotalgaji());
        }

        for (int i = 0; i < 3; i++) {
            K[i].naikgaji();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Gaji karyawan : " + i + " sekarang adalah Rp " + K[i].gettotalgaji());
        }
    }
}
