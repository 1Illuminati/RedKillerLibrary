package org.red.library.io.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.File;

public class ConfigFile<T extends ConfigurationSerializable> {
    private static final String defaultPath = "plugins/RedKillerLibrary/";
    private final FileConfiguration fileConfiguration = new YamlConfiguration();
    private final File configFile;
    private T serializable;

    public ConfigFile(String path) {
        this.configFile = new File(defaultPath + path + ".yml");
    }

    public ConfigFile(String path, T serializable) {
        this(path);
        this.serializable = serializable;
    }

    public T getSerializable() {
        return this.serializable;
    }

    public File getConfigFile() {
        return this.configFile;
    }

    public void read() {
        try {
            this.fileConfiguration.load(this.configFile);
            this.serializable = (T) this.fileConfiguration.get(this.configFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            this.fileConfiguration.set(this.configFile.getName(), this.serializable);
            this.fileConfiguration.save(this.configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
