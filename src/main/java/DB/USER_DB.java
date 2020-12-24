package DB;

import user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_DB implements USER_DB_I{

    @Override
    public User GetUser(String android_id) throws SQLException {
        MyConnection_I Connection = DB.getInstance().getConnection();
        String qr = "SELECT * FROM user WHERE android_id is '" + android_id + "';";
        ResultSet result = Connection.executeQuery(qr);
        User user = new User(result.getInt("id"), result.getString("name"));
        user.setMoney(result.getInt("money"));
        user.setTrophies(result.getInt("trophies"));
        user.setCount_win(result.getInt("count_win"));
        user.setCount_loss(result.getInt("count_loss"));
        return user;
    }

    @Override
    public boolean SaveUser(User user) {

    }
}
