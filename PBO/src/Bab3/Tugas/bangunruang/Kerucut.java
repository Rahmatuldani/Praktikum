package Bab3.Tugas.bangunruang;

import java.math.*;

public class Kerucut extends BangunRuang {
    private double tinggi;

    public Kerucut(double jari, double tinggi) {
        super.jari = jari;
        this.tinggi = tinggi;
        this.Luas();
        this.Volume();
    }

    @Override
    public double Luas() {
        double s = Math.sqrt(Math.pow(tinggi,2) + Math.pow(jari,2));
        return super.Luas(phi*jari*(jari+s));
    }

    @Override
    public double Volume() {
        return super.Volume((phi*jari*jari*tinggi)/3);
    }
}
