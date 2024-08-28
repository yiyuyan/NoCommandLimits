package cn.ksmcbrigade.ncl.mixin;

import net.minecraft.commands.arguments.TimeArgument;
import net.minecraft.server.commands.WeatherCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {
    @Redirect(method = "register",at = @At(value = "INVOKE",target = "Lnet/minecraft/commands/arguments/TimeArgument;time(I)Lnet/minecraft/commands/arguments/TimeArgument;"))
    private static TimeArgument argumentType(int min){
        return TimeArgument.time();
    }
}
