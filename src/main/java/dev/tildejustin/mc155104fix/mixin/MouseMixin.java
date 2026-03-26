package dev.tildejustin.mc155104fix.mixin;

import net.minecraft.client.MouseHandler;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public abstract class MouseMixin {
    @Shadow
    private boolean ignoreFirstMove;

    @Inject(method = "grabMouse", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;attackCooldown:I", opcode = Opcodes.PUTFIELD))
    private void setResChanged(CallbackInfo ci) {
        this.ignoreFirstMove = true;
    }
}
