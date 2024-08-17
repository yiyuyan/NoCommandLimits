package cn.ksmcbrigade.ncl.mixin;

import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(method = "getFullname",at = @At(value = "INVOKE",target = "Lnet/minecraft/network/chat/MutableComponent;append(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;",shift = At.Shift.BEFORE),locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    public void fullName(int p_44701_, CallbackInfoReturnable<Component> cir, MutableComponent mutablecomponent){
        boolean change = false;
        if(p_44701_>10 && p_44701_<=200000){
            mutablecomponent.append(CommonComponents.SPACE).append(noCommandLimits$intToRoman(p_44701_));
            change = true;
        }
        else if(p_44701_>200000){
            mutablecomponent.append(CommonComponents.SPACE).append(String.valueOf(p_44701_));
            change = true;
        }
        if(change){
            cir.setReturnValue(mutablecomponent);
            cir.cancel();
        }
    }

    @Unique
    public String noCommandLimits$intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    sb.append(symbols[i]);
                    num -= values[i];
                }
            }
        }
        catch (Exception e){
            sb = new StringBuilder(String.valueOf(num));
        }
        return sb.toString();
    }
}
