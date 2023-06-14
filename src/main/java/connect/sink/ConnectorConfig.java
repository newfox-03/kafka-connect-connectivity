package connect.sink;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class ConnectorConfig extends AbstractConfig {

    private enum Keys {
        ;
        static final String ENDPOINTS = "endpoints";
    }

    public static final ConfigDef CONFIG_DEF = new ConfigDef()
        .define(Keys.ENDPOINTS, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Comma-separated list of endpoints to test connectivity to.");

    final String endpoints;

    public ConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
        super(config, parsedConfig);
        endpoints = getString(Keys.ENDPOINTS);
    }

    public ConnectorConfig(Map<String, String> props) {
        this(CONFIG_DEF, props);
    }

    public static void main(String... args) {
        System.out.println(CONFIG_DEF.toRst());
    }

}
