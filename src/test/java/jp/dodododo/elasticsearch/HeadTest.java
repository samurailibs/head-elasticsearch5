package jp.dodododo.elasticsearch;

import static org.codelibs.elasticsearch.runner.ElasticsearchClusterRunner.*;
import static org.codelibs.elasticsearch.runner.net.Curl.*;
import static org.junit.Assert.*;

import org.codelibs.elasticsearch.runner.ElasticsearchClusterRunner;
import org.elasticsearch.node.Node;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HeadTest {
    private static ElasticsearchClusterRunner runner;

    @BeforeClass
    public static void setup() throws Exception {
        runner = new ElasticsearchClusterRunner();
        runner.onBuild((number, settingsBuilder) -> {
            settingsBuilder.put("http.cors.enabled", true);
            settingsBuilder.put("discovery.zen.ping.unicast.hosts", "localhost:9301-9399");
        }).build(newConfigs().numOfNode(3).clusterName("HeadTest").baseHttpPort(9250).pluginTypes(HeadPlugin.NAME));
    }

    @AfterClass
    public static void close() throws Exception {
        runner.clean();
        runner.close();
    }

    @Test
    public void test() throws Exception {
        Node node = runner.getNode(0);
        assertEquals(200, get(node, "/_plugin/head/").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/app.css").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/app.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/i18n.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/vendor.css").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/vendor.js").execute().getHttpStatusCode());

        assertEquals(200, get(node, "/_plugin/head/base/favicon.png").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/base/loading.gif").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/base/reset.css").execute().getHttpStatusCode());

        assertEquals(200, get(node, "/_plugin/head/fonts/fontawesome-webfont.eot?v=4").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/fonts/fontawesome-webfont.svg?v=4").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/fonts/fontawesome-webfont.ttf?v=4").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/fonts/fontawesome-webfont.woff?v=4").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/fonts/FontAwesome.otf?v=4").execute().getHttpStatusCode());

        assertEquals(200, get(node, "/_plugin/head/lang/en_strings.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/lang/fr_strings.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/lang/pt_strings.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/lang/tr_strings.js").execute().getHttpStatusCode());
        assertEquals(200, get(node, "/_plugin/head/lang/zh_strings.js").execute().getHttpStatusCode());
    }

}
