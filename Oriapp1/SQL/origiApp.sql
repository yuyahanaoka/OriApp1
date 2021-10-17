DROP TABLE IF EXISTS MUTTER;

jdbc:h2:~/origapp1

記録テーブル
CREATE TABLE  RECORD(
NUMBER INT PRIMARY KEY AUTO_INCREMENT,
DATE  VARCHAR(300) NOT NULL,
TEXT VARCHAR(300)  NOT NULL,
TIME INT NOT NULL
);

テンプレートテーブル
CREATE TABLE  TEMPLATE(
NUMBER INT PRIMARY KEY AUTO_INCREMENT,
TEMPLATENAME  VARCHAR(300) NOT NULL,
TEXT VARCHAR(300)  NOT NULL,
COMENT VARCHAR(300)  NOT NULL
);


SELECT * FROM MUTTER;

<%
// アプリケーションスコープに保存された記録リストを取得
List<Record>recordList=(List<Record>)request.getAttribute("recordList");
%>

<% for(Record record : recordList){%>
<p> <%= record.getDate() %> ： <%= record.getText()%>  </p>
<% } %>
