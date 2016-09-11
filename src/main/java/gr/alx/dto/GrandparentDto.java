package gr.alx.dto;

/**
 * Created by alx on 9/11/2016.
 */
public class GrandparentDto {

    private Long id;
    private ParentDto parentDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParentDto getParentDto() {
        return parentDto;
    }

    public void setParentDto(ParentDto parentDto) {
        this.parentDto = parentDto;
    }
}
