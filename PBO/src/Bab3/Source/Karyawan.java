package Bab3.Source;

public class Karyawan {

    double gaji;
    private double bonus;

    Karyawan(){
        gaji = 100000;
        bonus = 20000;
        System.out.println("Gaji mula-mula : Rp " + gaji + " dan bonus standar : " + bonus);
    }

    private double hitunggaji(double gaji, double bonus){
        return gaji + bonus;
    }

    void naikgaji(){
        System.out.println("Beda profesi beda gaji");
    }

    void setbonus(double bonus){
        this.bonus = bonus;
    }

    double gettotalgaji(){
        return hitunggaji(gaji, bonus);
    }
}
