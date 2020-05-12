package Kuis;

public class Test {
    protected int tulis, coding, wawancara, pilihan, nim;
    String jabatan;
    Test(int tulis, int coding, int wawancara, int pilihan, int nim, String jabatan){
        this.tulis = tulis;
        this.coding = coding;
        this.wawancara = wawancara;
        this.pilihan = pilihan;
        this.jabatan = jabatan;
        this.nim = nim;
        proses();
    }

    public void proses(){
        int hasil = (tulis + coding + wawancara + pilihan)/4;
        if (hasil > 85){
            System.out.println("Selamat! NIM " + nim + " Lulus menjadi "+ jabatan +"\n");
        } else {
            System.out.println("Mohon maaf. NIM "+ nim +" Belum Lulus menjadi "+ jabatan +", silahkan coba lagi tahun depan\n");
        }
    }
}
