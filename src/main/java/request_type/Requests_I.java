package request_type;

import com.google.protobuf.MessageLite;
import proto_files.DangerStickman;

public interface Requests_I {

    DangerStickman.PacketWrapper execute(MessageLite request);

}
