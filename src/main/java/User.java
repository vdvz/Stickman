import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User implements ProtobufSerializable{

    private final int id;
    private final String name;

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

    Integer getId(){return id;}
    String getName(){return name;}

    void addUpdate(DangerStickman.PacketWrapper update){

    }

    DangerStickman.PacketWrapper getUpdates(){
        return null;
    }

    @Override
    public MessageLite Serialize() {
        return null;
    }
}
