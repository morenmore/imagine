package com.iot1.sql.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot1.sql.user.dao.UserDao;
import com.iot1.sql.user.dto.UserInfo;

@Service
public  class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserInfo getUser(UserInfo pUser) {
		UserInfo user = (UserInfo) userDao.selectUser(pUser);
		if (user != null && user.getUserPwd().equals(pUser.getUserPwd())) {
			return user;
		}
		return null;
	}

	@Override
	public List<UserInfo> selectUserList(UserInfo user) {
		return userDao.selectUserList(user);
	}

	@Override
	public int insertUser(UserInfo user) {
		return 0;
	}

	@Override
	public int insertUserList(UserInfo[] userList) {
		int rCnt = 0;
		for(UserInfo user : userList){
			rCnt += userDao.insertUser(user);
		}
		return rCnt;
	}


}
