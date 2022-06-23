package com.multisub.product;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multisub.biz.ProductBiz;
import com.multisub.vo.ProductVO;

@SpringBootTest
class SelectAllTest {

	@Autowired
	ProductBiz biz;
	
	@Test
	void contextLoads() {
		List<ProductVO> list = null;		
		try {
			list = biz.get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ProductVO obj : list) {
			System.out.println(obj);
		}
	}

}
