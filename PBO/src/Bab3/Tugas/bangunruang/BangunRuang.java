package Bab3.Tugas.bangunruang;

public class BangunRuang {
    public double luas, volume, jari, sisi;
    public final double phi = 3.14;

    public double Luas(double luas) {
        this.luas = luas;
        return this.luas;
    }

    public double Volume(double volume) {
        this.volume = volume;
        return this.volume;
    }

    public double Luas() {
        return luas;
    }

    public double Volume() {
        return volume;
    }
}
