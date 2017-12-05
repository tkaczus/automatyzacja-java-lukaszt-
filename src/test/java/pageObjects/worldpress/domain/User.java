package pageObjects.worldpress.domain;

import java.util.UUID;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-05.
 */
public class User {
    private String comment=UUID.randomUUID().toString().substring(1,20);
    private String email="wxxxp@wp.pl";
    private String name= getComment().substring(1,5);
    private String website="https://www.wp.pl/";

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
