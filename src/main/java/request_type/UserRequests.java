package request_type;

import DB.USER_DB;
import DB.USER_DB_I;
import com.google.protobuf.MessageLite;
import exceptions.NoSuchUserException;
import exceptions.UnknownTypeOfRequest;
import io.netty.channel.ChannelHandlerContext;
import managers.Managers;
import proto_files.DangerStickman;
import proto_files.UserMessages;
import user.User;

import java.sql.SQLException;

public class UserRequests implements UserRequests_I{

    USER_DB_I userDB = new USER_DB();

    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) throws UnknownTypeOfRequest {
        DangerStickman.PacketWrapper.UserWrapper request = (DangerStickman.PacketWrapper.UserWrapper) _request;
        if(request.hasLoadUserRequest()){
            return DangerStickman.PacketWrapper.newBuilder()
                    .setUser(DangerStickman.PacketWrapper.UserWrapper.newBuilder().setUserResponse(
                            LoadNewUser(request.getLoadUserRequest().getAndroidId())
                    ))
                    .build();
        }
        if(request.hasUpdateUserRequest()){
            try{
                return DangerStickman.PacketWrapper.newBuilder()
                        .setUser(
                                DangerStickman.PacketWrapper.UserWrapper.newBuilder()
                                        .setUserResponse(UpdateExistingUser(request.getUpdateUserRequest().getUserId()))
                                        .build()
                        )
                        .build();
            } catch(NoSuchUserException e){
                //todo handle error
            }
        }
        throw new UnknownTypeOfRequest();
    }

    UserMessages.UserResponse.Builder LoadNewUser(String android_id){
        try {
            User user = userDB.GetUser(android_id);
            Managers.getUserManager().AddToOnline(user);
            return UserMessages.UserResponse.newBuilder().setUser((UserMessages.user.Builder) user.Serialize());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    UserMessages.UserResponse UpdateExistingUser(int user_id) throws NoSuchUserException{
        return UserMessages.UserResponse.newBuilder().setUser((UserMessages.user.Builder) Managers.getUserManager().GetUser(user_id).Serialize()).build();
    }
}
