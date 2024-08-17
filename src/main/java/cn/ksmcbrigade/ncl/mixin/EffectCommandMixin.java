package cn.ksmcbrigade.ncl.mixin;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.server.commands.EffectCommands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EffectCommands.class)
public class EffectCommandMixin {
    @Redirect(method = "register",at = @At(value = "INVOKE",target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(II)Lcom/mojang/brigadier/arguments/IntegerArgumentType;"))
    private static IntegerArgumentType argumentType(int min, int max){
        return IntegerArgumentType.integer();
    }
}
