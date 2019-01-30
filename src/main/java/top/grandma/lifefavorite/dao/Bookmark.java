package top.grandma.lifefavorite.dao;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bookmark {

    private int id;
    private String title;
    private String link;
    private String description;

    public Bookmark(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

}
