/*
 * WorldGuard, a suite of tools for Minecraft
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldguard.events;

import com.sk89q.worldguard.events.listeners.*;

import java.util.ArrayList;

/**
 * Designed to manage internal events
 */
public class EventManager {
    private ArrayList<CreateRegionListener> createRegionEventListeners = new ArrayList<>();
    private ArrayList<RemoveRegionListener> removeRegionListeners = new ArrayList<>();
    private ArrayList<SetFlagRegionListener> setFlagRegionListeners = new ArrayList<>();
    private ArrayList<AddRegionOwnersListener> addRegionOwnerListeners = new ArrayList<>();
    private ArrayList<AddRegionMembersListener> addRegionMembersListeners = new ArrayList<>();
    private ArrayList<RemoveRegionOwnersListener> removeRegionOwnersListeners = new ArrayList<>();
    private ArrayList<RemoveRegionMembersListener> removeRegionMembersListeners = new ArrayList<>();

    public void registerListener(CreateRegionListener listener){
        createRegionEventListeners.add(listener);
    }
    public void registerListener(RemoveRegionListener listener){
        removeRegionListeners.add(listener);
    }
    public void registerListener(SetFlagRegionListener listener){
        setFlagRegionListeners.add(listener);
    }
    public void registerListener(AddRegionOwnersListener listener){
        addRegionOwnerListeners.add(listener);
    }
    public void registerListener(AddRegionMembersListener listener){
        addRegionMembersListeners.add(listener);
    }
    public void registerListener(RemoveRegionOwnersListener listener){
        removeRegionOwnersListeners.add(listener);
    }
    public void registerListener(RemoveRegionMembersListener listener){
        removeRegionMembersListeners.add(listener);
    }

    public void call(NewRegionEvent e){
        for (CreateRegionListener listener: createRegionEventListeners){
            listener.accept(e);
        }
    }
    public void call(SetFlagRegionEvent e){
        for (SetFlagRegionListener listener: setFlagRegionListeners){
            listener.accept(e);
        }
    }
    public void call(RemoveRegionEvent e){
        for (RemoveRegionListener listener: removeRegionListeners){
            listener.accept(e);
        }
    }
    public void call(AddRegionMembersEvent e) {
        for (AddRegionMembersListener listener: addRegionMembersListeners){
            listener.accept(e);
        }
    }
    public void call(RemoveRegionMembersEvent e) {
        for (RemoveRegionMembersListener listener: removeRegionMembersListeners){
            listener.accept(e);
        }
    }
    public void call(AddRegionOwnersEvent e){
        for (AddRegionOwnersListener listener: addRegionOwnerListeners){
            listener.accept(e);
        }
    }
    public void call(RemoveRegionOwnersEvent e) {
        for (RemoveRegionOwnersListener listener: removeRegionOwnersListeners){
            listener.accept(e);
        }
    }

}
