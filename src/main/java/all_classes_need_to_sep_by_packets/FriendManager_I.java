package all_classes_need_to_sep_by_packets;

import friend.Friend;
import user.User;

import java.util.List;

public interface FriendManager_I {

    List<Friend> GetFriends();

    Friend GetFriend(User user);

    void AddFriend(User user);

    void AddFriend(int user_id);

    void RemoveFriend(int user_id);

}
