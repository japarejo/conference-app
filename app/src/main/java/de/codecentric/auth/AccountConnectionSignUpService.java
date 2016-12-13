package de.codecentric.auth;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import de.codecentric.dao.UsersDao;

public class AccountConnectionSignUpService implements ConnectionSignUp {

    private final UsersDao usersDao;

    public AccountConnectionSignUpService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
	public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        usersDao.createUser(profile.getUsername());
        return profile.getUsername();
    }

}
