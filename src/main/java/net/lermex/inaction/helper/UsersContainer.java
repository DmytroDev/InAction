package net.lermex.inaction.helper;

import net.lermex.inaction.model.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersContainer {
    private List<User> userList;

    public UsersContainer(){
        this.userList = createUserList();
    }

    private List<User> createUserList(){
    //private List<User> createUserList(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")); //DigestUtils.sha256Hex("admin")
        userList.add(new User("user1", DigestUtils.sha256Hex("user1")));
        userList.add(new User("incognito", DigestUtils.sha256Hex("1")));
        userList.add(new User("1", DigestUtils.sha256Hex("1")));

        return userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public boolean contains(String userName){
        boolean result = false;
        for (User user : userList) {
            if (userName.equalsIgnoreCase(user.getPassword())){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isCredentialsValid(String login, String password, List<User> users){
        if ( (login == "") || (password == "") ) {
            return false;
        }
        boolean isValid = false;
        for (User user : users) {
            if ( login.equals(user.getUsername()) ){
                if (DigestUtils.sha256Hex(password).equals(user.getPassword())){
                    isValid = true;
                    return isValid;
                }
            }
        }
        return isValid;
    }

}
