package model;

import java.util.List;

import dao.RecordDAO;

public class GetRecordListLogic {

  public List<Record> execute() {
	  RecordDAO dao = new RecordDAO();
    List<Record> recordList = dao.findAll();
    return recordList;
  }
}
