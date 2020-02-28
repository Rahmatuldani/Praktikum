package Bab3.Tugas.bangundatar;

public class Persegi extends BangunDatar {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.Luas();
        this.Keliling();
    }

    @Override
    public double Luas() {
        return super.Luas(this.sisi*this.sisi);
    }

    @Override
    public double Keliling() {
        return super.Keliling(4*this.sisi);
    }
}
