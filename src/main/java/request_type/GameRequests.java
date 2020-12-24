package request_type;

import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;

public class GameRequests implements GameRequests_I{

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) {
        DangerStickman.PacketWrapper.GameWrapper request = (DangerStickman.PacketWrapper.GameWrapper) _request;
        if(request.hasStartGameRequest()){

        }
        if(request.hasChangePlayerPosition()){

        }
        return null;//todo throw exception
    }


}
