package com.github.dockerjava.api.command;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.github.dockerjava.api.exception.NotFoundException;

public interface ResizeContainerCmd extends SyncDockerCmd<Void> {

    @CheckForNull
    public String getContainerId();

    @CheckForNull
    public String getHeight();

    @CheckForNull
    public String getWidth();

    public ResizeContainerCmd withContainerId(@Nonnull String containerId);
    public ResizeContainerCmd withHeight(@Nonnull String height);
    public ResizeContainerCmd withWidth(@Nonnull String width);

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException;

    public static interface Exec extends DockerCmdSyncExec<ResizeContainerCmd, Void> {
    }
}
