public class GroupDB{

    public void addNewGroup(String groupName){
        SqlDB dataBase = new SqlDB();
        String table = "Group";
        String columns = "(name)";
        String values = "'"+groupName+"'";
        dataBase.insertDataIntoTable(table, column, values);
    }
}