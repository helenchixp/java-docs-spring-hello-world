package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {

	private final String connectionUrl =
	"jdbc:sqlserver://sql-skillup-chi.database.windows.net:1433;"
	+ "database=upskilling-chi;"
	+ "user=admin-chi@sql-skillup-chi;"
	+ "password=Asdf1234;"
	+ "encrypt=true;"
	+ "hostNameInCertificate=*.database.windows.net;"
	+ "trustServerCertificate=false;"
	+ "loginTimeout=30;";


	private final String query = "SELECT ID,TITLE,GOOD_COUNT,BAD_COUNT FROM T_COMMENT";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String showListPage() {

		ResultSet resultSet = null;

		StringBuilder sb = new StringBuilder();

		try (Connection connection = DriverManager.getConnection(connectionUrl);
			Statement statement = connection.createStatement();) {

			// Create and execute a SELECT SQL statement.
			//String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
			resultSet = statement.executeQuery(query);
			// Print results from select statement
			while (resultSet.next()) {
				//System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
				sb.append(resultSet.getString(2));
				sb.append("\n");
			}
		}
		catch (SQLException e) {
			sb.append(e.toString());
		}


		return sb.toString();

	}
	@RequestMapping("/votingList")
	
	String showListPage2() {
		return"	<html>	\r\n" +
			"<head>	\r\n" +
			"<title>SampleWebApp</title>	\r\n" +
			"</head>	\r\n" +
			"<body>	\r\n" +
			"  <h2>ようこそ！！！投稿一覧</h2>	\r\n" +
			"  <br>	\r\n" +
			"  <div class=\"array\" id=\"array\"></div>\r\n" +
			"  <script  type=\"text/javascript\">\r\n" + 
			"	let requestURL = 'https://func-upskill-chi-node.azurewebsites.net/api/VotingList?code=mE9h8puZtTT2VqfsedWKIKQsH1XFMDt-1HYb557BdasmAzFu8fCxHA==';\r\n" +
			"	let request = new XMLHttpRequest();	\r\n" +
			"	request.open('GET', requestURL);	\r\n" +
			"	request.responseType = 'json';	\r\n" +
			"	request.withCredentials = true; ;	\r\n" +
			"		\r\n" +
			"	// JSONデータをJavaScriptオブジェクトに変換	\r\n" +
			"	request.onload = function () {	\r\n" +
			"	  if (request.status === 200) {\r\n" +
			"	    let data = request.response;	\r\n" +
			"	    data = JSON.parse(JSON.stringify(data));	\r\n" +
			"	    dataArray(data);	\r\n" +
			"	  } else	{\r\n" +
			"	    console.error('Request failed. Status code: ' + request.status); \r\n" +
			"	  }\r\n" +
			"	}\r\n" +
			"	request.send(); \r\n" +
			"	// foreachでJSONデータをHTMLに出力	\r\n" +
			"	function dataArray(els) {\r\n" +
			"	  // JSONデータを出力したいHTML要素を指定	\r\n" +
			"	  let array = document.getElementById('array');	\r\n" +
			"	  els.forEach(el => {	\r\n" +
			"	    let title = el.title;	\r\n" +
			"	    let id = el.id;	\r\n" +
			"	    let goodCount = el.goodCount;	\r\n" +
			"	    let badCount = el.badCount;	\r\n" +
			"	    let code = '<ul>'+	\r\n" +
			"	    '<li>' + title + \r\n" +
			//"	    '<input type=\"button\" value=\"いいね：' + goodCount + '\" onclick=\"alert()\">' + \r\n" +
			//"	    '<input type=\"button\" value=\"だめね：' + badCount + '\" onclick=\"alert()\"></li>' + \r\n" +
			"	    ' <a href=\"#\" onclick=\"vote(1, '+ id +')\">いいね：' + goodCount + '</a>' + \r\n" +
			"	    ' <a href=\"#\" onclick=\"vote(1, '+ id +', 2)\">だめね：' + badCount + '</a></li>' + \r\n" +
			"	    '</li></ul>';	\r\n" +
			"	    array.insertAdjacentHTML('beforebegin', code);	\r\n" +
			"	  });\r\n" +
			"	}\r\n" +
			"	function vote(kubun, id, catalog) {\r\n" +
			"	   if (catalog == 2) catalog = 'BAD';\r\n" +
			"	   var url='https://func-upskill-chi-node.azurewebsites.net/api/Voting?id=' + id + '&catalog=' + catalog + '&code=PhTjlcPal5ANrJiefgMDNXHVbyXCjs4ssYUYF9PqaH04AzFuQPWDsA==';\r\n" +
			"	   request.open('GET', url);\r\n" +
			"	   request.send();\r\n" +
			"          location.reload()\r\n" +
			"		\r\n" +
			"	}\r\n" +
			"   </script>	\r\n" +
			"</body>	\r\n" +
			"</html>	\r\n" ;
 			
	}

	@RequestMapping("/post")
	String sayHello() {
		return " <form action='https://func-upskill-chi-node.azurewebsites.net/api/Post' method='GET'> " +
			"  <div>" +
			"    <input name='code' id='code' type='hidden' value='SQyEZAF53ir_CF5oqxeKrPJtcm9mY-bO3FplFUaTSUDBAzFu72FXoQ=='>" +
			"    <label for='title'>投稿</label>" +
			"    <input name='title' id='title' value='つぶやき' />" +
			"  </div>" +
			"  <div>" +
			"    <button>Send </button>" +
			"  </div>" +
			"</form>";
			
		//return "<a href='https://func-upskill-chi-node.azurewebsites.net/api/Voting?id=1&catalog=GOOD&code=PhTjlcPal5ANrJiefgMDNXHVbyXCjs4ssYUYF9PqaH04AzFuQPWDsA=='>いいね！</a><br/>" + 
		//	"<a href='https://func-upskill-chi-node.azurewebsites.net/api/Voting?id=1&catalog=BAD&code=PhTjlcPal5ANrJiefgMDNXHVbyXCjs4ssYUYF9PqaH04AzFuQPWDsA=='>ダメだ！</a>";
	}
	@RequestMapping("/helloAzure")
	String sayHelloAzure() {
		return "<script>alert('Hello World!!!Azure!');</script>";
	}
}
