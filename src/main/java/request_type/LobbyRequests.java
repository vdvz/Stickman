package request_type;

import com.google.protobuf.MessageLite;
import exceptions.UnknownTypeOfRequest;
import managers.Managers;
import proto_files.DangerStickman;
import proto_files.LobbyMessages;

public class LobbyRequests implements LobbyRequests_I {

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.LobbyWrapper request = (DangerStickman.PacketWrapper.LobbyWrapper) _request;

        if(request.hasUpdateRoomsRequest()){
            return DangerStickman.PacketWrapper.newBuilder()
                    .setLobby(DangerStickman.PacketWrapper.LobbyWrapper.newBuilder()
                    .setUpdateRoomsResponse(GetListOfRooms()))
                    .build();
        }

        throw new UnknownTypeOfRequest();
    }

    LobbyMessages.UpdateRoomsResponse.Builder GetListOfRooms(){
        LobbyMessages.UpdateRoomsResponse.Builder builder = LobbyMessages.UpdateRoomsResponse.newBuilder();
        Managers.getLobby().GetAvailableRooms().forEach(e -> builder.addLiteRoom(e.GetLiteRoom()));
        return builder;
    }

}
