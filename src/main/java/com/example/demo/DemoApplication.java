package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String showListPage() {
		return "<script>" + 
			"	let requestURL = 'https://func-upskill-chi-node.azurewebsites.net/api/VotingList?code=mE9h8puZtTT2VqfsedWKIKQsH1XFMDt-1HYb557BdasmAzFu8fCxHA==';//jsonへのパス	\r\n" +
			"	let request = new XMLHttpRequest();	\r\n" +
			"	request.open('GET', requestURL);	\r\n" +
			"	request.responseType = 'json';	\r\n" +
			"	request.send();	\r\n" +
			"		\r\n" +
			"	// JSONデータをJavaScriptオブジェクトに変換	\r\n" +
			"	request.onload = function () {	\r\n" +
			"	  let data = request.response;	\r\n" +
			"	  data = JSON.parse(JSON.stringify(data));	\r\n" +
			"	  dataArray(data);	\r\n" +
			"	}	\r\n" +
			"		\r\n" +
			"	// foreachでJSONデータをHTMLに出力	\r\n" +
			"	function dataArray(els) {	\r\n" +
			"	  // JSONデータを出力したいHTML要素を指定	\r\n" +
			"	  let array = document.querySelector('.array');	\r\n" +
			"	  els.forEach(el => {	\r\n" +
			"	    let title = el.title;	\r\n" +
			"	    let goodCount = el.goodCount;	\r\n" +
			"	    let badCount = el.badCount;	\r\n" +
			"	    let code = '<ul>'+	\r\n" +
			"	    '<li>投稿' + title + '</li>'+	\r\n" +
			"	    '<li>学年：' + goodCount + '年</li>'+	\r\n" +
			"	    '<li>国語：' + badCount + '点</li>'+	\r\n" +
			"	    '</ul>';	\r\n" +
			"	    array.insertAdjacentHTML('beforeend',code);	\r\n" +
			"	  });	\r\n" +
			"	}	\r\n" ;

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
