package DB;
import Friend.Friend;
import java.util.List;

public interface FRIEND_DB_I {

    List<Friend> FindAllFriend(String query);

    void MakeRequestForFriend(String query);

    boolean ConfirmRequestForFriend(String query);

    void RemoveFriend(String query);

    List<Friend> GetFriendsByUser(String query);

}