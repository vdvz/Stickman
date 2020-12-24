package request_type;

import DB.FRIEND_DB;
import all_classes_need_to_sep_by_packets.Managers;
import com.google.protobuf.MessageLite;
import friend.Friend;
import proto_files.DangerStickman;
import proto_files.FriendMessages;
import user.User;

import java.util.List;
import java.util.NoSuchElementException;

public class FriendRequests implements FriendRequests_I{

    private final FRIEND_DB friendDB = new FRIEND_DB();

    @Override
    public MessageLite handle(MessageLite request) {
        return null;
    }

    @Override
    public DangerStickman.PacketWrapper handle(DangerStickman.PacketWrapper.FriendWrapper request) {
        if(request.hasFindFriendsRequest()){

        }
        if(request.hasMakeFriendsRequest()){

        }
        if(request.hasConfirmationFriendsRequest()){

        }
        if(request.hasRemoveFriendRequest()){

        }
        if(request.hasUpdateFriendsListRequest()){

        }
        return null;
    }

    private FriendMessages.FindFriendsResponse.Builder FindFriends(String find_query){
        List<Friend> finded = friendDB.FindAllFriend(find_query);
        FriendMessages.FindFriendsResponse.Builder builder = FriendMessages.FindFriendsResponse.newBuilder();
        finded.forEach(e -> builder.addFriends((FriendMessages.friend) e.Serialize()));
        return builder;
    }

    private void MakeRequestForFriend(Integer from, Integer to){
        friendDB.MakeRequestForFriend(from.toString(), to.toString());
        User toUser = null;
        User fromUser = null;
        try {
            toUser = Managers.getUserManager().GetUser(to);
            fromUser = Managers.getUserManager().GetUser(from);
        } catch (NoSuchElementException e){
            return;
        }
        toUser.send((DangerStickman.PacketWrapper) new Friend(fromUser.getId(), fromUser.getName(), fromUser.getTrophies()).Serialize());
    }

    private void GetConfirmationFromUser(){

    }

    private void RemoveFriend(){

    }

    private FriendMessages.UpdateFriendsListResponse.Builder UpdateFriendList(Integer for_user){

    }


}
