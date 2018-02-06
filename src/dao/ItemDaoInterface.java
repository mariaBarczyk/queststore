package dao;

import model.ItemModel;

import java.util.List;

public interface ItemDaoInterface {

    void insertNewItem(ItemModel item);
    int findIdType(String typeName);
    List<ItemModel> getItemCollectionByType(String typeName);
    void updateValueOfItem(ItemModel item);

}
