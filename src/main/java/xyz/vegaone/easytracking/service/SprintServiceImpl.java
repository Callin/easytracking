package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.EpicEntity;
import xyz.vegaone.easytracking.domain.SprintEntity;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Sprint;
import xyz.vegaone.easytracking.repo.EpicRepo;
import xyz.vegaone.easytracking.repo.SprintRepo;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

    private final SprintRepo sprintRepo;

    private final Mapper mapper;

    @Autowired
    public SprintServiceImpl(SprintRepo sprintRepo, Mapper mapper) {
        this.sprintRepo = sprintRepo;
        this.mapper = mapper;
    }

    @Override
    public Sprint getSprint(Long id) {
        Optional findResult = sprintRepo.findById(id);

        SprintEntity sprintEntity;
        if (findResult.isPresent()) {
            sprintEntity = (SprintEntity) findResult.get();
            return mapper.map(sprintEntity, Sprint.class);
        } else {
            return null;
        }
    }

    @Override
    public Sprint createSprint(Sprint sprint) {
        SprintEntity sprintEntity = mapper.map(sprint, SprintEntity.class);

        SprintEntity savedSprintEntity= sprintRepo.save(sprintEntity);

        return mapper.map(savedSprintEntity, Sprint.class);
    }

    @Override
    public Sprint updateSprint(Sprint sprint) {
        SprintEntity sprintEntity = mapper.map(sprint, SprintEntity.class);

        SprintEntity savedSprintEntity = sprintRepo.save(sprintEntity);

        return mapper.map(savedSprintEntity, Sprint.class);
    }

    @Override
    public void deleteSprint(Sprint sprint) {
        SprintEntity sprintEntity = mapper.map(sprint, SprintEntity.class);

        sprintRepo.delete(sprintEntity);
    }
}
