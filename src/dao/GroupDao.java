package dao;

import model.GroupModel;
import model.StudentModel;
import model.WalletModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDao extends UserDao{

    public void addNewGroup(String groupName){
        UserDao dao = new UserDao();
        String table = "Groups";
        String columns = "('name')";
        String values = "('"+groupName+"')";
        dao.insertDataIntoTable(table, columns, values);
    }

    public ResultSet createGroupsResult() {
        String sql = "SELECT * FROM Groups";
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<GroupModel> getGroupsCollection() {
        ResultSet result =  createGroupsResult();
        List<GroupModel> groupCollection = new ArrayList<>();
        try {
            while (result.next()) {
                int id = result.getInt("id_group");
                String name = result.getString("name");
                GroupModel group = new GroupModel(id, name);
                groupCollection.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupCollection;
    }
}
