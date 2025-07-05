package com.st.user.dao;

import com.st.user.model.User;

public interface UserDao {
	User getUser(String username);
}
