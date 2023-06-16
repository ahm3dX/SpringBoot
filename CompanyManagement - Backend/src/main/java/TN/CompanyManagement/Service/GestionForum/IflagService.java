package TN.CompanyManagement.Service.GestionForum;

import TN.CompanyManagement.Entity.Forum.Flag;

import java.util.List;

public interface IflagService {

    Flag addFlag(Flag f, Integer idComment);

    Flag updateFlag(Flag f);

    Flag retrieveFlag(Integer FlagID);
    List<Flag> retrieveAllFlag();

    void removeComment(Integer FlagID);


}

