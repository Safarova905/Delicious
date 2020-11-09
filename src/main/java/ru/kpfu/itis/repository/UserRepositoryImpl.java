package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private DataSource dataSource;
    private JdbcTemplate template;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    //язык - SQL
    private final String SQL_INSERT_USERS = "INSERT INTO user_table" + "( first_name, last_name," +
            "address, password, email, image) VALUES" + "( ?, ? , ? , ? , ?, ?);";

    private final String SQL_SELECT_ALL = "SELECT * FROM user_table";

    private final String SQL_SELECT_BY_ID = "SELECT * FROM user_table WHERE user_id = ?";

    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user_table WHERE email= ?";

    private final String SQL_UPDATE_IMAGE = "UPDATE user_table SET image=? WHERE user_id =?";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    private RowMapper<User> userRowMapper2 = row -> User.builder()
            .id((int) row.getLong("user_id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .address(row.getString("address"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();



    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public User findById(Integer id) {
        List<User> users = template.query(SQL_SELECT_BY_ID, userRowMapper2, id);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = template.query(SQL_SELECT_BY_EMAIL, userRowMapper2, email);
        return !users.isEmpty() ? users.get(0) : null;
    }


    public void update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_IMAGE);
            statement.executeUpdate("UPDATE user_table SET image=" + " WHERE user_id=" + user.getId());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public void save(User user) {
        template.queryInsert(SQL_INSERT_USERS,
                user.getFirst_name(),
                user.getLast_name(),
                user.getAddress(),
                user.getPassword(),
                user.getEmail());
    }

}
