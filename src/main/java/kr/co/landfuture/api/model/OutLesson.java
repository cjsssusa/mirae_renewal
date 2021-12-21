package kr.co.landfuture.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class OutLesson {

    int id;
    String description;
    String duration;
    int seqNo;
    int courseId;

    public OutLesson(int id, String description, String duration, int seqNo, int courseId) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.seqNo = seqNo;
        this.courseId = courseId;
    }
}
