package dev.galacticraft.rocketbot.cmd;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

public class GuildCommandSource {
    private final Member author;
    private final Message message;
    private final Guild guild;
    private final GuildChannel channel;

    public GuildCommandSource(Member author, Message message, Guild guild, GuildChannel channel) {
        this.author = author;
        this.message = message;
        this.guild = guild;
        this.channel = channel;
    }

    public Member getAuthor() {
        return this.author;
    }

    public Message getMessage() {
        return this.message;
    }

    public Guild getGuild() {
        return this.guild;
    }

    public GuildChannel getChannel() {
        return this.channel;
    }
}
