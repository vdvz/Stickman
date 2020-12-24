package request_type;

import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;
import proto_files.RoomMessages;

public class RoomRequests implements RoomRequests_I {
    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) {
        DangerStickman.PacketWrapper.RoomWrapper request = (DangerStickman.PacketWrapper.RoomWrapper) _request;

        if(request.hasAppendToRoomRequest()){

        }
        if(request.hasCreateNewRoomRequest()){

        }
        if(request.hasExitFromRoomRequest()){

        }
        if(request.hasRandomRoomRequest()){
            //todo
        }
        return null;//todo throw message
    }

    void AppendNewUserToRoom(){

    }

    void CreateNewRoom(){

    }

    void TryExitFromRoom(){

    }

}
