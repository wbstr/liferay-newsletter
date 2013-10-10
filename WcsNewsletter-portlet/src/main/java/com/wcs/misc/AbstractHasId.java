package com.wcs.misc;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 Webstar Csoport Kft.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 *
 * @author kumm
 */
public abstract class AbstractHasId<T> implements HasId<T> {

    @Override
    public abstract T getId();

    @Override
    public abstract void setId(T id);

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object==null || getClass() != object.getClass()) {
            return false;
        }
        AbstractHasId other = (AbstractHasId) object;
        if (isNew() || other.isNew()) {
            return false;
        }
        return this.getId().equals(other.getId());
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[id=" + getId() + "]";
    }

    public boolean isNew() {
        return getId() == null;
    }
}
