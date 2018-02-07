package dao;

import model.ArtifactModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransactionDao extends UserDao implements TransationDaoInterface {

    public void insertTransaction(int idStudent, int idItem) {
        String values =  "("+ idStudent +", " + idItem+ "," + 0 + ")";
        insertDataIntoTable("Transactions ", "(id_student, id_item, used)", values);
    }

    private String prepareGetArtifactsSql(int idStudent) {
        String columns = "Item.id_item, item_name, description, price, used";
        String joinStmt1 = "Item.id_item = Transactions.id_item";
        String joinStmt2 = "ItemType.id_type = ItemType.id_type";

        String sql = "SELECT " + columns + " FROM Transactions " +
                " JOIN Item ON " + joinStmt1 +
                " JOIN ItemType ON " + joinStmt2 +
                " WHERE id_student= '" + idStudent + "' AND ItemType.name='Artifact'";
        System.out.println(sql);
        return sql;
    }



    public List<ArtifactModel> getStudentArtifact(int idStudent) {
        List<ArtifactModel> artifactCollection = new ArrayList<>();
        String sql = prepareGetArtifactsSql(idStudent);
        ResultSet result = executeSelect(sql);
        return artifactCollection;
    }

//    public createArtifactObject() {
//
//    }
}