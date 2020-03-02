package Latihan_OOP;

public class Dosen extends Karyawan {
    Dosen(int sks){
        double bonus = sks*50000;
        setBonus(bonus);
    }
}
