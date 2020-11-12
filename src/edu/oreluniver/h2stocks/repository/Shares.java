package edu.oreluniver.h2stocks.repository;

import edu.oreluniver.h2stocks.model.Share;
import java.sql.*;

public class Shares extends BaseTable implements TableOperations{

    public Shares() throws SQLException {
        super("shares");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS shares(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "changeProbability INTEGER NOT NULL,"+
                "delta INTEGER NOT NULL)", "Создана таблица " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
    }

    public void addShare(Share share) throws SQLException {
        super.executeSqlStatement("INSERT INTO shares (name, changeProbability, delta) VALUES ('" + share.getName() + "', " + share.getChangeProbability() +  ", " + share.getDelta() + ")", "Add " + share.toString());
    }

    public ResultSet getShares() throws SQLException {
        return super.executeSqlWithResult("SELECT * FROM shares");
    }
}
