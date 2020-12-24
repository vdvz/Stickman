package DB;

import user.User;

import java.sql.SQLException;

public interface USER_DB_I {

    User GetUser(String android_id) throws SQLException;

    boolean SaveUser(User user);

}
