package esprit.DevUp.FoRest.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUser {
    private static User user = null;

    public static User getCurrent(){
        return user;
    }

    public static void setCurrent(User user11){
         user=user11;
    }
}
