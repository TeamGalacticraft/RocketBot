package dev.galacticraft.rocketbot.main;

import dev.galacticraft.rocketbot.*;
import dev.galacticraft.rocketbot.config.ConfigManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDA jda;
    public static ConfigManager configManager = new ConfigManager();

    public static void main(String... args) throws LoginException {
        jda = JDABuilder.createDefault(configManager.getConfig().token)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new RocketBot())
                .build();
    }

    public static void shutdown() {
        if(jda != null) {
            jda.shutdown();
        }
    }
}
