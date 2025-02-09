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

import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import javax.annotation.Nullable;


public class SetFlagRegionEvent {
    private final ProtectedRegion region;
    private final String flagName;
    private final String value;
    private final RegionManager regionManager;


    public SetFlagRegionEvent(final ProtectedRegion region, String flagName, @Nullable String value, RegionManager regionManager){
        this.region   = region;
        this.flagName = flagName;
        this.value    = value;
        this.regionManager = regionManager;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public String getFlagName() {
        return flagName;
    }

    public String getValue() {
        return value;
    }

    public ProtectedRegion getRegion(){
        return this.region;
    }
}
