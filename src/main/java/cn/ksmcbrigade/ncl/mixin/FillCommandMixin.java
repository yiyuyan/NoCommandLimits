package cn.ksmcbrigade.ncl.mixin;

import net.minecraft.server.commands.FillCommand;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FillCommand.class)
public class FillCommandMixin {
    @Redirect(method = "fillBlocks",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/level/GameRules;getInt(Lnet/minecraft/world/level/GameRules$Key;)I"))
    private static int fill(GameRules instance, GameRules.Key<GameRules.IntegerValue> p_46216_){
        return Integer.MAX_VALUE;
    }
}
