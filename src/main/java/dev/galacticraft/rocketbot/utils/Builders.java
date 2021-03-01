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

package dev.galacticraft.rocketbot.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;
import java.time.OffsetDateTime;

public class Builders {

    public static MessageBuilder message() {
        return new MessageBuilder().denyMentions(Message.MentionType.values());
    }

    public static EmbedBuilder embed() {
        return embed(false);
    }

    public static EmbedBuilder embed(boolean error) {
        EmbedBuilder builder = new EmbedBuilder();

        if(error) {
            builder.setColor(new Color(235, 64, 52));
            builder.setTitle("An error occurred.");
        }

        builder.setTimestamp(OffsetDateTime.now());
        builder.setFooter("RocketBot(" + Constants.VERSION + ")",
                "https://cdn.iosoft.works/assets/rocketbot.png");

        return builder;
    }
}
