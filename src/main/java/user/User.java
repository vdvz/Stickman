package user;

import exceptions.NoSuchFriendException;
import proto_files.FriendMessages;
import server.ProtobufSerializable;
import friend.Friend;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import proto_files.DangerStickman;
import proto_files.UserMessages;

import java.util.*;

public class User implements ProtobufSerializable, USER_I {

    private final int id;
    private String name = "null";
    private USER_STATUS Status;
    private ChannelHandlerContext channelHandlerContext;
    private int money = 0;
    private int trophies = 0;
    private int count_win = 0;
    private int count_loss = 0;

    private final List<Integer> skins = new ArrayList<>();

    private final List<Friend> friends = new ArrayList<>();

    public User(){
        id = 0;
    }

    public User(int _id, String _name){
        id = _id;
        name = _name;
    }

    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setName(String newName){
        name = newName;
    }

    void setStatus(USER_STATUS status){
        Status = status;
    }
    @Override
    public USER_STATUS getStatus(){
        return Status;
    }
    @Override
    public void setChannelHandlerContext(ChannelHandlerContext chx){
        channelHandlerContext = chx;
    }
    @Override
    public void send(DangerStickman.PacketWrapper msg){
        channelHandlerContext.write(msg);
    }
    @Override
    public int getMoney() {
        return money;
    }
    @Override
    public void setMoney(int money) {
        this.money = money;
    }
    @Override
    public int getTrophies() {
        return trophies;
    }
    @Override
    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
    @Override
    public int getCount_win() {
        return count_win;
    }
    @Override
    public void setCount_win(int count_win) {
        this.count_win = count_win;
    }
    @Override
    public int getCount_loss() {
        return count_loss;
    }
    @Override
    public void setCount_loss(int count_loss) {
        this.count_loss = count_loss;
    }

    @Override
    public void UpdateFriends(){
        FriendMessages.UpdateFriendsListResponse.Builder builder = FriendMessages.UpdateFriendsListResponse.newBuilder();
        friends.forEach(e -> builder.addFriends((FriendMessages.friend.Builder) e.Serialize()));
        send(DangerStickman.PacketWrapper.newBuilder()
                .setFriend(DangerStickman.PacketWrapper.FriendWrapper.newBuilder()
                        .setUpdateFriendsListResponse(builder)
                )
                .build());
    }

    private void AddFriend(Friend friend){
        friends.add(friend);
    }
    @Override
    public void RemoveFriend(int friend_id){
        try {
            friends.stream().filter(e -> e.getId() == friend_id).findFirst().get();
        } catch (NoSuchElementException e){
            throw new NoSuchFriendException();
        }
        UpdateFriends();
    }

    @Override
    //from user to me
    public void SendConfirmationRequest(Friend from){
        send(DangerStickman.PacketWrapper.newBuilder()
                .setFriend(DangerStickman.PacketWrapper.FriendWrapper.newBuilder()
                        .setConfirmationFriendsRequest(FriendMessages.ConfirmationFriendRequest.newBuilder()
                            .setFriend((FriendMessages.friend.Builder) from.Serialize())
                        )
                )
            .build()
        );
    }

    @Override
    //friend confirm my request
    public void ConfirmFriendship(Friend confirmFriend){
        AddFriend(confirmFriend);
        UpdateFriends();
    }

    @Override
    public MessageLite.Builder Serialize() {
        return UserMessages.user.newBuilder().setId(getId())
                .setName(getName()==null ? "null" : getName())
                .setMoney(getMoney())
                .setTrophies(getTrophies());
    }

}