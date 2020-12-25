package lobby;

import proto_files.LobbyMessages;
import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;
import proto_files.RoomMessages;
import user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room implements Room_I, ProtobufSerializable {
    private ROOM_STATUS Status;
    private final int Id;
    private String Name;
    private User Admin;

    private final List<User> UsersInRoom = Collections.synchronizedList(new ArrayList<>());

    private int Damage = 0;
    private int Gravity = 0;
    private int Speed = 0;
    private int Bounce = 0;

    Room(int room_id, User user){
        Id = room_id;
        Admin = user;
        Name = user.getName();
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getGravity() {
        return Gravity;
    }

    public void setGravity(int gravity) {
        Gravity = gravity;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getBounce() {
        return Bounce;
    }

    public void setBounce(int bounce) {
        Bounce = bounce;
    }

    public User getAdmin() {
        return Admin;
    }

    public void setAdmin(User admin) {
        Admin = admin;
    }

    public ROOM_STATUS getStatus() {
        return Status;
    }

    public void setStatus(ROOM_STATUS status) {
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void AddUser(User user){
        //todo
    }

    public void RemoveUser(User user){
        //todo
    }

    @Override
    public LobbyMessages.LiteRoom.Builder GetLiteRoom() {
        return LobbyMessages.LiteRoom.newBuilder()
                .setRoomId(getId())
                .setRoomName(getName())
                .setCountUsers(UsersInRoom.size());
    }

    private void PickNewAdmin(){
        //todo
    }

    private boolean IsUserAdmin(User user){
        //todo
        return false;
    }

    public List<User> getUsersInRoom() {
        //mb not
        return new ArrayList<>(UsersInRoom);
    }

    @Override
    public MessageLite.Builder Serialize() {
        return RoomMessages.Room.newBuilder()
                .setAdmin(getAdmin().getId())
                //.addAllPlayer()
                .setRoomSettings(RoomMessages.RoomSettings.newBuilder()
                        .setBounce(getBounce())
                        .setDamage(getDamage())
                        .setGravity(getGravity())
                        .setSpeed(getSpeed()));
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
