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
}
