package api.github.data.controlGet;

import api.github.data.User;
import org.springframework.web.client.RestTemplate;

import static api.github.data.Constants.API_BASE;

public class ControlUser {
    private RestTemplate restTemplate;

    public ControlUser(){
         restTemplate = new RestTemplate();
    }

    public User GetUserByName(String nameUser) {
       User user = restTemplate.getForObject(API_BASE +"users/" + nameUser , User.class);
      return user;

    }

//    public <T> T getFollowersByUser(Class <?> clazz){
    public User[] getFollowersByUser(String nameUser){
//        Object object = restTemplate.getForObject(API_BASE + "followers/" , clazz.getClass());
//        String s="s";
//        return (T) object;
        User[] user = restTemplate.getForObject(API_BASE + nameUser + "/followers/" ,User[].class);
        return user;
    }

}
