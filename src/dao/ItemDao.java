package dao;

import model.ItemModel;
import model.QuestModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    public void insertNewItem(ItemModel item) {
        String table = "Item";
        String columns = "('name', 'description', 'value', 'id_type')";
        String values = "('"+ item.getName() + "','"+ item.getDescription()+"',"+item.getValue()+", "+findIdType(item.getType())+")";
        QueststoreDao dao = new QueststoreDao();
        dao.insertDataIntoTable(table, columns, values);
    }

    public int findIdType(String typeName) {
        QueststoreDao dao = new QueststoreDao();
        ResultSet result = dao.selectDataFromTable("ItemType", "id_type", "type_name='"+typeName+"'");
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

    public void updateValueOfItem(ItemModel item) {
        QueststoreDao dao = new QueststoreDao();
        int value = item.getValue();
        String name = item.getName();
        dao.updateDataInTable("Item", "value='"+value +"'", "name ='" + name+"'");


    }

    public List<ItemModel> getAllItemsCollection() {
        List<ItemModel> itemCollection = new ArrayList<>();
        QueststoreDao dao = new QueststoreDao();
        String columns = "ItemType.type_name, Item.name, Item.description, Item.value";
        String joinStatement = "ItemType.id_type = Item.id_type";
        ResultSet result = dao.selectFromJoinedTables(columns, "ItemType", "Item", joinStatement);
        try{
            while (result.next()) {
                String typeName = result.getString("type_name");
                String name = result.getString("name");
                String description = result.getString("description");
                int value = result.getInt("value");
                ItemModel item = new ItemModel(typeName, name, description, value );
                itemCollection.add(item);
                }
            }
            catch (SQLException e) {
            e.printStackTrace();
        }
        return itemCollection;}

    public List<ItemModel> getCollectionByType(String type) {
        List<ItemModel> itemCollection = new ArrayList<>();
        List<ItemModel> collectionByType = new ArrayList<>();
        for (ItemModel item: itemCollection)
            if (item.getType().equals(type))
                collectionByType.add(item);
        return collectionByType;
    }
}


