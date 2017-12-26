package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Sprint;

public interface SprintService {

    Sprint getSprint(Long id);

    Sprint createSprint(Sprint sprint);

    Sprint updateSprint(Sprint sprint);

    void deleteSprint(Sprint sprint);
}
