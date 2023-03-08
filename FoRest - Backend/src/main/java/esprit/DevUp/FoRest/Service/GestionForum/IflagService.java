package esprit.DevUp.FoRest.Service.GestionForum;

import esprit.DevUp.FoRest.Entity.Forum.Flag;

import java.util.List;

public interface IflagService {

    Flag addFlag(Flag f, Integer idComment);

    Flag updateFlag(Flag f);

    Flag retrieveFlag(Integer FlagID);
    List<Flag> retrieveAllFlag();

    void removeComment(Integer FlagID);


}

