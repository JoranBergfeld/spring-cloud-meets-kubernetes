package com.joranbergfeld.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.joranbergfeld.userservice.user.CreateUserRequest;
import com.joranbergfeld.userservice.user.UserResponse;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CreateUserITTest {

    @LocalServerPort
    private int port;

    @Test
    void testCreateUser() {
        // setup
        RestTemplate restTemplate = new RestTemplate();
        CreateUserRequest request = new CreateUserRequest();
        final String email = "test@example.com";
        request.setEmail(email);

        ResponseEntity<UserResponse> userResponseResponseEntity = restTemplate
            .postForEntity("http://localhost:" + port + "/user", request, UserResponse.class, Collections.emptyMap());

        assertEquals(userResponseResponseEntity.getStatusCodeValue(), 201, "Should return 201 CREATED status.");

        UserResponse userCreationBody = userResponseResponseEntity.getBody();
        assertNotNull(userCreationBody, "Should have returned body.");

        final long userId = userCreationBody.getId();
        ResponseEntity<UserResponse> queryUserEntity = restTemplate
            .getForEntity("http://localhost:" + port + "/user/" + userId, UserResponse.class,
                Collections.emptyMap());
        assertEquals(queryUserEntity.getStatusCodeValue(), 200, "Should return 200 OK status.");

        UserResponse queryUserBody = queryUserEntity.getBody();
        assertNotNull(queryUserBody, "Should have returned body.");
        assertEquals(email, queryUserBody.getEmail(), "Should have same email as requested to create.");
    }

}
