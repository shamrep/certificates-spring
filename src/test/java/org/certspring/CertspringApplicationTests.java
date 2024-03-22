package org.certspring;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CertspringApplicationTests {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void shouldReturnACustomerWhenDataIsSaved() {
    ResponseEntity<String> response = restTemplate.getForEntity("/customer/1", String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    DocumentContext documentContext = JsonPath.parse(response.getBody());
    Number id = documentContext.read("$.id");
    assertThat(id).isNotNull();

    assertThat(id).isEqualTo(1);

    String email = documentContext.read("$.email");
    assertThat(email).isEqualTo("test@email.com");
  }

  @Test
  void shouldNotReturnCustomerWithAnUnknownId() {
    ResponseEntity<String> response = restTemplate.getForEntity("/customer/1000", String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody()).isBlank();
  }



  @Test
  void contextLoads() {
  }
}
