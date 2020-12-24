package all_classes_need_to_sep_by_packets;

import proto_files.DangerStickman;

public interface RequestExecutor_I {

    DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request);

}
