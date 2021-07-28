package kr.kim.gam.domain;

import lombok.Data;

@Data
public class FirstTierVO {
	// 호출 파라미터
	private String prodType;
	private String interestType;
	private String bankValue;
	private String interestMonth;
	private String orderByType;
	private String joinMethod;
	private String sortType;
}
