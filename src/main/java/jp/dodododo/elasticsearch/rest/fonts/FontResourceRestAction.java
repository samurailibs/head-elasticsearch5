package jp.dodododo.elasticsearch.rest.fonts;

import java.util.HashSet;
import java.util.Set;

import jp.dodododo.elasticsearch.rest.ResourceRestAction;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;

public abstract class FontResourceRestAction extends ResourceRestAction {

    public FontResourceRestAction(final Settings settings, final Client client, final RestController controller,
        final String urlPath, final String resourcePath, final String mimeType) {

        super(settings, client, controller, urlPath, resourcePath, mimeType);
    }

    @Override
    protected Set<String> responseParams() {
        Set<String> ret = new HashSet<>();
        ret.add("v");
        return ret;
    }
}
