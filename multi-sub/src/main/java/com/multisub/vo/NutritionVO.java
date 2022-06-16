package com.multisub.vo;

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
public class NutritionVO {
	private int id;
	private double kcal;
	private double gram;
	private double protein;
	private double fat;
	private double sugar;
	private double salt;
	
	
}
