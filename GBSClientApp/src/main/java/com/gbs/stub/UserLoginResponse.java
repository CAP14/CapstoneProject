package com.gbs.stub;

import java.util.List;

import com.gbs.models.UserLogin;

public class UserLoginResponse {
	private List<UserLogin> userLogin;

	public List<UserLogin> getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(List<UserLogin> userLogin) {
		this.userLogin = userLogin;
	}

}
