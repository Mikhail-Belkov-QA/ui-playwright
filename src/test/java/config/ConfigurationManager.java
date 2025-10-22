package config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {
    private static volatile Configuration instance;

    private ConfigurationManager() {}

    public static Configuration getInstance() {
        Configuration local = instance;
        if (local == null) {
            synchronized (ConfigurationManager.class) {
                local = instance;
                if (local == null) {
                    local = ConfigCache.getOrCreate(Configuration.class);
                    instance = local;
                }
            }
        }
        return local;
    }

    public static Configuration config() {
        return getInstance();
    }
}
