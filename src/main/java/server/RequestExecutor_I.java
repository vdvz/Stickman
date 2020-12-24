package server;

import exceptions.NoResponse;
import proto_files.DangerStickman;

public interface RequestExecutor_I {

    DangerStickman.PacketWrapper executeRequest(DangerStickman.PacketWrapper request) throws NoResponse;

}
