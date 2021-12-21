package kr.co.landfuture.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class OutCourse {

    int id;
    String description;
    String iconUrl;
    String courseListIcon;
    String longDescription;
    String category;

    public OutCourse(int id, String description, String iconUrl, String courseListIcon, String longDescription,
            String category) {
        this.id = id;
        this.description = description;
        this.iconUrl = iconUrl;
        this.courseListIcon = courseListIcon;
        this.longDescription = longDescription;
        this.category = category;
    }
}
