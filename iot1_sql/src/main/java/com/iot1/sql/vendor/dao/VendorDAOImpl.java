package com.iot1.sql.vendor.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.iot1.sql.vendor.dto.VendorInfo;

@Service
public class VendorDAOImpl extends SqlSessionDaoSupport implements VendorDAO {

	@Override
	public VendorInfo selectVendor(VendorInfo vi) {
		return this.getSqlSession().selectOne("SELECT_VENDOR", vi);
	}

	@Override
	public List<VendorInfo> selectVendorList(VendorInfo vi) {
		return this.getSqlSession().selectList("SELECT_VENDOR", vi);
	}

	@Override
	public List<VendorInfo> selectVendorComboList() {
		return this.getSqlSession().selectList("SELECT_VENDOR_COMBO");
	}

	@Override
	public int insertVendorList(VendorInfo vi) {
		return this.getSqlSession().insert("INSERT_VENDOR", vi);
	}

	@Override
	public int updateVendorList(VendorInfo vi) {
		return this.getSqlSession().update("UPDATE_VENDOR", vi);
	}

	@Override
	public int deleteVendorList(VendorInfo vi) {
		return this.getSqlSession().delete("DELETE_VENDOR", vi);
	}

}
