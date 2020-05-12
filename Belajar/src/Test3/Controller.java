package Test3;

public class Controller {
    private Object[][] data = new Object[50][8];

    Model model = new Model();

    public Object[][] Data() {
        data = model.getData();
        return data;
    }

    public void Create(Object[][] data){
        model.Create(data);
        new View();
    }

    public Object[][] Find(int data){
        this.data = model.Find(data);
        return this.data;
    }

    public void Update(Object[][] data, int nim){
        model.Update(data,nim);
        new View();
    }

    public void Delete(int nim){
        model.Delete(nim);
        new View();
    }

    public void DeleteAll(){
        model.DeleteAll();
        new View();
    }
}
