package gr.alx;

import gr.alx.entity.Child;
import gr.alx.entity.Contact;
import gr.alx.entity.Grandparent;
import gr.alx.entity.Parent;
import gr.alx.repository.GrandParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alx on 9/11/2016.
 */
@Component
class DbInitializer implements CommandLineRunner {

    private GrandParentRepository grandParentRepository;

    @Autowired
    public DbInitializer(GrandParentRepository grandParentRepository) {
        this.grandParentRepository = grandParentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Grandparent grandparent = new Grandparent();
        Parent parent = new Parent();
        List<Child> children = Arrays.asList(new Child("alex", new Contact("c1")), new Child("penny", new Contact("c1")), new Child("other", new Contact("c1")));
        parent.setChildren(children);
        grandparent.setParent(parent);

        grandParentRepository.save(grandparent);
    }
}
