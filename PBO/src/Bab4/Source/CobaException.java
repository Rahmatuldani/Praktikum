package Bab3.Source;

public class CobaException {
    public static void main(String[] args) {
        int nilai = 0;
        try {
            nilai = Integer.parseInt(args[0]);
            //dalam block exception-handling
        } catch (Exception e){
            System.out.println("Harus Integer" + e);
        } finally {
            System.out.println("Nilai anda : " + nilai);
        }
        System.out.println("Selesai");
    }
}