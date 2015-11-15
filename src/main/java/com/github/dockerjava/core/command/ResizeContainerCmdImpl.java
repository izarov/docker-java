package com.github.dockerjava.core.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.ResizeContainerCmd;

/**
 * Inspect the details of a container.
 */
public class  ResizeContainerCmdImpl extends AbstrDockerCmd<ResizeContainerCmd, Void> implements
        ResizeContainerCmd {

    private String containerId;
    private String height;
    private String width;

    public ResizeContainerCmdImpl(ResizeContainerCmd.Exec exec, String containerId, String height, String width) {
        super(exec);
        withContainerId(containerId);
        withHeight(height);
        withWidth(width);
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public String getWidth() {
        return width;
    }

    @Override
    public ResizeContainerCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public ResizeContainerCmd withHeight(String height) {
        checkNotNull(containerId, "containerId was not specified");
        this.height = height;
        return this;
    }

    @Override
    public ResizeContainerCmd withWidth(String width) {
        checkNotNull(containerId, "containerId was not specified");
        this.width = width;
        return this;
    }

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException {
        return super.exec();
    }
}
