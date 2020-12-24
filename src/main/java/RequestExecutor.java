import proto_files.DangerStickman;

public class RequestExecutor implements RequestExecutor_I{

    public DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request) {

        DangerStickman.PacketWrapper.Builder response = DangerStickman.PacketWrapper.newBuilder();

        if(request.hasUser()){

        }
        if(request.hasRoom()){

        }
        if(request.hasLobby()){

        }
        if(request.hasFriend()){

        }

        return response.build();
    }

}
