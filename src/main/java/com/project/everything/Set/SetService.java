package com.project.everything.Set;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetService {
    //Create
    SetEntity saveSet(SetEntity setEntity) throws Exception;
    //Read
    List<SetEntity> getSetList() throws Exception;
}
