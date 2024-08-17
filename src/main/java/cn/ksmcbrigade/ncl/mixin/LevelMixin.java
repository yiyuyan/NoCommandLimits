package cn.ksmcbrigade.ncl.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public class LevelMixin {
    @Inject(method = "isInSpawnableBounds",at = @At("RETURN"),cancellable = true)
    private static void out(BlockPos p_46742_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
