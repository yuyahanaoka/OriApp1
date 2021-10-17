package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Record;

public class RecordDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:h2:~/origapp1";
  private final String DB_USER = "sa";
  private final String DB_PASS = "";

  
  public List<Record> findAll() {
    List<Record> recordList = new ArrayList<Record>();

    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql =
          "SELECT NUMBER,DATE,TEXT,TIME FROM RECORD ORDER BY NUMBER DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int number = rs.getInt("NUMBER");// 記録 NUMBER
        String date = rs.getString("DATE");//　記録日 
        String text = rs.getString("TEXT");// 記録内容
        String Settime = rs.getString("TIME");// 実施時間 
        int time = Integer.parseInt(Settime);
        
        Record record = new Record(number, date, text, time);
        recordList.add(record);
  
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return recordList;
  }
  public boolean create(Record record) {
    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO RECORD(DATE, TEXT ,TIME) VALUES(?, ?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      
      pStmt.setString(1, record.getDate());
      pStmt.setString(2, record.getText());
      pStmt.setInt(3, record.getTime());
      
      // INSERT文を実行
      int result = pStmt.executeUpdate();
      //INSERT文実行　resultに追加された行数が代入
      if (result != 1) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}