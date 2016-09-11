package gr.alx.repository;

import gr.alx.entity.Grandparent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandParentRepository extends JpaRepository<Grandparent, Long> {

}
