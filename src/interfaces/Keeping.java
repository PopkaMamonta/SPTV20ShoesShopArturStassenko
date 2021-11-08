package interfaces;
import entity.Model;
import entity.History;
import entity.Shop;
import entity.User;
import java.util.List;

public interface Keeping {
    public void saveModels(List<Model> models);
    public List<Model> loadModels();
    public void saveUsers(List<User> users);
    public List<User> loadUsers();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
    public void saveShops(List<Shop> shops);
    public List<Shop> loadShops();
}