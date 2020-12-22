import proto_files.DangerStickman.*;

public class RequestExecutor implements RequestExecutor_I{

    public PacketWrapper executeRequest(PacketWrapper request) {

        PacketWrapper.Builder response = PacketWrapper.newBuilder();

        if(request.hasUser()){

        }
        if(request.hasUpdate()){

        }
        if(request.hasRoom()){

        }
        if(request.hasLobby()){

        }
        if(request.hasFriend()){

        }

        return response.build();
    }

    PacketWrapper.UserWrapper handleUser(PacketWrapper.UserWrapper o){
        PacketWrapper.UserWrapper.Builder builder = PacketWrapper.UserWrapper.newBuilder();
        if(o.hasLoadUserRequest()){

        }
        if(o.hasUpdateUserRequest()){

        }
        return builder.build();
    }

    PacketWrapper.FriendWrapper handleFriend(PacketWrapper.FriendWrapper o){
        PacketWrapper.FriendWrapper.Builder builder = PacketWrapper.FriendWrapper.newBuilder();


        return builder.build();
    }

    PacketWrapper.LobbyWrapper handleLobby(PacketWrapper.LobbyWrapper o){
        PacketWrapper.LobbyWrapper.Builder builder = PacketWrapper.LobbyWrapper.newBuilder();


        return builder.build();
    }

    PacketWrapper.UpdateWrapper handleUpdate(PacketWrapper.UpdateWrapper o){
        PacketWrapper.UpdateWrapper.Builder builder = PacketWrapper.UpdateWrapper.newBuilder();


        return builder.build();
    }

    PacketWrapper.RoomWrapper handleRoom(PacketWrapper.RoomWrapper o){

        return null;
    }

}
