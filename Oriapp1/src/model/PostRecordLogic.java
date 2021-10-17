package model;

import dao.RecordDAO;

public class PostRecordLogic {
  public void execute(Record record) { // 引数を1つに変更
	  RecordDAO dao = new RecordDAO();
    dao.create(record);
  }
}
