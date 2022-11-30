/*
 * This file is part of WrapperLib
 * Copyright 2022 LukeGrahamLandry
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package ca.lukegrahamlandry.lib.event;

import ca.lukegrahamlandry.lib.base.event.EventWrapper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventListeners {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onServerStart(ServerStartedEvent event){
        EventWrapper.get().forEach((handler) -> handler.onServerStart(event.getServer()));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onServerStop(ServerStoppedEvent event){
        EventWrapper.get().forEach((handler) -> handler.onServerStop(event.getServer()));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLevelSave(LevelEvent.Save event){
        EventWrapper.get().forEach((handler) -> handler.onLevelSave(event.getLevel()));
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        EventWrapper.get().forEach((handler) -> handler.onPlayerLogin(event.getEntity()));
    }
}
