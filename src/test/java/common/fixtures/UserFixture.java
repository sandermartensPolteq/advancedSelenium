package common.fixtures;

import common.builders.UserBuilder;
import common.models.User;

public class UserFixture {

    public static User defaultUser(){
        return new UserBuilder()
                .withFirstname("Firstname")
                .withLastname("lastName")
                .withEmail("sander.martens+webshop1@polteq.com")
                .withPassword("dfsdfs")
                .build();
    }
}
