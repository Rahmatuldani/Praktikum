package Bab3.Source;

public abstract class MakhlukHidup {

    protected String nama;
    protected int jumlahkaki;
    protected boolean bisaterbang;

    public void MakhlukHidup(String nama, int jumlahkaki, boolean bisaterbang){
        this.nama = nama;
        this.jumlahkaki = jumlahkaki;
        this.bisaterbang = bisaterbang;
    }

    abstract void bernafas();

    public void status() {
        System.out.println("Nama : " + nama);
        System.out.println("\nJumlah kaki : " + jumlahkaki);
        System.out.println("\nBisa terbang? : " + bisaterbang);
    }
}
