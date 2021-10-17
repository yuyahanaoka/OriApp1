<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Record,java.util.List" %>

<%
// アプリケーションスコープに保存された記録リストを取得
List <Record> recordList = (List<Record>) request.getAttribute("recordList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>OrigiApp1</title>
</head>
<body>
<h1>記録ログ</h1>

<form action="/Oriapp1/Main" method="post">
記録日: <input type="date" name = "date"><br>
記録内容: <textarea name = "text"></textarea> <br>
実施時間: <input type="number" name = "time"><br>
<input type="submit" value = "記録更新">

</form>

<%if(recordList != null && recordList.size() > 0) { %>
	
	<table border="1">
		<tr>
			<th>記録日</th>
			<th>実施内容</th>
			<th>実施時間(分)</th>
		</tr>
		<% for(Record record : recordList){%>
			<tr>
				<td> <%= record.getDate() %> </td>
				<td> <%= record.getText()%> </td>
				<td> <%= record.getTime()%> </td>
			</tr>　
		<% } %>
	</table>

<%} else if(recordList != null && recordList.size() == 0) { %>
	<p>記録がありません</p>
<% } else {%>
	<p>予期せぬエラーがおきました</p>
<% } %>

</body>
</html>