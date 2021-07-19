package live.moku.search.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "ht-doc")
public class HtDocDto {

    public HtDocDto(String id, String path, String message) {
        this.path = path;
        this.message = message;
        this.id = id;
    }

    @Id
    @Field(name = "_id")
    private String id;

    @Field
    private String path;

    @Field
    private String message;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HtDocDto{" +
                "_id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
