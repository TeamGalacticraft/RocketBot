package dev.galacticraft.rocketbot;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.galacticraft.rocketbot.cmd.CommandManager;
import dev.galacticraft.rocketbot.cmd.GuildCommandSource;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class RocketBot extends ListenerAdapter {
    CommandManager commandManager = new CommandManager();

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        // @TODO: dynamic bot user id for prefix.
        if(msg.startsWith("<@!815682466027274269> ")) {
            GuildCommandSource source = new GuildCommandSource(
                    event.getMember(),
                    event.getMessage(),
                    event.getGuild(),
                    event.getChannel()
            );
            try {
                this.commandManager.getDispatcher().execute(msg.substring("<@!815682466027274269> ".length()), source);
            } catch (CommandSyntaxException e) {
                event.getMessage().reply(e.getMessage()).queue();
            }
        }
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("stars go by."));
    }
}
