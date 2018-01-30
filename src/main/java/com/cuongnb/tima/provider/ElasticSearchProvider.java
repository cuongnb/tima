package com.cuongnb.tima.provider;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * created by cuongnb on 29/01/2018
 */
public class ElasticSearchProvider {
    public static TransportClient getClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "tima_logging").build();
        return new PreBuiltTransportClient(settings);
    }

    public static void main(String[] args) {
        TransportClient client = getClient();
        System.out.println(client.listedNodes());
    }

    public static void index(String index, String type, String id) {

    }
}
