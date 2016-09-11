package gr.alx.entity;

/**
 * Created by alx on 9/11/2016.
 */
public interface BaseEntity extends Identifiable {

    Long getVersion();

    void setVersion(Long version);
}
