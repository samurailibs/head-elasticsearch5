package jp.dodododo.elasticsearch.rest.base;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class ResetCssRestAction extends ResourceRestAction {

    @Inject
    public ResetCssRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/base/reset.css", "_site/base/reset.css", "text/css");
    }
}
