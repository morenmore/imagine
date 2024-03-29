package com.iot1.sql.db.dto;

import org.springframework.stereotype.Component;

@Component
public class Column {
	private String dbName;
	private String columnName;
	private String dataType;
	private String characterMaximumLength;
	private String isNullable;
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getCharacterMaximumLength() {
		return characterMaximumLength;
	}
	public void setCharacterMaximumLength(String characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	@Override
	public String toString() {
		return "Column [columnName=" + columnName + ", dataType=" + dataType + ", characterMaximumLength="
				+ characterMaximumLength + ", isNullable=" + isNullable + "]";
	}
	
}
