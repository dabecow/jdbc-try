package edu.oreluniver.demo;

import edu.oreluniver.h2stocks.StockExchangeDB;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {
    try{
      StockExchangeDB stockExchangeDB = new StockExchangeDB();
      stockExchangeDB.createTablesAndForeignKeys();
      System.out.println(stockExchangeDB.getShares());
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Ошибка SQL !");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC драйвер для СУБД не найден!");
    }
  }
}
