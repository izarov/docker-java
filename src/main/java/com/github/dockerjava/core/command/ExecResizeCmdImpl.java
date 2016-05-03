package com.github.dockerjava.core.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.command.ExecResizeCmd;

/**
 * Inspect the details of a container.
 */
public class  ExecResizeCmdImpl extends AbstrDockerCmd<ExecResizeCmd, Void> implements
        ExecResizeCmd {

    private String execId;
    private String height;
    private String width;

    public ExecResizeCmdImpl(ExecResizeCmd.Exec exec, String execId, String height, String width) {
        super(exec);
        withExecId(execId);
        withHeight(height);
        withWidth(width);
    }

    @Override
    public String getExecId() {
        return execId;
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
    public ExecResizeCmd withExecId(String execId) {
        checkNotNull(execId, "execId was not specified");
        this.execId = execId;
        return this;
    }

    @Override
    public ExecResizeCmd withHeight(String height) {
        checkNotNull(height, "height was not specified");
        this.height = height;
        return this;
    }

    @Override
    public ExecResizeCmd withWidth(String width) {
        checkNotNull(width, "width was not specified");
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
