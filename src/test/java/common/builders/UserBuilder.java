package common.builders;

import common.models.User;

public class UserBuilder {

    private User user;

    public UserBuilder(){
        this.user = new User();
    }

    public UserBuilder withEmail(String email){
        user.setEmail(email);
        return this;
    }

    public UserBuilder withPassword(String password){
        user.setPassword(password);
        return this;
    }

    public User build(){
        return user;
    }
}
