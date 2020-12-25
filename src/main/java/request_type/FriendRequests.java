package request_type;

import DB.FRIEND_DB;
import exceptions.NoResponse;
import exceptions.UnknownTypeOfRequest;
import managers.Managers;
import com.google.protobuf.MessageLite;
import friend.Friend;
import proto_files.DangerStickman;
import proto_files.FriendMessages;
import user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class FriendRequests implements FriendRequests_I{

    private final FRIEND_DB friendDB = new FRIEND_DB();

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest, NoResponse {
        DangerStickman.PacketWrapper.FriendWrapper request = (DangerStickman.PacketWrapper.FriendWrapper) _request;
        if(request.hasFindFriendsRequest()){
            return DangerStickman.PacketWrapper.newBuilder().setFriend(
                    DangerStickman.PacketWrapper.FriendWrapper.newBuilder()
                            .setFindFriendsResponse(FindFriends(request.getFindFriendsRequest().getStrForSearch()))
            ).build();
        }
        if(request.hasMakeFriendsRequest()){
            MakeRequestForFriend(request.getMakeFriendsRequest().getSelfId(), request.getMakeFriendsRequest().getFriendId());
            throw new NoResponse();
        }
        if(request.hasConfirmationFriendResponse()){
            ConfirmFriendship(request.getConfirmationFriendResponse().getSelfId(),
                    request.getConfirmationFriendResponse().getFriendId(), request.getConfirmationFriendResponse().getConfirmFriendStatus());
            throw new NoResponse();
        }
        if(request.hasRemoveFriendRequest()){
            RemoveFriend(request.getRemoveFriendRequest().getSelfId(), request.getRemoveFriendRequest().getFriendId());
            throw new NoResponse();
        }
        if(request.hasUpdateFriendsListRequest()){

        }
        throw new UnknownTypeOfRequest();
    }

    private FriendMessages.FindFriendsResponse.Builder FindFriends(String find_query){
        List<Friend> finded = null;
        try {
            finded = friendDB.FindAllFriend(find_query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        FriendMessages.FindFriendsResponse.Builder builder = FriendMessages.FindFriendsResponse.newBuilder();
        finded.forEach(e -> builder.addFriends((FriendMessages.friend.Builder) e.Serialize()));
        return builder;
    }

    private void MakeRequestForFriend(Integer from, Integer to){
        try {
            friendDB.MakeRequestForFriend(from.toString(), to.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        User toUser = null;
        User fromUser = null;
        try {
            toUser = Managers.getUserManager().GetUser(to);
            fromUser = Managers.getUserManager().GetUser(from);
        } catch (NoSuchElementException e){
            return;
        }

        toUser.SendConfirmationRequest(new Friend(fromUser.getId(), fromUser.getName(), fromUser.getTrophies()));
    }

    private void ConfirmFriendship(Integer from, Integer to, int status){
        if(status == FriendMessages.ConfirmFriendStatus.DISMISS.getNumber()){
            try {
                friendDB.RemoveFriend(from.toString(), to.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            try {
                friendDB.ConfirmRequestForFriend(from.toString(), to.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            User fromUser = null;
            User toUser = null;
            try{
                fromUser = Managers.getUserManager().GetUser(from);
                fromUser.ConfirmFriendship(friendDB.GetFriend(to.toString()));
            } catch (NoSuchElementException e){

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try{
                toUser = Managers.getUserManager().GetUser(to);
                toUser.ConfirmFriendship(friendDB.GetFriend(from.toString()));
            } catch (NoSuchElementException e){

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void RemoveFriend(Integer from, Integer to){
        try {
            friendDB.RemoveFriend(from.toString(), to.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        User fromUser = null;
        User toUser = null;
        try{
            fromUser = Managers.getUserManager().GetUser(from);
            fromUser.RemoveFriend(to);
        } catch (NoSuchElementException e){

        }

        try{
            toUser = Managers.getUserManager().GetUser(to);
            toUser.RemoveFriend(from);
        } catch (NoSuchElementException e){

        }
    }

    private FriendMessages.UpdateFriendsListResponse.Builder UpdateFriendList(Integer for_user){
        return null;
    }

}
