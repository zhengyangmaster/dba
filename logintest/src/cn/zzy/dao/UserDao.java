package cn.zzy.dao;

import cn.zzy.domain.User;
import cn.zzy.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate  template =new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser){
        try {
            String sql="select * from user where username = ? and password = ?";
            User user= template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword() );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
