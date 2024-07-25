package com.project.everything.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //Read
    @GetMapping("/data")
    public List<SetEntity> getSetList() throws Exception {
        return setService.getSetList();
    }
}
