package kr.kim.gam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import kr.kim.gam.domain.FirstTierVO;
import kr.kim.gam.util.Crawler;

@RestController
public class RestApiController {
	
//	@GetMapping(value="/get1TierInfo")
//	public FirstTierVO get1TierInfo() {
//		return Crawler.crawl1Tier("deposit", "Simple", 
//									"0010030|0013175|0011625|0010001|0010002|0013909|0010026|0010927|0010006|0014807|0010016|0010017|0010019|0010020|0010022|0010024|0014674|0015130", 
//									"BANK_NAME", "ASC", "", "");
//	}
}
