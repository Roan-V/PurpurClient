package org.purpurmc.purpur.client;

import com.google.common.io.ByteArrayDataOutput;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import org.purpurmc.purpur.client.network.Packet;
import org.purpurmc.purpur.client.util.Constants;

public class PurpurClient implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (!client.isInSingleplayer()) {
                ByteArrayDataOutput out = Packet.out();
                out.writeInt(Constants.PROTOCOL);
                Packet.send(Packet.HELLO, out);
            }
        });
    }
}