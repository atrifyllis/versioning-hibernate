package gr.alx.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alx on 9/11/2016.
 */
@Entity
public class Parent implements BaseEntity {

    @Id
    @GeneratedValue
    Long id;

    @Version
    Long version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_id")
    private List<Child> children;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
