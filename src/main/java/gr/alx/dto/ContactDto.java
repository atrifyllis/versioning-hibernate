package gr.alx.dto;

/**
 * Created by alx on 9/11/2016.
 */
public class ContactDto {

    private Long id;

    private String value;

    public ContactDto(Long id) {
        this.id = id;
    }

    public ContactDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
