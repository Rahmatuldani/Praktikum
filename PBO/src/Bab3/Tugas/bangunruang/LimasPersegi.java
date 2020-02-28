package Bab3.Tugas.bangunruang;

import java.math.*;

public class LimasPersegi extends BangunRuang {
    public double tinggi, lalas, lsegitiga;

    public LimasPersegi(double sisi, double tinggi) {
        this.sisi = sisi;
        this.tinggi = tinggi;
        this.Luas();
        this.Volume();
    }

    public double lAlas(){
        lalas = sisi*sisi;
        return lalas;
    }

    public double lSegitiga() {
        double setalas = sisi/2;
        double tsegitiga = Math.sqrt(Math.pow(tinggi,2) + Math.pow(setalas,2));
        lsegitiga = (sisi*tsegitiga)/2;
        return lsegitiga;
    }

    @Override
    public double Luas() {
        return super.Luas(lalas+4*lsegitiga);
    }

    @Override
    public double Volume() {
        return super.Volume((lalas*tinggi)/3);
    }
}
