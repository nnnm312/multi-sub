package com.multisub.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CouponDetailVO {
	private int id;
	private String state;
	private String useDate;
	private String userId;
	private int couponId;
	
	private String cname;
	private double cdiscount;
	private String cregdate;
	private String cexpirDate;
	private boolean cexpirYN;
	
	
	public CouponDetailVO(int id, String state, String useDate, String userId, int couponId) {
		
		this.id = id;
		this.state = state;
		this.useDate = useDate;
		this.userId = userId;
		this.couponId = couponId;
	}
	
	
	
}
