package com.github.dockerjava.api.command;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.github.dockerjava.api.exception.NotFoundException;

public interface ResizeContainerCmd extends SyncDockerCmd<Void> {

    @CheckForNull
    String getContainerId();

    @CheckForNull
    String getHeight();

    @CheckForNull
    String getWidth();

    ResizeContainerCmd withContainerId(@Nonnull String containerId);
    ResizeContainerCmd withHeight(@Nonnull String height);
    ResizeContainerCmd withWidth(@Nonnull String width);

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    Void exec() throws NotFoundException;

    interface Exec extends DockerCmdSyncExec<ResizeContainerCmd, Void> {
    }
}
