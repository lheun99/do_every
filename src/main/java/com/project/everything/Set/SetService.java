package com.project.everything.Set;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetService {
    List<SetEntity> getSetList() throws Exception;
}
