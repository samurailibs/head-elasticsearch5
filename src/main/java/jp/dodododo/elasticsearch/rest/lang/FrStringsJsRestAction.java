package jp.dodododo.elasticsearch.rest.lang;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class FrStringsJsRestAction extends ResourceRestAction {

    @Inject
    public FrStringsJsRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/lang/fr_strings.js", "_site/lang/fr_strings.js",
            "application/javascript");
    }
}
