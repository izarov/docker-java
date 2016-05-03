package com.github.dockerjava.netty.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dockerjava.api.command.ExecResizeCmd;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.netty.MediaType;
import com.github.dockerjava.netty.WebTarget;

public class ExecResizeCmdExec extends AbstrSyncDockerCmdExec<ExecResizeCmd, Void> implements
        ExecResizeCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecResizeCmdExec.class);

    public ExecResizeCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Void execute(ExecResizeCmd command) {
        WebTarget webTarget = getBaseResource().path("/exec/{id}/resize").resolveTemplate("id",
                command.getExecId());

        webTarget = webTarget.queryParam("h", String.valueOf(command.getHeight()));
        webTarget = webTarget.queryParam("w", String.valueOf(command.getWidth()));

        LOGGER.trace("POST: {}", webTarget);
        webTarget.request().accept(MediaType.APPLICATION_JSON).post(null);
        return null;
    }
}
