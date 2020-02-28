package Bab3.Tugas.bangunruang;

public class Balok extends BangunRuang {
    private double panjang, lebar, tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.Luas();
        this.Volume();
    }

    @Override
    public double Luas() {
        return super.Luas(2*((panjang*lebar) + (panjang*tinggi) + (lebar*tinggi)));
    }

    @Override
    public double Volume() {
        return super.Volume(panjang*lebar*tinggi);
    }
}
