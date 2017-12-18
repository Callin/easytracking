package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Bug;

public interface BugService {

    Bug getBug(Long id);

    Bug createBug(Bug bug);

    Bug updateBug(Bug bug);

    void deleteBug(Bug bug);
}
