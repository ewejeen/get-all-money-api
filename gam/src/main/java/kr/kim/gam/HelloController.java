package kr.kim.gam;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "현재 서버시간: " + new Date() ;
	}
}
