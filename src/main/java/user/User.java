package user;

import all_classes_need_to_sep_by_packets.ProtobufSerializable;
import all_classes_need_to_sep_by_packets.USER_STATUS;
import friend.Friend;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import proto_files.DangerStickman;

import java.util.*;

public class User implements ProtobufSerializable {

    private final int id;
    private String name;
    private USER_STATUS Status;
    private ChannelHandlerContext channelHandlerContext;
    private int money = 0;
    private int trophies = 0;
    private int count_win = 0;
    private int count_loss = 0;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    void setStatus(USER_STATUS status){
        Status = status;
    }

    USER_STATUS getStatus(){
        return Status;
    }

    private final List<Integer> skins = new ArrayList<>();

    public User(){
        id = 0;
    }

    public User(int _id, String _name){
        id = _id;
        name = _name;
    }

    void setChannelHandlerContext(ChannelHandlerContext chx){
        channelHandlerContext = chx;
    }

    User(ChannelHandlerContext _channelHandlerContext, int _id){
        this(_id, null);
    }

    void addUpdate(DangerStickman.PacketWrapper update){
    }

    boolean hasUpdate(){
        return false;
    }

    DangerStickman.PacketWrapper getUpdate(){
        return null;
    }

    public void send(DangerStickman.PacketWrapper msg){
        channelHandlerContext.write(msg);
    }

    @Override
    public MessageLite Serialize() {
        return null;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getCount_win() {
        return count_win;
    }

    public void setCount_win(int count_win) {
        this.count_win = count_win;
    }

    public int getCount_loss() {
        return count_loss;
    }

    public void setCount_loss(int count_loss) {
        this.count_loss = count_loss;
    }
}