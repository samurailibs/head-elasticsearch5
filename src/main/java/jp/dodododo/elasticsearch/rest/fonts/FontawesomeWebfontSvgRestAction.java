package jp.dodododo.elasticsearch.rest.fonts;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public class FontawesomeWebfontSvgRestAction extends FontResourceRestAction {

    @Inject
    public FontawesomeWebfontSvgRestAction(final Settings settings, final Client client, final RestController controller) {

        super(settings, client, controller, "/_plugin/head/fonts/fontawesome-webfont.svg",
            "_site/fonts/fontawesome-webfont.svg", "");
    }

}
