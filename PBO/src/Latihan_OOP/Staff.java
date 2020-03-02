package Latihan_OOP;

public class Staff extends Karyawan {
    Staff(int jam){
        double bonus = jam*20000;
        setBonus(bonus);
    }
}
