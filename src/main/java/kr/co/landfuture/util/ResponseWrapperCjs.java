package kr.co.landfuture.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/*
    json 작성 시 바깥쪽에 덧 붙여야 하는 것이 있다면 - 이것을 이용
*/
@JsonAutoDetect(fieldVisibility = Visibility.ANY) // class의 parameters를 외부에 보이게 한다. @Getter등을 대체함
public class ResponseWrapperCjs<T> {

    private T payload;

    public ResponseWrapperCjs(T payload) {
        this.payload = payload;
    }
}
