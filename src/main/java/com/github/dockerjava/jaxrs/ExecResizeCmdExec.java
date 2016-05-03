package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.ExecResizeCmd;
import com.github.dockerjava.core.DockerClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ExecResizeCmdExec extends AbstrSyncDockerCmdExec<ExecResizeCmd, Void>
        implements ExecResizeCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecResizeCmdExec.class);

    public ExecResizeCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Void execute(ExecResizeCmd command) {
        WebTarget webResource = getBaseResource().path("/exec/{id}/resize").resolveTemplate("id",
                command.getExecId());

        webResource = webResource.queryParam("h", String.valueOf(command.getHeight()));
        webResource = webResource.queryParam("w", String.valueOf(command.getWidth()));

        LOGGER.debug("POST: {}", webResource);
        webResource.request().accept(MediaType.APPLICATION_JSON).post(null).close();

        return null;
    }

}
