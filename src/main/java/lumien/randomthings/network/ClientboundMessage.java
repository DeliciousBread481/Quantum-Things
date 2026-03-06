package lumien.randomthings.network;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import com.google.common.base.Preconditions;

public interface ClientboundMessage extends IRTMessage
{
    /**
     * Handles this message on the main thread.
     *
     * @param player The client's player.
     */
    void handleOnClient(@Nonnull EntityPlayer player);

    abstract class NoReplyHandler<M extends ClientboundMessage> implements IMessageHandler<M, IMessage>
    {
        @Override
        public IMessage onMessage(M message, MessageContext ctx)
        {
            message.handleOnClient(ctx);
            return null;
        }
    }
}
