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

import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RemoveRegionOwnersEvent {
    private final ProtectedRegion region;
    private final DefaultDomain owners;
    private final RegionManager regionManager;
    public RemoveRegionOwnersEvent(ProtectedRegion region, DefaultDomain owners, RegionManager regionManager){
        this.region = region;
        this.owners = owners;
        this.regionManager = regionManager;
    }


    public RegionManager getRegionManager() {
        return regionManager;
    }

    public ProtectedRegion getRegion() {
        return region;
    }

    public DefaultDomain getOwners() {
        return owners;
    }
}
