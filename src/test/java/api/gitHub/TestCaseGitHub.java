package api.gitHub;
import api.github.data.User;

import api.github.data.controlGet.ControlUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCaseGitHub {
    private ControlUser controlUser;

    @Before
    public void getUser(){
         controlUser = new ControlUser();
    }

    @Test
    public void testUserInfo(){
        User user = controlUser.GetUserByName("ispylnev");
        assertTrue(user.getLogin().contains("ispylnev"));
    }
    @Test
    public void followersUser(){
        User[] followers = controlUser.getFollowersByUser("ispylnev");
//        User[]followers = controlUser.getFollowersByUser(User[].class);
        assertTrue(followers.length == 0);

    }
}
