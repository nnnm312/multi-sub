package com.multisub.toppingDetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multisub.biz.ToppingDetailBiz;
import com.multisub.vo.ToppingDetailVO;

@SpringBootTest
class UpdateTest {

	@Autowired
	ToppingDetailBiz biz;
	
	@Test
	void contextLoads() {
		ToppingDetailVO obj = new ToppingDetailVO(3,500,2000,1,1);
		
		try {
			biz.modify(obj);
			
			System.out.println(biz.get(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
