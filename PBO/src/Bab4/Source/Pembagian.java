package Bab3.Source;

public class Pembagian {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            System.out.println("Nilai a: " + a);
            System.out.println("Nilai a: " + b);
            c = a / b;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
            System.out.println("Bukan angka. Inisialisasi dengan nilai 0");
        } catch (ArithmeticException ae) {
            System.out.println(ae);
            System.out.println("Pembagi tidak boleh nol");
            b = 1;
            //karena terjadi exception maka harus dilakukan pembagian lagi
            c = a/ b;
            System.out.println("Inisialisasi b dg nilai 1");
        } finally {
            System.out.println("Nilai a : " + a);
            System.out.println("Nilai b : " + b);
            System.out.println("Hasil : " + c);
        }
        System.out.println("Selesai");
    }
}
