package kr.kim.gam.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;

public class Crawler {
	
	/**
	 * 1금융권 예적금 정보 크롤링
	 * @param interestType
	 * @param bankValue
	 * @param interestMonth
	 * @param orderByType
	 * @param joinMethod
	 * @param sortType
	 * @return
	 */
	public static JsonObject crawl1Tier(String prodType, String interestType, String bankValue, String interestMonth, String orderByType, String joinMethod, String sortType) {
		JsonObject result = new JsonObject();
		String url = "";
		url = prodType.equals("deposit") ? "https://portal.kfb.or.kr/compare/receiving_deposit_3_search_result.php" : "";
		
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

		StringBuilder paramBuilder = new StringBuilder();
		try {
			paramBuilder.append("InterestType=");
			paramBuilder.append(URLEncoder.encode(interestType, "UTF-8"));
			paramBuilder.append("&BankValue=");
			paramBuilder.append(URLEncoder.encode(bankValue, "UTF-8"));
			paramBuilder.append("&InterestMonth=");
			paramBuilder.append(URLEncoder.encode(interestMonth, "UTF-8"));
			paramBuilder.append("&OrderByType=");
			paramBuilder.append(URLEncoder.encode(orderByType, "UTF-8"));
			paramBuilder.append("&JOIN_METHOD=");
			paramBuilder.append(URLEncoder.encode(joinMethod, "UTF-8"));
			paramBuilder.append("&SortType=");
			paramBuilder.append(URLEncoder.encode(sortType, "UTF-8"));

			url = url + "?" + paramBuilder.toString();
			
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다. 
		Elements element = doc.select("table.resultList_ty02");    

		System.out.println("============================================================");

		//Iterator을 사용하여 하나씩 값 가져오기
		Iterator<Element> ie1 = element.select("tbody>tr").iterator();
		//Iterator<Element> ie2 = element.select("strong.title").iterator();
		        
		int idx = 0;
		while (ie1.hasNext()) {
			//System.out.println(ie1.next().text()+"\t"+ie2.next().text());
			System.out.println(idx + "===================================");
			System.out.println(ie1.next().html());
			idx++;
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		crawl1Tier("deposit", "Simple", "0010030|0013175|0011625|0010001|0010002|0013909|0010026|0010927|0010006|0014807|0010016|0010017|0010019|0010020|0010022|0010024|0014674|0015130", 
				"BANK_NAME", "ASC", "", "");
		
		// Jsoup 크롤링
		// 1금융권 예적금 보여주는 사이트
		/*String url = "https://portal.kfb.or.kr/compare/receiving_deposit_3_search_result.php"; // 적금
		StringBuilder paramBuilder = new StringBuilder();
		
		String interestType = "Simple"; // 단리 / 복리
		String bankValue = "0010030|0013175|0011625|0010001|0010002|0013909|0010026|0010927|0010006|0014807|0010016|0010017|0010019|0010020|0010022|0010024|0014674|0015130"; // 은행
		String interestMonth = "BANK_NAME"; // BANK_NAME / 6 / 12 / 24 / 36
		String orderByType = "ASC"; // 내림차순/오름차순
		String joinMethod  = ""; // 가입방법
		String sortType  = ""; // 정렬기준 - 기본은 은행명. PRODUCT_NAME ASC=상품명 오름차순
		
		Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
		
		try {
			paramBuilder.append("InterestType=");
			paramBuilder.append(URLEncoder.encode(interestType, "UTF-8"));
			paramBuilder.append("&BankValue=");
			paramBuilder.append(URLEncoder.encode(bankValue, "UTF-8"));
			paramBuilder.append("&InterestMonth=");
			paramBuilder.append(URLEncoder.encode(interestMonth, "UTF-8"));
			paramBuilder.append("&OrderByType=");
			paramBuilder.append(URLEncoder.encode(orderByType, "UTF-8"));
			paramBuilder.append("&JOIN_METHOD=");
			paramBuilder.append(URLEncoder.encode(joinMethod, "UTF-8"));
			paramBuilder.append("&SortType=");
			paramBuilder.append(URLEncoder.encode(sortType, "UTF-8"));
		
			url = url + "?" + paramBuilder.toString();			
			System.out.println("url: " + url);
			
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Elements element = doc.select("table.resultList_ty02");    
		
		System.out.println("============================================================");
		
		//Iterator을 사용하여 하나씩 값 가져오기
		Iterator<Element> ie1 = element.select("tbody>tr").iterator();
		//Iterator<Element> ie2 = element.select("strong.title").iterator();
		        
		while (ie1.hasNext()) {
			//System.out.println(ie1.next().text()+"\t"+ie2.next().text());
			System.out.println(ie1.next().html());
		}
		
		System.out.println("============================================================");*/
	}
}
