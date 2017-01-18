package jp.dodododo.elasticsearch.rest;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class AppCssRestAction extends ResourceRestAction {

    @Inject
    public AppCssRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/app.css", "_site/app.css", "text/css");
    }
}
