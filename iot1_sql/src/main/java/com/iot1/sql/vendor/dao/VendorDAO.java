package com.iot1.sql.vendor.dao;

import java.util.List;

import com.iot1.sql.vendor.dto.VendorInfo;

public interface VendorDAO {

	public VendorInfo selectVendor(VendorInfo vi);

	public List<VendorInfo> selectVendorList(VendorInfo vi);

	List<VendorInfo> selectVendorComboList();

	public int insertVendorList(VendorInfo vi);

	public int updateVendorList(VendorInfo vi);

	public int deleteVendorList(VendorInfo vi);

}
