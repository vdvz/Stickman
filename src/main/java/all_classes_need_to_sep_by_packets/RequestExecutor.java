package all_classes_need_to_sep_by_packets;

import proto_files.DangerStickman;
import request_type.*;

public class RequestExecutor implements RequestExecutor_I{

    private final UserRequests_I userRequests = new UserRequests();
    private final GameRequests_I gameRequests = new GameRequests();
    private final FriendRequests_I friendRequests = new FriendRequests();
    private final RoomRequests_I roomRequests = new RoomRequests();
    private final LobbyRequests_I lobbyRequests = new LobbyRequests();
    public DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request) {

        DangerStickman.PacketWrapper.Builder response = DangerStickman.PacketWrapper.newBuilder();

        if(request.hasUser()){
            userRequests.handle(request.getUser());
        }
        if(request.hasRoom()){
            roomRequests.handle(request.getRoom());
        }
        if(request.hasLobby()){
            lobbyRequests.handle(request.getLobby());
        }
        if(request.hasFriend()){
            friendRequests.handle(request.getFriend());
        }
        if(request.hasGame()){
            gameRequests.handle(request.getGame());
        }

        return response.build();
    }

}
