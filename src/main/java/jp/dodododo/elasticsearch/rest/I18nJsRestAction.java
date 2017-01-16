package jp.dodododo.elasticsearch.rest;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class I18nJsRestAction extends ResourceRestAction {

    @Inject
    public I18nJsRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/i18n.js", "_site/i18n.js", "application/javascript");
    }
}
