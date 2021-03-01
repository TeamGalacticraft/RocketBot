package dev.galacticraft.rocketbot.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.galacticraft.rocketbot.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigManager {
    private final Logger logger = LoggerFactory.getLogger("Config");
    private final Gson gson = new GsonBuilder().create();
    private final File configFile = new File("config.json");
    private final File exampleFile = new File("config.example.json");
    private Config config;

    public void load() {
        if(configFile.exists()) {
            try {
                this.config = gson.fromJson(Files.readString(configFile.toPath()), Config.class);
            } catch (IOException e) {
                logger.error("There was an error loading \"config.json\"", e);
                Main.shutdown();
            }
        } else if (exampleFile.exists()) {
            logger.error("Config file does not exist, copy and modify \"config.example.json\"!");
            Main.shutdown();
        }
    }

    public Config getConfig() {
        return config;
    }
}
