package ngrok;

import ngrok.configuration.NgrokConfiguration;

public interface TestConstants {
    int TEST_PORT_1 = 8080;
    int TEST_PORT_2 = 8081;

    String TEST_NGROK_PROP_ENABLED = NgrokConfiguration.NGROK_ENABLED + "=true";
    String TEST_NGROK_PROP_CUSTOM_CONFIG = "ngrok.config=/ngrok-config.yml";
    String TEST_NGROK_PROP_CUSTOM_COMMAND = "ngrok.command=http " + TEST_PORT_2;
    String TEST_SPRING_PROP_SERVER_PORT = "server.port=" + TEST_PORT_2;

    String TEST_NGROK_PROFILE = "test";
    String TEST_NGROK_PROFILE_WINDOWS = "test-windows";
    String TEST_NGROK_PROFILE_UNIX = "test-unix";

    String TEST_NGROK_API_URL = "http://mocked-ngrok-api-url:1234";
    String TEST_NGROK_TUNNELS_FILE_PATH = "/tunnels.json";

    String TEST_NGROK_WINDOWS_DEFAULT_DIR = "C:\\Users\\user\\.ngrok2";
    String TEST_NGROK_WINDOWS_BINARY_PATH = "C:\\Users\\user\\.ngrok2\\ngrok.exe";
    String TEST_NGROK_WINDOWS_START_COMMAND = TEST_NGROK_WINDOWS_BINARY_PATH + " http " + TEST_PORT_1;

    String TEST_NGROK_UNIX_DEFAULT_DIR = "/home/user/.ngrok2";
    String TEST_NGROK_UNIX_BINARY_PATH = "/home/user/.ngrok2/ngrok";
    String TEST_NGROK_UNIX_CHMOD_COMMAND = "chmod +x " + TEST_NGROK_UNIX_BINARY_PATH;
    String TEST_NGROK_UNIX_START_COMMAND = TEST_NGROK_UNIX_BINARY_PATH + " http " + TEST_PORT_1;
    String TEST_NGROK_UNIX_START_COMMAND_WITH_CONFIG = TEST_NGROK_UNIX_BINARY_PATH + " http -config /ngrok-config.yml " + TEST_PORT_1;
    String TEST_NGROK_UNIX_START_CUSTOM_COMMAND = TEST_NGROK_UNIX_BINARY_PATH + " http " + TEST_PORT_2;
}
