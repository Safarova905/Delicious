package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    private static final String SQL_INSERT_IMAGE = "update user set image = ? where id = ?;";
    private DataSource dataSource;


    public void UserRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user";

    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email = ?;";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id= ";

    //language=SQL
    private final String SQL_INSERT = "INSERT user (userName, email, password, dop_inf) VALUES (?,?,?,?)";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .username(row.getString("userName"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();



    @Override
    public User findByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            statement.setString(1, email);

            List<User> result = new ArrayList<>();
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(userRowMapper.mapRow(resultSet));
            }

            return !result.isEmpty() ? result.get(0) : null;
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
    public void update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
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
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);

            List<User> result = new ArrayList<>();
            resultSet = statement.executeQuery();
            result.add(userRowMapper.mapRow(resultSet));

            return result;
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
    public User findById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID + id);

            List<User> result = new ArrayList<>();
            resultSet = statement.executeQuery();
            result.add(userRowMapper.mapRow(resultSet));

            return !result.isEmpty() ? result.get(0) : null;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    public void save(User user) {
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            statement.setString(1, user.getFirst_name());
            statement.setString(1, user.getLast_name());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getPassword());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
