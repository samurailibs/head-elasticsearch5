package jp.dodododo.elasticsearch.rest;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class AppJsRestAction extends ResourceRestAction {

    @Inject
    public AppJsRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/app.js", "_site/app.js", "application/javascript");
    }
}
