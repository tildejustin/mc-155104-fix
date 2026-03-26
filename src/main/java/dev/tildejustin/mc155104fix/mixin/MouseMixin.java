package dev.tildejustin.mc155104fix.mixin;

import net.minecraft.client.Mouse;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow
    private boolean hasResolutionChanged;

    @Inject(method = "lockCursor", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;attackCooldown:I", opcode = Opcodes.PUTFIELD))
    private void setResChanged(CallbackInfo ci) {
        this.hasResolutionChanged = true;
    }
}
