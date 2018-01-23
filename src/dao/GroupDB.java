package dao;

public class GroupDB{

    public void addNewGroup(String groupName){
        QuestStoreDao dao = new QueststoreDao();
        String table = "Group";
        String columns = "(name)";
        String values = "'"+groupName+"'";
        dao.insertDataIntoTable(table, column, values);
    }
}