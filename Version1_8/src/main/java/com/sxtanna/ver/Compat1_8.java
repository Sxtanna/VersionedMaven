package com.sxtanna.ver;

import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public final class Compat1_8 implements Compat {

    @Override
    public void sendActionBar(Player player, String message) {
        PacketPlayOutChat chat = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + message + "\"}"), ((byte) 2));
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chat);
    }

}
