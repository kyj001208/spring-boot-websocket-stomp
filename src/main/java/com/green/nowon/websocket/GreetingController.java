package com.green.nowon.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	
	@MessageMapping("/hello") //클라이언트에서 넘어오는 주소값(매핑)
	@SendTo("/topic/greetings") //구독, 설정한 사람한테 전달
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // 시간 조정 (1초 지연)
		System.out.println("클라이언트에서 이름을 객체로 보냈어요>>>>>>>>"+message.getName());
		
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
