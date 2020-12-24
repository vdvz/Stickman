package DB;
import friend.Friend;

import java.sql.SQLException;
import java.util.List;

public interface FRIEND_DB_I {

    List<Friend> FindAllFriend(String query) throws SQLException;

    void MakeRequestForFriend(String from, String to) throws SQLException;

    void ConfirmRequestForFriend(String from, String to) throws SQLException;

    void RemoveFriend(String from, String to) throws SQLException;

    List<Friend> GetFriendsByUser(String query) throws SQLException;

}