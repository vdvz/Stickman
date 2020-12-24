package DB;

import friend.Friend;
import java.util.List;

public class FRIEND_DB implements FRIEND_DB_I{
    @Override
    public List<Friend> FindAllFriend(String query) {
        return null;
    }

    @Override
    public void MakeRequestForFriend(String query) {

    }

    @Override
    public boolean ConfirmRequestForFriend(String query) {
        return false;
    }

    @Override
    public void RemoveFriend(String query) {

    }

    @Override
    public List<Friend> GetFriendsByUser(String query) {
        return null;
    }
}
