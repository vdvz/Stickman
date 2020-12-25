package user;

import friend.Friend;
import io.netty.channel.ChannelHandlerContext;
import proto_files.DangerStickman;

public interface USER_I {
    int getId();

    String getName();

    void setName(String newName);

    USER_STATUS getStatus();

    void setChannelHandlerContext(ChannelHandlerContext chx);

    void send(DangerStickman.PacketWrapper msg);

    int getMoney();

    void setMoney(int money);

    int getTrophies();

    void setTrophies(int trophies);

    int getCount_win();

    void setCount_win(int count_win);

    int getCount_loss();

    void setCount_loss(int count_loss);

    void updateFriends();

    void RemoveFriend(int friend_id);

    //from user to me
    void SendConfirmationRequest(Friend from);

    //friend confirm my request
    void ConfirmFriendship(Friend confirmFriend);
}
