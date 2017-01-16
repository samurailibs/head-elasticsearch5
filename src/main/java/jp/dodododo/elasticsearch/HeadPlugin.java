package jp.dodododo.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import jp.dodododo.elasticsearch.rest.AppCssRestAction;
import jp.dodododo.elasticsearch.rest.AppJsRestAction;
import jp.dodododo.elasticsearch.rest.HeadRestAction;
import jp.dodododo.elasticsearch.rest.I18nJsRestAction;
import jp.dodododo.elasticsearch.rest.VendorCssRestAction;
import jp.dodododo.elasticsearch.rest.VendorJsRestAction;
import jp.dodododo.elasticsearch.rest.base.FaviconPngRestAction;
import jp.dodododo.elasticsearch.rest.base.LoadingGifRestAction;
import jp.dodododo.elasticsearch.rest.base.ResetCssRestAction;
import jp.dodododo.elasticsearch.rest.fonts.FontAwesomeOtfRestAction;
import jp.dodododo.elasticsearch.rest.fonts.FontawesomeWebfontEotRestAction;
import jp.dodododo.elasticsearch.rest.fonts.FontawesomeWebfontSvgRestAction;
import jp.dodododo.elasticsearch.rest.fonts.FontawesomeWebfontTtfRestAction;
import jp.dodododo.elasticsearch.rest.fonts.FontawesomeWebfontWoffRestAction;
import jp.dodododo.elasticsearch.rest.lang.EnStringsJsRestAction;
import jp.dodododo.elasticsearch.rest.lang.FrStringsJsRestAction;
import jp.dodododo.elasticsearch.rest.lang.PtStringsJsRestAction;
import jp.dodododo.elasticsearch.rest.lang.TrStringsJsRestAction;
import jp.dodododo.elasticsearch.rest.lang.ZhStringsJsRestAction;

import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestHandler;

public class HeadPlugin extends Plugin implements ActionPlugin {
    public static final String NAME = HeadPlugin.class.getName();

    @Override
    public List<Class<? extends RestHandler>> getRestHandlers() {
        List<Class<? extends RestHandler>> module = new ArrayList<>();
        module.add(AppCssRestAction.class);
        module.add(AppJsRestAction.class);
        module.add(HeadRestAction.class);
        module.add(I18nJsRestAction.class);
        module.add(VendorCssRestAction.class);
        module.add(VendorJsRestAction.class);

        // base
        module.add(FaviconPngRestAction.class);
        module.add(LoadingGifRestAction.class);
        module.add(ResetCssRestAction.class);

        // fonts
        module.add(FontAwesomeOtfRestAction.class);
        module.add(FontawesomeWebfontEotRestAction.class);
        module.add(FontawesomeWebfontSvgRestAction.class);
        module.add(FontawesomeWebfontTtfRestAction.class);
        module.add(FontawesomeWebfontWoffRestAction.class);

        // lang
        module.add(EnStringsJsRestAction.class);
        module.add(FrStringsJsRestAction.class);
        module.add(PtStringsJsRestAction.class);
        module.add(TrStringsJsRestAction.class);
        module.add(ZhStringsJsRestAction.class);
        return module;
    }
}