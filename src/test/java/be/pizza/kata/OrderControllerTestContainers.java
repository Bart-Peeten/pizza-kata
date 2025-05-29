package be.pizza.kata;

import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderControllerTestContainers {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @Autowired
    private DataSource dataSource;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PizzaOrderRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void shouldUsePostgresContainer() throws Exception {
        String jdbcUrl = dataSource.getConnection()
                .getMetaData()
                .getURL();
        System.out.println("JDBC URL = " + jdbcUrl);
        assertThat(jdbcUrl).contains("jdbc:postgresql");
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void order_shouldReturnOrderIdAndEstimatedTime() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = "{ \"pizza\": \"MARGHERITA\", \"size\": \"MEDIUM\" }";
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("/order", entity, Map.class);
        final String orderId = (String)response.getBody()
                .get("orderId");
        final Optional<PizzaOrder> savedPizzaOrder = repository.findById(UUID.fromString((orderId)));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsKeys("orderId", "estimatedTime");
        assertThat(response.getBody()
                .get("estimatedTime")).isEqualTo("20 minutes");
        assertThat(orderId).isNotNull();
        assertThat(savedPizzaOrder).isPresent();
    }
}
