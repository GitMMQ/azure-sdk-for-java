/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.implementation.api;

import org.joda.time.DateTime;

/**
 * Information about an Azure Batch subtask.
 */
public class SubtaskInformation {
    /**
     * Gets or sets the id of the subtask.
     */
    private Integer id;

    /**
     * Gets or sets information about the compute node on which the subtask
     * ran.
     */
    private ComputeNodeInformation nodeInfo;

    /**
     * Gets or sets the time at which the subtask started running. If the
     * subtask has been restarted or retried, this is the most recent time at
     * which the subtask started running.
     */
    private DateTime startTime;

    /**
     * Gets or sets the time at which the subtask completed. This property is
     * set only if the subtask is in the Completed state.
     */
    private DateTime endTime;

    /**
     * Gets or sets the exit code of the subtask. This property is set only if
     * the subtask is in the Completed state.
     */
    private Integer exitCode;

    /**
     * Gets or sets details of any error encountered scheduling the subtask.
     */
    private TaskSchedulingError schedulingError;

    /**
     * Gets or sets the current state of the subtask. Possible values include:
     * 'active', 'preparing', 'running', 'completed'.
     */
    private TaskState state;

    /**
     * Gets or sets the time at which the subtask entered its current state.
     */
    private DateTime stateTransitionTime;

    /**
     * Gets or sets the previous state of the subtask. This property is not
     * set if the subtask is in its initial Active state. Possible values
     * include: 'active', 'preparing', 'running', 'completed'.
     */
    private TaskState previousState;

    /**
     * Gets or sets the time at which the subtask entered its previous state.
     * This property is not set if the subtask is in its initial Active state.
     */
    private DateTime previousStateTransitionTime;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public Integer id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get the nodeInfo value.
     *
     * @return the nodeInfo value
     */
    public ComputeNodeInformation nodeInfo() {
        return this.nodeInfo;
    }

    /**
     * Set the nodeInfo value.
     *
     * @param nodeInfo the nodeInfo value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setNodeInfo(ComputeNodeInformation nodeInfo) {
        this.nodeInfo = nodeInfo;
        return this;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime value.
     *
     * @param startTime the startTime value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime value.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the endTime value.
     *
     * @param endTime the endTime value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the exitCode value.
     *
     * @return the exitCode value
     */
    public Integer exitCode() {
        return this.exitCode;
    }

    /**
     * Set the exitCode value.
     *
     * @param exitCode the exitCode value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    /**
     * Get the schedulingError value.
     *
     * @return the schedulingError value
     */
    public TaskSchedulingError schedulingError() {
        return this.schedulingError;
    }

    /**
     * Set the schedulingError value.
     *
     * @param schedulingError the schedulingError value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setSchedulingError(TaskSchedulingError schedulingError) {
        this.schedulingError = schedulingError;
        return this;
    }

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public TaskState state() {
        return this.state;
    }

    /**
     * Set the state value.
     *
     * @param state the state value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setState(TaskState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the stateTransitionTime value.
     *
     * @return the stateTransitionTime value
     */
    public DateTime stateTransitionTime() {
        return this.stateTransitionTime;
    }

    /**
     * Set the stateTransitionTime value.
     *
     * @param stateTransitionTime the stateTransitionTime value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setStateTransitionTime(DateTime stateTransitionTime) {
        this.stateTransitionTime = stateTransitionTime;
        return this;
    }

    /**
     * Get the previousState value.
     *
     * @return the previousState value
     */
    public TaskState previousState() {
        return this.previousState;
    }

    /**
     * Set the previousState value.
     *
     * @param previousState the previousState value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setPreviousState(TaskState previousState) {
        this.previousState = previousState;
        return this;
    }

    /**
     * Get the previousStateTransitionTime value.
     *
     * @return the previousStateTransitionTime value
     */
    public DateTime previousStateTransitionTime() {
        return this.previousStateTransitionTime;
    }

    /**
     * Set the previousStateTransitionTime value.
     *
     * @param previousStateTransitionTime the previousStateTransitionTime value to set
     * @return the SubtaskInformation object itself.
     */
    public SubtaskInformation setPreviousStateTransitionTime(DateTime previousStateTransitionTime) {
        this.previousStateTransitionTime = previousStateTransitionTime;
        return this;
    }

}