package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetRecordListLogic;
import model.PostRecordLogic;
import model.Record;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  
    //記録リストを取得して、リクエストスコープに保存
    GetRecordListLogic getRecordListLogic =new GetRecordListLogic();
    List<Record> recordList = getRecordListLogic.execute();
    request.setAttribute("recordList", recordList);
    
    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    dispatcher.forward(request, response);
  }
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  
    // リクエストパラメータ取得
	request.setCharacterEncoding("UTF-8");
	String date = request.getParameter("date");
    String text = request.getParameter("text");
    String setTime = request.getParameter("time");
    if(setTime.equals("")) {
    	setTime = "0";
    }
    
    int time = Integer.parseInt(setTime);

    // 入力値チェック
    if (text != null && text.length() != 0) {
    // 記録リストに追加
    Record record = new Record(date,text,time);
    PostRecordLogic postrecordLogic = new PostRecordLogic();
    postrecordLogic.execute(record);
    } else {
      // エラーメッセージをリクエストスコープに保存
      request.setAttribute("errorMsg","記録が入力されていません");
    }

    // 記録リストを取得して、リクエストスコープに保存
   GetRecordListLogic getRecordListLogic = new GetRecordListLogic();
    List<Record> recordList = getRecordListLogic.execute();
    request.setAttribute("recordList", recordList);
    
    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    dispatcher.forward(request, response);
  }
}