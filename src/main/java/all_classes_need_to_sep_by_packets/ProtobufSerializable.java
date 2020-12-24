package all_classes_need_to_sep_by_packets;

import com.google.protobuf.MessageLite;

public interface ProtobufSerializable {

    MessageLite Serialize();

}
