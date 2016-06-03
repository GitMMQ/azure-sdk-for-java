/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for AzureResourceType.
 */
public enum AzureResourceType {
    /** Enum value Website. */
    WEBSITE("Website"),

    /** Enum value TrafficManager. */
    TRAFFIC_MANAGER("TrafficManager");

    /** The actual serialized value for a AzureResourceType instance. */
    private String value;

    AzureResourceType(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a AzureResourceType instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a AzureResourceType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed AzureResourceType object, or null if unable to parse.
     */
    @JsonCreator
    public static AzureResourceType fromValue(String value) {
        AzureResourceType[] items = AzureResourceType.values();
        for (AzureResourceType item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toValue();
    }
}