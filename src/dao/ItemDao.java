package dao;

import model.ItemModel;
import model.QuestModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {

    public void insertNewItem(ItemModel item) {
        String table = "Item";
        String columns = "'name', 'description', 'value', 'id_type'";
        String values = "'"+ item.getName() + "','"+ item.getDescription()+"',"+item.getValue()+", "+findIdType(item.getType());
        QueststoreDao dao = new QueststoreDao();
        dao.insertDataIntoTable(table, columns, values);
    }

    public int findIdType(String typeName) {
        QueststoreDao dao = new QueststoreDao();
        ResultSet result = dao.selectDataFromTable("ItemType", "id_type", "name='"+typeName+"'");
        int idType = 0;
        try {
            idType = result.getInt("id_type");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }
        return idType;

    }
}
