package com.edu.ulab.app.RowMapper;

import com.edu.ulab.app.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getLong("id"));
        userDto.setFullName(rs.getString("full_name"));
        userDto.setTitle(rs.getString("title"));
        userDto.setAge(rs.getInt("age"));
        return userDto;
    }
}
