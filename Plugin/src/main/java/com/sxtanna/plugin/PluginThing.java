package com.sxtanna.plugin;

import com.google.common.base.Preconditions;
import com.sxtanna.ver.Compat;
import com.sxtanna.ver.Compat1_10;
import com.sxtanna.ver.Compat1_8;
import com.sxtanna.ver.Compat1_9;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginThing extends JavaPlugin {

    private static PluginThing instance;


    private String ver;
    private Compat compat;


    @Override
    public void onLoad() {
        instance = this;

        ver = getServer().getBukkitVersion();
        ver = ver.substring(0, ver.indexOf('-'));
    }

    @Override
    public void onEnable() {
        switch (ver) {
            case "1.8.8":
                compat = new Compat1_8();
                break;
            case "1.9.4":
                compat = new Compat1_9();
                break;
            case "1.10.2":
                compat = new Compat1_10();
                break;
        }

        Bukkit.getOnlinePlayers().forEach(player -> getCompat().sendActionBar(player, "Hello!!"));
    }

    @Override
    public void onDisable() {
        ver = null;
        compat = null;
    }


    public String getVersion() {
        return ver;
    }

    public Compat getCompat() {
        Preconditions.checkNotNull(compat, "Compat for this version is unavailable");
        return compat;
    }


    public static PluginThing getInstance() {
        return instance;
    }

}
