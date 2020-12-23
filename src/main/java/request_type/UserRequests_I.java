package request_type;

import com.google.protobuf.MessageLite;

public interface UserRequests_I {

    MessageLite handle(MessageLite request);

}
