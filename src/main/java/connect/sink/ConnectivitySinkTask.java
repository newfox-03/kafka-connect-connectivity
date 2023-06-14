package connect.sink;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connect.util.Version;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;


public class ConnectivitySinkTask extends SinkTask {

    private final Logger log = LoggerFactory.getLogger(ConnectivitySinkTask.class);

    int counter;

    private ConnectorConfig config;

    @Override
    public void start(Map<String, String> props) {
        config = new ConnectorConfig(props);

        counter = 0;

        for (String endpoint : config.endpoints.split(",")) {
            try {
                String response = Connectivity.getResponse(endpoint);
                log.info("Got response for endpoint " + endpoint + ": " + response);
            } catch (IOException e) {
                log.error("Failed to get response for endpoint " + endpoint + ". Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void put(Collection<SinkRecord> records) {
        if (records.isEmpty()) return;

        log.debug("Processing a record: " + ++counter);
    }

    @Override
    public void flush(Map<TopicPartition, OffsetAndMetadata> offsets) {
    }

    @Override
    public void stop() {
    }

    @Override
    public String version() {
        return Version.getVersion();
    }

}
