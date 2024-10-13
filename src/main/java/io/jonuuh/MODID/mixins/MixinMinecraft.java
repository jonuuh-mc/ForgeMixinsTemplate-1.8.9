package io.jonuuh.MODID.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
    @Final
    @Shadow
    private Session session;

    @Shadow
    public EntityPlayerSP thePlayer;

    @Shadow
    public abstract NetHandlerPlayClient getNetHandler();

    @Unique
    private boolean MODID$hasPrinted;

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/WorldClient;joinEntityInSurroundings(Lnet/minecraft/entity/Entity;)V"/*, ordinal = 1*/))
    public void MODID$printSessionName(CallbackInfo ci)
    {
        if (!MODID$hasPrinted)
        {
            String s = ci.getId() + ": " + MODID$getSessionPlayerInfo().getGameProfile().getName();

            System.out.println(s);
            this.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + s));

            MODID$hasPrinted = true;
        }
    }

    @Unique
    private NetworkPlayerInfo MODID$getSessionPlayerInfo()
    {
        return this.getNetHandler().getPlayerInfo(this.session.getPlayerID());
    }
}
