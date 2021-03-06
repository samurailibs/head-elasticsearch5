package jp.dodododo.elasticsearch.rest.lang;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class PtStringsJsRestAction extends ResourceRestAction {

    @Inject
    public PtStringsJsRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/lang/pt_strings.js", "_site/lang/pt_strings.js",
            "application/javascript");
    }
}
