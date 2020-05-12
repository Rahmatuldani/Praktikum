package Test4;

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

    public Object[][] Find(String data){
        this.data = model.Find(data);
        return this.data;
    }

    public void Update(Object[][] data, String nama){
        model.Update(data,nama);
        new View();
    }

    public void Delete(String nama){
        model.Delete(nama);
        new View();
    }

    public void DeleteAll(){
        model.DeleteAll();
        new View();
    }
}
