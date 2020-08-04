package com.example.demo.customer.core.application.object.query;

import io.swagger.annotations.ApiModelProperty;

public class StoreResponseDTO {
	

	String sid; 			//가게 아이디
	String storename; 	//가게 이름
	String ownername;
	String ownerid; 	//가게 주인의 cid
	String address;		//가게 주소
	String openinfo;
	String phonenumber;
	String storecode;		//1.한식 2.중식 3.일식 4.기타
	int earinigs; 	//월 수익

}