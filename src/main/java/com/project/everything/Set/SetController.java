package com.project.everything.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/set")

@RestController
public class SetController {
    private final SetService setService;

    @Autowired
    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping
    public String set() {
        return "Set is Readyy";
    }

    //Create
    @PostMapping("/save")
    public SetEntity saveSet(@RequestBody SetEntity setEntity) throws Exception {
        return setService.saveSet(setEntity);
    }
    //Read
    @GetMapping("/list")
    public List<SetEntity> getSetList() throws Exception {
        return setService.getSetList();
    }
}
