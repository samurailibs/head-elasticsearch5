package jp.dodododo.elasticsearch.rest;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class VendorJsRestAction extends ResourceRestAction {

    @Inject
    public VendorJsRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/vendor.js", "_site/vendor.js", "application/javascript");
    }
}
