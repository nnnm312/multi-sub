package com.multisub.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multisub.frame.Biz;
import com.multisub.mapper.UsersMapper;
import com.multisub.vo.UsersVO;

@Service
public class UsersBiz implements Biz<String, UsersVO>{
	
	@Autowired
	UsersMapper dao;
	
	@Override
	public void register(UsersVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(UsersVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public UsersVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<UsersVO> get() throws Exception {
		return dao.selectall();
	}
	
	
	
	
	public List<UsersVO> getCustomer() throws Exception {
		return dao.selectcustomer();
	}
	
	
	public List<UsersVO> getEmployee() throws Exception {
		return dao.selectemployee();
	}
}
