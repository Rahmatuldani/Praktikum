package Bab3.Tugas.bangunruang;

import java.math.*;

public class Kubus extends BangunRuang {

    public Kubus(double sisi) {
        super.sisi = sisi;
    }

    @Override
    public double Luas() {
        return super.Luas(6*Math.pow(super.sisi,2));
    }

    @Override
    public double Volume() {
        return super.Volume(Math.pow(super.sisi,3));
    }
}
