package dao;

public class GroupDao{

    public void addNewGroup(String groupName){
        UserDao dao = new UserDao();
        String table = "Groups";
        String columns = "('name')";
        String values = "('"+groupName+"')";
        dao.insertDataIntoTable(table, columns, values);
    }
}