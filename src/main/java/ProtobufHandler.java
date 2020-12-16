import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import proto_files.Protofiles.*;

public class ProtobufHandler extends SimpleChannelInboundHandler<RequestWrapper> {

    private final RequestExecutor executor = new RequestExecutor();

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RequestWrapper o) throws Exception {
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
