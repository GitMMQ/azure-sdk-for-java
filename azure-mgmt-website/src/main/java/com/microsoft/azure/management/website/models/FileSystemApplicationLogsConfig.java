/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.14.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.website.models;


/**
 * Application logs to file system configuration.
 */
public class FileSystemApplicationLogsConfig {
    /**
     * Log level. Possible values for this property include: 'Off', 'Verbose',
     * 'Information', 'Warning', 'Error'.
     */
    private LogLevel level;

    /**
     * Get the level value.
     *
     * @return the level value
     */
    public LogLevel getLevel() {
        return this.level;
    }

    /**
     * Set the level value.
     *
     * @param level the level value to set
     */
    public void setLevel(LogLevel level) {
        this.level = level;
    }

}