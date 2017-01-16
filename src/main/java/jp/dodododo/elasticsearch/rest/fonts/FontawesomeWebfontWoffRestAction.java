package jp.dodododo.elasticsearch.rest.fonts;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class FontawesomeWebfontWoffRestAction extends FontResourceRestAction {

    @Inject
    public FontawesomeWebfontWoffRestAction(final Settings settings, final Client client,
        final RestController controller) {

        super(settings, client, controller, "/_plugin/head/fonts/fontawesome-webfont.woff",
            "_site/fonts/fontawesome-webfont.woff", "");
    }
}
