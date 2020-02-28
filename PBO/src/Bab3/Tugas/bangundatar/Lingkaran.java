package Bab3.Tugas.bangundatar;

import java.math.*;

public class Lingkaran extends BangunDatar {
    private final double phi = 3.14;
    private double jari;

    public Lingkaran(double jari){
        this.jari = jari;
        this.Luas();
        this.Keliling();
    }

    @Override
    public double Luas() {
        return super.Luas(phi*Math.pow(jari,2));
    }

    @Override
    public double Keliling() {
        return super.Keliling(phi*2*jari);
    }
}
