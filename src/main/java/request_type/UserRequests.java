package request_type;

import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;

public class UserRequests implements UserRequests_I{
    @Override
    public DangerStickman.PacketWrapper execute(MessageLite _request) {
        DangerStickman.PacketWrapper.UserWrapper request = (DangerStickman.PacketWrapper.UserWrapper) _request;
        if(request.hasLoadUserRequest()){

        }
        if(request.hasUpdateUserRequest()){

        }
        return null;//todo throw new exception
    }

    void LoadNewUser(){

    }

    void UpdateExistingUser(){

    }
}
