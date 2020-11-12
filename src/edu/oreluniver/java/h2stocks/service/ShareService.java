package edu.oreluniver.java.h2stocks.service;

import edu.oreluniver.java.h2stocks.model.Share;
import edu.oreluniver.java.h2stocks.repository.Shares;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShareService {

  private int id;
  private final Shares shares;

  public ShareService(Shares shares){
    this.shares = shares;
    this.id = 0;
  }

  public void addShare(String name, int startPrice, int changeProbability, int delta) throws SQLException {
    id++;
    shares.addShare(new Share(id, name, changeProbability, startPrice, delta));
  }

  public ArrayList<Share> getShares() throws SQLException {
    ResultSet resultSet = shares.getShares();
    while (resultSet.next()){
      Share share = new Share(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getInt("CHANGEPROBABILITY"), resultSet.getInt("DELTA"))
    }
  }
}
