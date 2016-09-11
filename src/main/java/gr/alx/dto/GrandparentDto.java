package gr.alx.dto;

/**
 * Created by alx on 9/11/2016.
 */
public class GrandparentDto {

    private Long id;
    private Long version;
    private ParentDto parentDto;

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

    public ParentDto getParentDto() {
        return parentDto;
    }

    public void setParentDto(ParentDto parentDto) {
        this.parentDto = parentDto;
    }
}
