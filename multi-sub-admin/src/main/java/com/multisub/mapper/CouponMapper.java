package com.multisub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multisub.vo.CouponVO;

@Repository
@Mapper
public interface CouponMapper {
	public void insert(CouponVO obj) throws Exception;
	public void delete(int obj) throws Exception;
	public void update(CouponVO obj) throws Exception;
	public CouponVO select(int obj) throws Exception;
	public List<CouponVO> selectall() throws Exception;
	
	/************************************/
	
	public CouponVO selectlatest() throws Exception;
}


