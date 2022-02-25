package pl.comarch.szkolenia.rest.clinet;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        /*** GET ***/
        String URL = "http://localhost:8080/user/2";

        UserDTO user = restTemplate.getForObject(URL, UserDTO.class, new HashMap<>());

        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getAddress());

        /*** POST ***/
        String URL2 = "http://localhost:8080/user/";

        Address address = new Address(10, "Ogrodowa", "13", "23-234", "Warszawa");
        User user1 = new User(5, "zbyszek", "zbyszek123", address);

        User user2 = restTemplate.postForObject(URL2, user1, User.class, new HashMap<>());

        System.out.println("------------------------------------");
        System.out.println(user2.getId());
        System.out.println(user2.getLogin());
        System.out.println(user2.getPassword());
        System.out.println(user2.getAddress().getId());
        System.out.println(user2.getAddress().getStreet());
        System.out.println(user2.getAddress().getNo());
        System.out.println(user2.getAddress().getCode());
        System.out.println(user2.getAddress().getCity());

        /*** HttpEntity ***/

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header1", "jakasWartosc");

        HttpEntity<User> request = new HttpEntity<>(user1, httpHeaders);

        ResponseEntity<User> response = restTemplate.exchange(URL2, HttpMethod.POST, request, User.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().getLogin());
    }
}
