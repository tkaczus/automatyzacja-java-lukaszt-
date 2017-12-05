package pageObjects.worldpress.domain;

import java.util.UUID;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-05.
 */
public class Comment {
    private String comment = UUID.randomUUID().toString().substring(1, 20);
    private String email = "wxxxp@wp.pl";
    private String name = getComment().substring(1, 5);
    private String website = "https://www.wp.pl/";

    public String getComment() {
        return comment;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "User{" +
                "comment='" + comment + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
