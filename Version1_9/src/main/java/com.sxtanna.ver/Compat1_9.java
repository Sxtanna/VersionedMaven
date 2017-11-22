package com.sxtanna.ver;

import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class Compat1_9 implements Compat {

    @Override
    public void sendActionBar(Player player, String message) {
        PacketPlayOutChat chat = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + message + "\"}"), ((byte) 2));
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chat);
    }

}
