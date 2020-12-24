package all_classes_need_to_sep_by_packets;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import proto_files.DangerStickman;

public class ProtobufHandler extends SimpleChannelInboundHandler<DangerStickman.PacketWrapper> {

    private final RequestExecutor executor = new RequestExecutor();

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DangerStickman.PacketWrapper o) throws Exception {

        //нужен механизм того как мы будем получать юзера и где
        channelHandlerContext.write(executor.executeRequest(o));

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        //user connect
        System.out.println("Registered channel " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        //user disconnect
        System.out.println("Unregistered channel " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //user connect
        System.out.println("Channel active");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //user disconnect
        System.out.println("Channel inactive");
    }
}
