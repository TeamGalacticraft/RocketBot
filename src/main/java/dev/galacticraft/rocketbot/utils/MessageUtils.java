package dev.galacticraft.rocketbot.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.time.OffsetDateTime;

public class MessageUtils {

    public static MessageBuilder messageBuilder() {
        return new MessageBuilder().denyMentions(Message.MentionType.values());
    }

    public static EmbedBuilder embedBuilder() {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTimestamp(OffsetDateTime.now());
        builder.setFooter("RocketBot(" + Constants.VERSION + ")",
                "https://cdn.iosoft.works/assets/rocketbot.png");

        return builder;
    }
}
