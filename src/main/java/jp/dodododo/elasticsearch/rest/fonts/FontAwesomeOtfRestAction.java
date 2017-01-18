package jp.dodododo.elasticsearch.rest.fonts;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class FontAwesomeOtfRestAction extends FontResourceRestAction {

    @Inject
    public FontAwesomeOtfRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/fonts/FontAwesome.otf", "_site/fonts/FontAwesome.otf", "");
    }

}
