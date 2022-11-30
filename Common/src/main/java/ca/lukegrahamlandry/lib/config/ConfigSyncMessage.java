package ca.lukegrahamlandry.lib.config;

import ca.lukegrahamlandry.lib.network.ClientboundHandler;

// TODO: check against subDirectory

public class ConfigSyncMessage implements ClientboundHandler {
    String value;
    String name;

    public ConfigSyncMessage(ConfigWrapper<?> wrapper){
        this.name = wrapper.name;

        // encode here using ConfigWrapper#getGson instead of allowing the object to be encoded by the packet module's gson instance
        // this allows adding type adapters to your ConfigWrapper and still having syncing
        this.value = wrapper.getGson().toJson(wrapper.get());
    }


    public void handle(){
        for (ConfigWrapper<?> config : ConfigWrapper.ALL){
            if (config.name.equals(this.name) && config.side == ConfigWrapper.Side.SYNCED) {
                Object syncedValue = config.getGson().fromJson(this.value, config.clazz);
                config.set(syncedValue);
                break;
            }
        }

        throw new RuntimeException("received config sync for unknown name: " + this.name);
    }
}
