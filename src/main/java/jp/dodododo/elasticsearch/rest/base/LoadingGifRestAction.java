package jp.dodododo.elasticsearch.rest.base;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class LoadingGifRestAction extends ResourceRestAction {

    @Inject
    public LoadingGifRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/base/loading.gif", "_site/base/loading.gif", "image/gif");
    }
}
