package responsi;

public class Main {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(view,model);
    public static void main(String[] args) {
        new Main();
    }
}
