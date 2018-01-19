import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    public static List<AdminModel> adminsList;

    public AdminDao() {
        adminsList = new ArrayList<AdminModel>();
    }

    public List<AdminModel> getAdminsList() {
        return adminsList;
    }

    public void addAdmin() {
        AdminModel admin = new AdminModel("Karol", "Kwiatek", "admin@gmail.com", "admin", "Admin");
        adminsList.add(admin);
    }
    
}    