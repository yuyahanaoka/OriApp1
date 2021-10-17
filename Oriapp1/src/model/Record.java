package model;

import java.io.Serializable;

public class Record implements Serializable {
  private int number; // 記録 NUMBER
  private String date; //　記録日 
  private String text; // 記録内容
  private int time; // 実施時間
  

  public Record() {
  }
  public Record(String date, String text , int time) {
    this.date = date;
    this.text = text;
    this.time = time;
  }
  public Record(int number, String date, String text , int time) {
    this.number = number;
    this.date = date;
    this.text = text;  
    this.time = time;  
  }
  public int getNumber() {
    return number;
  }
  public String getDate() {
    return date;
  }
  public String getText() {
    return text;
  }
  public int getTime() {
	return time;
  } 
}
