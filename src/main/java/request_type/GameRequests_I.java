package request_type;

import com.google.protobuf.MessageLite;

public interface GameRequests_I {

    MessageLite handle(MessageLite request);

}
