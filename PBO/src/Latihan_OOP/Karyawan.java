package Latihan_OOP;

public class Karyawan {
    double gaji;
    private double bonus;
    Karyawan(){
        gaji = 1500000;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double hitungGaji(double gaji, double bonus) {
       return gaji+bonus;
    }

    public double getGaji() {
        return hitungGaji(gaji,bonus);
    }
}
