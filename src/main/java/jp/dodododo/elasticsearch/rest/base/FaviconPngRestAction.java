package jp.dodododo.elasticsearch.rest.base;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class FaviconPngRestAction extends ResourceRestAction {

    @Inject
    public FaviconPngRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/base/favicon.png", "_site/base/favicon.png", "image/png");
    }
}
