import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;

import java.util.*;

public class User implements ProtobufSerializable{

    public static enum USER_STATUS{
        ONLINE,
        DISCONNECTED,
        CHANGED
    }

    private final int id;
    private String name;
    private USER_STATUS Status;

    int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    void setStatus(boolean status){
    }

    USER_STATUS getStatus(){
        return Status;
    }

    private final List<Integer> skins = new ArrayList<>();
    List<Friend> IncomingRequestForFriend = new ArrayList<>();
    List<Friend> Friends = new ArrayList<>();

    //MB NOT AND JUST PUT RECORD IN DATABASE
    List<Friend> OutGoingRequestForFriend = new ArrayList<>();

    //FOR FUTURE MB MAKE PRIORITY QUEUE -> MOST EXPENSIVE UPDATES WILL SEND FASTER
    Queue<DangerStickman.PacketWrapper> UpdateQueue = new LinkedList<>();

    User(int _id, String _name){
        id = _id;
        name = _name;
    }

    User(int _id){
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

    @Override
    public MessageLite Serialize() {
        return null;
    }

}
