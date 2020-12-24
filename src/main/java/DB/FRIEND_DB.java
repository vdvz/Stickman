package DB;

import friend.Friend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FRIEND_DB implements FRIEND_DB_I{
    @Override
    public synchronized List<Friend> FindAllFriend(String find_query) throws SQLException {
        List<Friend> list = new ArrayList<>();
        MyConnection_I Connection = DB.getInstance().getConnection();
        String query = "SELECT id, name, trophies FROM users WHERE name like '" + find_query+"' or id==" + find_query +";";
        ResultSet result = Connection.executeQuery(query);
        while(result.next()){
            list.add(new Friend(result.getInt("id"), result.getString("name"), result.getInt("trophies")));
        }
        DB.getInstance().releaseConnection(Connection);
        return list;
    }

    @Override
    public synchronized void MakeRequestForFriend(String from, String to) {
        MyConnection_I Connection = DB.getInstance().getConnection();
        //String query =


        DB.getInstance().releaseConnection(Connection);
    }

    @Override
    public boolean ConfirmRequestForFriend(String from, String to) {
        return false;
    }

    @Override
    public synchronized void RemoveFriend(String from, String to) throws SQLException {
        MyConnection_I Connection = DB.getInstance().getConnection();
        String query = "DELETE FROM friends WHERE (user_id==" + from + " and friend_id==" + to
                + ") or (user_id==" + to + " and friend_id==" + from + ");";

        Connection.execute(query);
        DB.getInstance().releaseConnection(Connection);
    }

    @Override
    public List<Friend> GetFriendsByUser(String user_id) throws SQLException {
        List<Friend> list = new ArrayList<>();
        MyConnection_I Connection = DB.getInstance().getConnection();
        String query = "SELECT u.id AS id, u.name AS name, u.trophies AS trophies FROM friends AS f INNER JOIN users AS u " +
                "ON f.friend_id=u.id WHERE f.user_id==" + user_id + " and status==" + FRIEND_STATUS.FRIENDSHIP + ";";
        ResultSet result = Connection.executeQuery(query);
        while(result.next()){
            list.add(new Friend(result.getInt("id"), result.getString("name"), result.getInt("trophies")));
        }
        DB.getInstance().releaseConnection(Connection);
        return list;
    }
}
