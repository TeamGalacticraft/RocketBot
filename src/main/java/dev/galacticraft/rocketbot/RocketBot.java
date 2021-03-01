/*
 * Copyright (c) 2021 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.rocketbot;

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
        String prefix = String.format("<@!%s> ", event.getJDA().getSelfUser().getId());
        if(msg.startsWith(prefix)) {
            GuildCommandSource source = new GuildCommandSource(
                    event.getMember(),
                    event.getMessage(),
                    event.getGuild(),
                    event.getChannel()
            );

            try {
                event.getChannel().sendTyping().queue();
                this.commandManager.getDispatcher().execute(msg.substring(prefix.length()), source);
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
