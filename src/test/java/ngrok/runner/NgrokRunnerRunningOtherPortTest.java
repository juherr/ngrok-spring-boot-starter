package ngrok.runner;

import ngrok.runner.config.NgrokRunnerUnixTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static ngrok.TestConstants.*;
import static ngrok.runner.config.BaseNgrokRunnerMockedConfiguration.*;
import static org.mockito.Mockito.*;

@ActiveProfiles({
        TEST_NGROK_PROFILE,
        TEST_NGROK_PROFILE_UNIX
})
@EnableAutoConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {
                TEST_NGROK_PROP_ENABLED,
                "test.running.port=8181",
        },
        classes = NgrokRunnerUnixTestConfiguration.class)
public class NgrokRunnerRunningOtherPortTest extends BaseNgrokRunnerIntegrationTest {

    @Test
    public void shouldStartTunnelsInsteadOfNgrok_whenNgrokIsAlreadyRunning() {
        verify(mockedNgrokBinaryProvider, never()).isNgrokBinaryPresent();
        verify(mockedNgrokDownloader, never()).downloadAndExtractNgrokTo(anyString());
        verify(mockedNgrokPlatformDetector, never()).isUnix();
        verify(mockedNgrokSystemCommandExecutor, never()).execute(TEST_NGROK_UNIX_CHMOD_COMMAND);
        verify(mockedNgrokSystemCommandExecutor, never()).execute(TEST_NGROK_UNIX_START_COMMAND);
        verify(mockedNgrokBinaryProvider, never()).getNgrokBinaryFilePath();
        verify(mockedNgrokApiClient, times(1)).isResponding();
        verify(mockedNgrokApiClient, times(1)).fetchTunnels(TEST_PORT_1);
        verify(mockedNgrokApiClient, times(1)).startTunnel(TEST_PORT_1, "http", "springboot-http-" + TEST_PORT_1);
        verify(mockedNgrokApiClient, times(1)).startTunnel(TEST_PORT_1, "https", "springboot-https-" + TEST_PORT_1);
    }
}
