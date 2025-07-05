package com.st.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;








import com.st.common.Columns;
import com.st.user.model.User;

public class UserMapper  implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setUsername(rs.getString(Columns.COL_01));
		user.setPassword(rs.getString(Columns.COL_02));
		user.setEnabled(rs.getBoolean(Columns.COL_03));
		user.setRole(rs.getString(Columns.COL_04));
		return user;
	}

}
