package dev.galacticraft.rocketbot.cmd;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.galacticraft.rocketbot.cmd.commands.OneSixteenCommand;

public class CommandManager {

    private final CommandDispatcher<GuildCommandSource> dispatcher = new CommandDispatcher<>();

    public CommandManager() {
        OneSixteenCommand.register(this.dispatcher);
    }

    public CommandDispatcher<GuildCommandSource> getDispatcher() {
        return this.dispatcher;
    }

    public static LiteralArgumentBuilder<GuildCommandSource> literal(String literal) {
        return LiteralArgumentBuilder.literal(literal);
    }

    public static <T> RequiredArgumentBuilder<GuildCommandSource, T> argument(String name, ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }
}
