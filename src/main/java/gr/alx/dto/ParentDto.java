package gr.alx.dto;

import java.util.List;

/**
 * Created by alx on 9/11/2016.
 */
public class ParentDto {

    private Long id;
    private Long version;
    private List<ChildDto> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<ChildDto> getChildren() {
        return children;
    }

    public void setChildren(List<ChildDto> children) {
        this.children = children;
    }
}
