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
			"	let requestURL = 'https://func-upskill-chi-node.azurewebsites.net/api/VotingList?code=mE9h8puZtTT2VqfsedWKIKQsH1XFMDt-1HYb557BdasmAzFu8fCxHA==';//jsonへのパス	" +
			"	let request = new XMLHttpRequest();	" +
			"	request.open('GET', requestURL);	" +
			"	request.responseType = 'json';	" +
			"	request.send();	" +
			"		" +
			"	// JSONデータをJavaScriptオブジェクトに変換	" +
			"	request.onload = function () {	" +
			"	  let data = request.response;	" +
			"	  data = JSON.parse(JSON.stringify(data));	" +
			"	  dataArray(data);	" +
			"	}	" +
			"		" +
			"	// foreachでJSONデータをHTMLに出力	" +
			"	function dataArray(els) {	" +
			"	  // JSONデータを出力したいHTML要素を指定	" +
			"	  let array = document.querySelector('.array');	" +
			"	  els.forEach(el => {	" +
			"	    let title = el.title;	" +
			"	    let goodCount = el.goodCount;	" +
			"	    let badCount = el.badCount;	" +
			"	    let code = '<ul>'+	" +
			"	    '<li>投稿' + title + '</li>'+	" +
			"	    '<li>学年：' + goodCount + '年</li>'+	" +
			"	    '<li>国語：' + badCount + '点</li>'+	" +
			"	    '</ul>';	" +
			"	    array.insertAdjacentHTML('beforeend',code);	" +
			"	  });	" +
			"	}	" ;

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
