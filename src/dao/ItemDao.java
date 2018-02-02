package dao;

import model.ArtifactModel;
import model.ItemModel;
import model.QuestModel;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;


public class ItemDao extends QueststoreDao {

    public void insertNewItem(ItemModel item) {
        String table = "Item";
        String columns = " ('item_name', 'description', 'price', 'id_type')";
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
        } /*finally {
            dao.closeConnection();
        }*/
        return idType;
    }

    private ItemModel createItemObject(int idItem, String typeName, String itemName, String description, int price) {

        if (typeName.equals("Quest")) {
            return new QuestModel(idItem, typeName, itemName, description, price);
        } else {
            return new ArtifactModel(idItem, typeName, itemName, description, price);
        }
    }

    public List<ItemModel> getItemCollectionByType(String typeName) {
        List<ItemModel> itemCollection = new ArrayList<>();
        int idType = findIdType(typeName);
        String columns = "id_item, item_name, description, price";
        String condition  = "id_type='" + idType +"'";
        ResultSet result = selectDataFromTable("Item", columns, condition);
        try {
            while (result.next()) {
                int idItem = result.getInt("id_item");
                String name = result.getString("item_name");
                String description = result.getString("description");
                int price = result.getInt("price");
                ItemModel item = createItemObject(idItem, typeName, name, description, price);
                itemCollection.add(item);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemCollection;
    }

    public void updateValueOfItem(ItemModel item) {
        QueststoreDao dao = new QueststoreDao();
        int value = item.getValue();
        String name = item.getName();
        dao.updateDataInTable("Item", "value='"+value +"'", "name ='" + name+"'");


    }

    /*public List<ItemModel> getAllItemsCollection() {
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
        return itemCollection;}*/


    /*public List<ItemModel> getItemsCollectionByType(String type) {
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
                if (typeName.equals(type)) itemCollection.add(item);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return itemCollection;}*/
}


