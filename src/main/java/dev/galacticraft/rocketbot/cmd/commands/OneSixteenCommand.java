package dev.galacticraft.rocketbot.cmd.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.galacticraft.rocketbot.cmd.CommandManager;
import dev.galacticraft.rocketbot.cmd.GuildCommandSource;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.time.OffsetDateTime;

public class OneSixteenCommand {

    public static void register(CommandDispatcher<GuildCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("1.16").executes(OneSixteenCommand::execute));
    }

    public static int execute(CommandContext<GuildCommandSource> context) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Galacticraft 1.16+ Status");
        builder.setDescription("Galacticraft for 1.16+ is currently in development.\n" +
                "You can compile the current version yourself from [Github](https://github.com/StellarHorizons/Galacticraft-Rewoven)" +
                " but no help doing so or any support regarding the build will be provided.");

        builder.setTimestamp(OffsetDateTime.now());
        builder.setFooter("Requested by " +
                context.getSource().getAuthor().getUser().getName() + "#" +
                context.getSource().getAuthor().getUser().getDiscriminator(), "https://cdn.iosoft.works/assets/rocketbot.png");

        context.getSource().getMessage().reply(new MessageBuilder()
                .denyMentions(Message.MentionType.values())
                .setEmbed(builder.build())
                .build()
        ).queue();
        return Command.SINGLE_SUCCESS;
    }
}
