package com.github.dockerjava.api.command;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.github.dockerjava.api.exception.NotFoundException;

public interface ExecResizeCmd extends SyncDockerCmd<Void> {

    @CheckForNull
    String getExecId();

    @CheckForNull
    String getHeight();

    @CheckForNull
    String getWidth();

    ExecResizeCmd withExecId(@Nonnull String execId);
    ExecResizeCmd withHeight(@Nonnull String height);
    ExecResizeCmd withWidth(@Nonnull String width);

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    Void exec() throws NotFoundException;

    interface Exec extends DockerCmdSyncExec<ExecResizeCmd, Void> {
    }
}
