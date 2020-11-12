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

  public void addShare(String name, int changeProbability, int delta) throws SQLException {
    id++;
    shares.addShare(new Share(id, name, changeProbability, delta));
  }

  public ArrayList<Share> getShares() throws SQLException {
    ResultSet resultSet = shares.getShares();
    ArrayList<Share> shares = new ArrayList<Share>();
    try {
      do {
        shares.add(new Share(resultSet.getInt("ID"), resultSet.getString("NAME"),
            resultSet.getInt("CHANGEPROBABILITY"), resultSet.getInt("DELTA")));
      } while (resultSet.next());
    } catch (Exception e) {

    }
    return shares;
  }

}
