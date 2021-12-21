package kr.co.landfuture.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class OutJobtype {
    int id;
    String description;
    String iconUrl;
    String courseListIcon;
    String longDescription;
    String category;
    int jobtypesCount;

    public OutJobtype() {
    }

    public OutJobtype(int id, String description, String iconUrl, String courseListIcon, String longDescription,
            String category, int jobtypesCount) {
        this.id = id;
        this.description = description;
        this.iconUrl = iconUrl;
        this.courseListIcon = courseListIcon;
        this.longDescription = longDescription;
        this.category = category;
        this.jobtypesCount = jobtypesCount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getCourseListIcon() {
        return courseListIcon;
    }

    public void setCourseListIcon(String courseListIcon) {
        this.courseListIcon = courseListIcon;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getJobtypesCount() {
        return jobtypesCount;
    }

    public void setJobtypesCount(int jobtypesCount) {
        this.jobtypesCount = jobtypesCount;
    }
}
