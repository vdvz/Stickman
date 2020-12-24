package server;

import exceptions.NoResponse;
import exceptions.UnknownTypeOfRequest;
import proto_files.DangerStickman;
import request_type.*;

public class RequestExecutor implements RequestExecutor_I{

    private final UserRequests_I userRequests = new UserRequests();
    private final GameRequests_I gameRequests = new GameRequests();
    private final FriendRequests_I friendRequests = new FriendRequests();
    private final RoomRequests_I roomRequests = new RoomRequests();
    private final LobbyRequests_I lobbyRequests = new LobbyRequests();

    public DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request) throws NoResponse {

        DangerStickman.PacketWrapper.Builder response = DangerStickman.PacketWrapper.newBuilder();

        if(request.hasUser()){
            try {
                userRequests.execute(request.getUser());
            } catch (UnknownTypeOfRequest unknownTypeOfRequest) {
                unknownTypeOfRequest.printStackTrace();
            }
        }
        if(request.hasRoom()){
            try {
                roomRequests.execute(request.getRoom());
            } catch (UnknownTypeOfRequest unknownTypeOfRequest) {
                unknownTypeOfRequest.printStackTrace();
            }
        }
        if(request.hasLobby()){
            try {
                lobbyRequests.execute(request.getLobby());
            } catch (UnknownTypeOfRequest unknownTypeOfRequest) {
                unknownTypeOfRequest.printStackTrace();
            }
        }
        if(request.hasFriend()){
            try {
                friendRequests.execute(request.getFriend());
            } catch (UnknownTypeOfRequest unknownTypeOfRequest) {
                unknownTypeOfRequest.printStackTrace();
            }
        }
        if(request.hasGame()){
            try {
                gameRequests.execute(request.getGame());
            } catch (UnknownTypeOfRequest unknownTypeOfRequest) {
                unknownTypeOfRequest.printStackTrace();
            }
        }

        return response.build();
    }

}
