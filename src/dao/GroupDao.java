package dao;

public class GroupDao{

    public void addNewGroup(String groupName){
        QueststoreDao dao = new QueststoreDao();
        String table = "Group";
        String columns = "(name)";
        String values = "'"+groupName+"'";
        dao.insertDataIntoTable(table, columns, values);
    }
}