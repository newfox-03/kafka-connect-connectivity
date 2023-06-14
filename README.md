**kafka-connect-connectivity** is a `Kafka Sink Connector <http://kafka.apache.org/documentation.html#connect>`_ for testing connectivity between Kafka Connect and other networks.

Building
========

To create an uber JAR::

    $ mvn -P standalone clean package

The uber JAR will be created at ``target/kafka-connect-connectivity-$version-SNAPSHOT-standalone.jar``.


Example configuration
=====================

Use any existing topic that to prevent error and set a comma-separated list of endpoints for testing connectivity::

    name=connectivity-test
    connector.class=connect.ConnectivitySinkConnector
    tasks.max=1
    topics=topic
    endpoints=http://localhost:80,https://localhost:443