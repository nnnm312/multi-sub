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
public class UsersVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String addr;
	private String phone;
	private int point;
	private String membership;
	private Date regdate;
	private int typeId;
}
