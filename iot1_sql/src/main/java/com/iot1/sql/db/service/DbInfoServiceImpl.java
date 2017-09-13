package com.iot1.sql.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.db.dao.DbInfoDao;
import com.iot1.sql.db.dto.Column;
import com.iot1.sql.db.dto.DataBase;
import com.iot1.sql.db.dto.DbInfo;
import com.iot1.sql.db.dto.Table;
import com.iot1.sql.goods.dto.GoodsInfo;

@Service
public class DbInfoServiceImpl implements DbInfoService {

	@Autowired
	DbInfoDao dDao;

	@Override
	public List<DbInfo> getDbInfoList(DbInfo di) {
		return dDao.selectDbInfoList(di);
	}

	@Override
	public boolean isConnecteDB(DbInfo pDi) throws Exception {
		DbInfo di = dDao.selectDbInfo(pDi);
		return dDao.isConnecteDB(di);
	}

	@Override
	public List<DataBase> getDataBaseList() throws Exception {
		return dDao.selectDatabaseList();
	}

	@Override
	public List<Table> getTableList(DataBase di) throws Exception {
		return dDao.selectTableList(di);
	}

	@Override
	public List<Column> getColumnList(Column c) {
		return dDao.selectColumnList(c);
	}

}