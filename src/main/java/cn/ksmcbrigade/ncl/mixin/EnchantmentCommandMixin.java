package cn.ksmcbrigade.ncl.mixin;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.server.commands.EnchantCommand;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantCommand.class)
public class EnchantmentCommandMixin {
    @Redirect(method = "register",at = @At(value = "INVOKE",target = "Lcom/mojang/brigadier/arguments/IntegerArgumentType;integer(I)Lcom/mojang/brigadier/arguments/IntegerArgumentType;"))
    private static IntegerArgumentType argumentType(int min){
        return IntegerArgumentType.integer();
    }

    @Redirect(method = "enchant",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/item/enchantment/Enchantment;getMaxLevel()I"))
    private static int max(Enchantment instance){
        return Integer.MAX_VALUE;
    }
}
