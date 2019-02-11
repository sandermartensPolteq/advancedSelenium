package common.builders;

import common.models.User;

public class UserBuilder {

    private User user;

    public UserBuilder(){
        this.user = new User();
    }

    public UserBuilder withFirstname(String firstname){
        user.setFirstname(firstname);
        return this;
    }

    public UserBuilder withLastname(String lastname){
        user.setLastname(lastname);
        return this;
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
