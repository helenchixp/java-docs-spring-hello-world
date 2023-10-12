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
