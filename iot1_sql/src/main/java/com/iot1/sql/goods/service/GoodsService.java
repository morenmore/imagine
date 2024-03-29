package com.iot1.sql.goods.service;

import java.util.List;

import com.iot1.sql.goods.dto.GoodsInfo;

public interface GoodsService {

	public GoodsInfo getGoodsInfo(GoodsInfo gi);

	public List<GoodsInfo> getGoodsInfoList(GoodsInfo gi);

	public int insertGoodsList(GoodsInfo[] goodsList);

	public int updateGoodsList(GoodsInfo[] goodsList);

	public int deleteGoodsList(GoodsInfo[] goodsList);

}
