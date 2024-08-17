package cn.ksmcbrigade.ncl.mixin;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.server.commands.GiveCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GiveCommand.class)
public class GiveCommandMixin {
    @Redirect(method = "register",at = @At(value = "INVOKE",target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(I)Lcom/mojang/brigadier/arguments/IntegerArgumentType;"))
    private static IntegerArgumentType argumentType(int min){
        return IntegerArgumentType.integer();
    }

    @ModifyVariable(method = "giveItem",at = @At(value = "STORE"),ordinal = 2)
    private static int giveItem(int j){
        return Integer.MAX_VALUE;
    }
}
