package gr.alx.controller;


import gr.alx.dto.GrandparentDto;
import gr.alx.service.GrandParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alx on 9/11/2016.
 */
@RestController
@RequestMapping("/grandparents")
class GrandParentController {
    private GrandParentService grandParentService;

    @Autowired
    public GrandParentController(GrandParentService grandParentService) {
        this.grandParentService = grandParentService;
    }

    @GetMapping
    List<GrandparentDto> findAllGrandparents() {
        return grandParentService.findAll();
    }

    @PostMapping
    GrandparentDto save(@RequestBody GrandparentDto grandparentDto) {
        return grandParentService.save(grandparentDto);
    }
}
