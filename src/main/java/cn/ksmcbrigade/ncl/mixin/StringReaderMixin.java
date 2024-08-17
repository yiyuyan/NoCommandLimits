package cn.ksmcbrigade.ncl.mixin;

import com.mojang.brigadier.StringReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = StringReader.class,remap = false)
public class StringReaderMixin {
    @Inject(method = "isAllowedNumber",at = @At("RETURN"),cancellable = true)
    private static void allowed(char c, CallbackInfoReturnable<Boolean> cir){
        if(c == 'E' || c == 'e' || c == '+'){
            cir.setReturnValue(true);
        }
    }
}
