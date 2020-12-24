package request_type;

import com.google.protobuf.MessageLite;
import com.sun.tools.javac.util.List;
import lobby.Room;
import proto_files.DangerStickman;

public class LobbyRequests implements LobbyRequests_I {

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) {
        DangerStickman.PacketWrapper.LobbyWrapper request = (DangerStickman.PacketWrapper.LobbyWrapper) _request;

        if(request.hasUpdateRoomsRequest()){

        }

        return null;//todo throw exception
    }

    List<Room> GetListOfRooms(){
        return null;
    }

}
