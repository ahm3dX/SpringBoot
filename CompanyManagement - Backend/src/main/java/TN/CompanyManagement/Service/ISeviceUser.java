package TN.CompanyManagement.Service;

import TN.CompanyManagement.Entity.User;

import java.util.List;


public interface ISeviceUser {
    List<User> retrieveAllUsers();

    User addUser (User u);

    User updateUser (User u);

    User retrieveUser(Integer idUser);

    void removeUser(Integer idUser);
}
