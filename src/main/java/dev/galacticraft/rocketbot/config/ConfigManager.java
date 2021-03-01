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
