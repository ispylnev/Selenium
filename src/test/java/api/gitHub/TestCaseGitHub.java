package api.gitHub;
import api.github.data.User;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertTrue;

public class TestCaseGitHub {
    @Test
    public void testUserInfo(){
        RestTemplate restTemplate = new RestTemplate();
        User user =  restTemplate.getForObject("https://api.github.com/users/ispylnev",User.class);
        assertTrue(user.getLogin().contains("ispylnev"));

    }
}
