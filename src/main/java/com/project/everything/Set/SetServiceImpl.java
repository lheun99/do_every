package com.project.everything.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;

    @Autowired
    public SetServiceImpl(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Override
    public List<SetEntity> getSetList() throws Exception {
        return setRepository.findAll();
    }
}
