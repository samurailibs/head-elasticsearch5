package jp.dodododo.elasticsearch.rest;

import static org.elasticsearch.rest.RestRequest.Method.GET;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.io.Streams;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;

public abstract class ResourceRestAction extends BaseRestHandler {

    protected String urlPath;
    protected String resourcePath;
    protected byte[] resource;
    protected String mimeType;

    public ResourceRestAction(final Settings settings, final Client client, final RestController controller,
        final String urlPath, final String resourcePath, final String mimeType) {

        super(settings);
        this.resource = getResouce(resourcePath, this.getClass());
        this.mimeType = mimeType;

        controller.registerHandler(GET, urlPath, this);
    }

    @Override
    protected RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        return new RestChannelConsumer() {
            @Override
            public void accept(RestChannel channel) throws Exception {
                try {
                    channel.sendResponse(new BytesRestResponse(RestStatus.OK, mimeType, resource));
                } catch (RuntimeException e) {
                    logger.error("failed to send failure response", e);
                    sendErrorResponse(channel, e);
                }
            }
        };
    }

    protected void sendErrorResponse(final RestChannel channel, final Exception cause) {
        try {
            final BytesRestResponse restResponse = new BytesRestResponse(channel, cause);
            channel.sendResponse(restResponse);
        } catch (final Throwable t) {
            logger.error("failed to send failure response", t);
        }
    }

    private static byte[] getResouce(final String resourcePath, final Class<?> baseClass) {
        try (
            InputStream is = new BufferedInputStream(ResourceRestAction.class.getClassLoader().getResourceAsStream(
                resourcePath), 4096)) {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Streams.copy(is, out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
