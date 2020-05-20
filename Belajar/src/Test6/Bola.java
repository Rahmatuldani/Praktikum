package Test6;

public class Bola implements Runnable{
    protected double jari,luas,volume;
    protected String namaPlanet;

    Bola(double jari,String namaPlanet){
        this.jari = jari;
        this.namaPlanet = namaPlanet;
        getLuas();
        getVolume();
    }

    @Override
    public void run() {
        try {
            System.out.println("Luas " + namaPlanet + " : " + luas);
            System.out.println("Volume " + namaPlanet + " : " + volume);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Thread "+ namaPlanet +" Interrupted");
        }
    }

    public void getLuas() {
        luas = 4 * Math.PI * Math.pow(jari,2);
    }

    public void getVolume() {
        volume = (4 * Math.PI * Math.pow(jari,3)) / 3;
    }
}
