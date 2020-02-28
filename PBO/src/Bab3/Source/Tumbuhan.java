package Bab3.Source;

public class Tumbuhan extends MakhlukHidup {
    Tumbuhan(String nama) {
//        super(nama,0,true);
    }

    public void bernafas() {
        System.out.println(nama + "bernafas dg menghirup CO2");
    }

    public static void main(String[] args) {
        Tumbuhan t = new Tumbuhan("Bayam");
        t.status();
        t.bernafas();
    }
}
