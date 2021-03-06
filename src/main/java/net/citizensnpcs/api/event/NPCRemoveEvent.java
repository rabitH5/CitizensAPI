package net.citizensnpcs.api.event;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.event.HandlerList;

public class NPCRemoveEvent extends NPCEvent {

    public NPCRemoveEvent(NPC npc) {
        super(npc);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
