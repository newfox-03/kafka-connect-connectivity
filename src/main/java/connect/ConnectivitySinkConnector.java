package connect;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import connect.sink.ConnectivitySinkTask;
import connect.sink.ConnectorConfig;
import connect.util.Version;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConnectivitySinkConnector extends SinkConnector {

    private Map<String, String> props;

    @Override
    public Class<? extends Task> taskClass() {
        return ConnectivitySinkTask.class;
    }

    @Override
    public void start(Map<String, String> props) {
        this.props = props;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        return Collections.nCopies(maxTasks, props);
    }

    @Override
    public void stop() {
    }

    @Override
    public ConfigDef config() {
        return ConnectorConfig.CONFIG_DEF;
    }

    @Override
    public String version() {
        return Version.getVersion();
    }

}
