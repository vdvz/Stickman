package friend;

import DB.FRIEND_STATUS;
import proto_files.FriendMessages;
import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;

public class Friend implements ProtobufSerializable {
    private final int id;
    private final String name;
    private final int trophies;
    private FRIEND_STATUS Status;

    public Friend(int _id, String _name, int _trophies) {
        id = _id;
        name = _name;
        trophies = _trophies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTrophies() {
        return trophies;
    }

    @Override
    public MessageLite.Builder Serialize() {
        return FriendMessages.friend.newBuilder().setId(getId()).setName(getName()).setTrophies(getTrophies());
    }

    public FRIEND_STATUS getStatus() {
        return Status;
    }

    public void setStatus(FRIEND_STATUS status) {
        Status = status;
    }
}
