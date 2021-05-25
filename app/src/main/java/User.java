import android.media.Image;
import android.util.Pair;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String email;
    private String password;
    private Date dateOfBirth;
    private Image avatar; //or private String imageUrl;
    private String description;
    private Set<String> gamelist;
    private Set<String> languagesKnown;


    public void addToGames(String gameName){
        gamelist.add(gameName); //try-catch possibly?
    }
    public Set<String> returnAllGames(){
        Set<String> result = new HashSet<String>();
        result.addAll(gamelist);
        return result;
    }
}
