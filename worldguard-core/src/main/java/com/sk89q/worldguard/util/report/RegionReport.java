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

package com.sk89q.worldguard.util.report;

import com.sk89q.worldedit.util.report.DataReport;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

/**
 * Reports on a region.
 */
public class RegionReport extends DataReport {

    public RegionReport(ProtectedRegion region) {
        super("Регион: " + region.getId());

        append("Тип", region.getType());
        append("Приоритет", region.getPriority());
        append("Родитель", region.getParent() == null ? "<none>" : region.getParent().getId());
        append("Владельцы", region.getOwners());
        append("Участники", region.getMembers());
        append("Флаги", region.getFlags());
        append("Границы", region.getMinimumPoint() + " -> " + region.getMaximumPoint());
    }

}
