package request_type;

import com.google.protobuf.MessageLite;
import exceptions.NoAvailableIDException;
import exceptions.NoSuchUserException;
import exceptions.UnknownTypeOfRequest;
import managers.Managers;
import proto_files.DangerStickman;
import proto_files.RoomMessages;
import user.User;

public class RoomRequests implements RoomRequests_I {
    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.RoomWrapper request = (DangerStickman.PacketWrapper.RoomWrapper) _request;

        if(request.hasAppendToRoomRequest()){

        }
        if(request.hasCreateNewRoomRequest()){
            try {
                return DangerStickman.PacketWrapper.newBuilder()
                        .setRoom(DangerStickman.PacketWrapper.RoomWrapper.newBuilder().setCreateNewRoomResponse(
                                CreateNewRoom(request.getCreateNewRoomRequest().getId()))
                        )
                        .build();
            } catch (NoAvailableIDException e) {
                e.printStackTrace();
            }
        }
        if(request.hasExitFromRoomRequest()){

        }
        if(request.hasRandomRoomRequest()){
            //todo
        }
        throw new UnknownTypeOfRequest();
    }

    void AppendNewUserToRoom(){

    }

    RoomMessages.CreateNewRoomResponse.Builder CreateNewRoom(int user_id) throws NoAvailableIDException, NoSuchUserException {
        User user = Managers.getUserManager().GetUser(user_id);
        return RoomMessages.CreateNewRoomResponse.newBuilder().setRoom((RoomMessages.Room.Builder) Managers.getLobby().CreateNewRoom(user).Serialize());
    }

    void TryExitFromRoom(){

    }
}
