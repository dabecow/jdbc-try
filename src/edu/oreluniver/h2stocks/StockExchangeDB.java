package edu.oreluniver.h2stocks;

import edu.oreluniver.h2stocks.repository.ShareRates;
import edu.oreluniver.h2stocks.repository.Shares;
import edu.oreluniver.h2stocks.repository.TraiderShareActions;
import edu.oreluniver.h2stocks.repository.Traiders;
import edu.oreluniver.h2stocks.service.ShareService;
import java.sql.*;
import edu.oreluniver.h2stocks.repository.*;

public class StockExchangeDB {
    // Блок объявления констант
    public static final String DB_URL = "jdbc:h2:/Users/andrew/Documents/Programming/java/jdbc-try/db/database";

    public static final String DB_Driver = "org.h2.Driver";

    // Таблицы СУБД
    Traiders traiders;
    ShareRates shareRates;
    Shares shares;
    TraiderShareActions traiderShareActions;
    ShareService shareService;

    // Получить новое соединение с БД
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Инициализация
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        traiders = new Traiders();
        shares = new Shares();
        shareService = new ShareService(shares);
        shareRates = new ShareRates();
        traiderShareActions = new TraiderShareActions();
    }

    // Создание всех таблиц и ключей между ними
    public void createTablesAndForeignKeys() throws SQLException {
        shares.createTable();
        shareRates.createTable();
        traiders.createTable();
        traiderShareActions.createTable();
        // Создание внешних ключей (связt` между таблицами)
        shareRates.createForeignKeys();
        traiderShareActions.createForeignKeys();
        shareService.addShare("Microsoft", 4, 4);
    }

    public String getShares() throws SQLException {
        return shareService.getShares().toString();
    }
}
