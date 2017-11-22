package com.sxtanna.ver;

import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class Compat1_10 implements Compat {

    @Override
    public void sendActionBar(Player player, String message) {
        PacketPlayOutChat chat = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + message + "\"}"), ((byte) 2));
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chat);
    }

}
