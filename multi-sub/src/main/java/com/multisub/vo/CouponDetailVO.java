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
	private Date useDate;
	private String userId;
	private int couponId;
	
	
	private String couponName;
	private boolean expirYN;
	public CouponDetailVO(int id, String state, String userId, int couponId) {
		this.id = id;
		this.state = state;
		this.userId = userId;
		this.couponId = couponId;
	}
	
	
}