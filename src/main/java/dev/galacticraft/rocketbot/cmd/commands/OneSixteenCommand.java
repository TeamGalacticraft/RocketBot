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

package dev.galacticraft.rocketbot.cmd.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.galacticraft.rocketbot.cmd.CommandManager;
import dev.galacticraft.rocketbot.cmd.DiscordSource;
import dev.galacticraft.rocketbot.utils.Builders;
import net.dv8tion.jda.api.EmbedBuilder;

public class OneSixteenCommand {

    public static void register(CommandDispatcher<DiscordSource> dispatcher) {
        dispatcher.register(CommandManager.literal("1.16").executes(OneSixteenCommand::execute));
    }

    public static int execute(CommandContext<DiscordSource> context) {
        EmbedBuilder builder = Builders.embed();
        builder.setTitle("Galacticraft 1.16+ Status");
        builder.setDescription("Galacticraft for 1.16+ is currently in development.\n" +
                "You can compile the current version yourself from [Github](https://github.com/StellarHorizons/Galacticraft-Rewoven)" +
                " but no help doing so or any support regarding the build will be provided.");

        context.getSource().getMessage().reply(Builders.message()
                .setEmbed(builder.build())
                .build()
        ).queue();
        return Command.SINGLE_SUCCESS;
    }
}
