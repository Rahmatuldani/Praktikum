package Bab3.Tugas.bangundatar;

public class PersegiPanjang extends BangunDatar {
    private double panjang, lebar;

    public PersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
        this.Luas();
        this.Keliling();
    }

    @Override
    public double Luas() {
        return super.Luas(panjang*lebar);
    }

    @Override
    public double Keliling() {
        return super.Keliling((2*panjang)+(2*lebar));
    }
}
