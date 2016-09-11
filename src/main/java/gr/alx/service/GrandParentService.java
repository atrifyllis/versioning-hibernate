package gr.alx.service;

import gr.alx.dto.ChildDto;
import gr.alx.dto.GrandparentDto;
import gr.alx.dto.ParentDto;
import gr.alx.entity.Child;
import gr.alx.entity.Grandparent;
import gr.alx.entity.Parent;
import gr.alx.repository.GrandParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by alx on 9/11/2016.
 */
@Service
public class GrandParentService {

    private GrandParentRepository grandParentRepository;

    @Autowired
    public GrandParentService(GrandParentRepository grandParentRepository) {
        this.grandParentRepository = grandParentRepository;
    }

    public GrandparentDto save(GrandparentDto grandparentDto) {
        Grandparent grandparent = mapToEntity(grandparentDto);
        Grandparent updatedGrandparent = grandParentRepository.save(grandparent);
        return mapToDto(updatedGrandparent);
    }

    private Grandparent mapToEntity(GrandparentDto grandparentDto) {
        Grandparent grandparent = grandParentRepository.findOne(grandparentDto.getId());
        if (grandparent == null) {
            grandparent = new Grandparent();
        }

        Parent newParent = grandparent.getParent() != null ? grandparent.getParent() : new Parent();

        List<Child> newChildren = new ArrayList<>();
        grandparentDto.getParentDto().getChildren().stream().forEach(childDto -> {
            Child child = mapToChildEntity(childDto, newParent.getChildren());
            newChildren.add(child);
        });
        newParent.getChildren().clear();
        newParent.getChildren().addAll(newChildren);
        grandparent.setParent(newParent);

        return grandparent;
    }

    private Child mapToChildEntity(ChildDto childDto, List<Child> children) {
        Optional<Child> optionalChild = children.stream()
                .filter(child -> child.getId().equals(childDto.getId()))
                .findFirst();
        Child child = optionalChild.orElse(new Child());
        child.setName(childDto.getName());
        return child;
    }


    private GrandparentDto mapToDto(Grandparent updatedGrandparent) {
        GrandparentDto grandparentDto = new GrandparentDto();
        grandparentDto.setId(updatedGrandparent.getId());

        ParentDto parentDto = new ParentDto();
        parentDto.setId(updatedGrandparent.getParent().getId());

        List<ChildDto> childDtos = updatedGrandparent.getParent().getChildren().stream()
                .map(child -> {
                    ChildDto childDto = new ChildDto();
                    childDto.setId(child.getId());
                    childDto.setName(child.getName());
                    return childDto;
                })
                .collect(toList());
        parentDto.setChildren(childDtos);
        grandparentDto.setParentDto(parentDto);

        return grandparentDto;
    }

    public List<GrandparentDto> findAll() {
        return grandParentRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(toList());
    }
}
