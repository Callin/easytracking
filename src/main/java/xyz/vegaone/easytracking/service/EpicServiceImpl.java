package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.EpicEntity;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.repo.EpicRepo;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EpicServiceImpl implements EpicService {

    private final EpicRepo epicRepo;

    private final ProjectService projectService;

    private final Mapper mapper;

    @Autowired
    public EpicServiceImpl(EpicRepo epicRepo, ProjectService projectService, Mapper mapper) {
        this.epicRepo = epicRepo;
        this.projectService = projectService;
        this.mapper = mapper;
    }

    @Override
    public Epic getEpic(Long id) {
        Optional findResult = epicRepo.findById(id);

        EpicEntity epicEntity;
        if (findResult.isPresent()) {
            epicEntity = (EpicEntity) findResult.get();
            return mapper.map(epicEntity, Epic.class);
        } else {
            return null;
        }
    }

    @Override
    public Epic createEpic(Epic epic) {
        EpicEntity epicEntity = mapper.map(epic, EpicEntity.class);

        EpicEntity savedEpicEntity= epicRepo.save(epicEntity);

        return mapper.map(savedEpicEntity, Epic.class);
    }

    @Override
    public Epic updateEpic(Epic epic) {
        EpicEntity epicEntity = mapper.map(epic, EpicEntity.class);

        EpicEntity savedEpicEntity = epicRepo.save(epicEntity);

        return mapper.map(savedEpicEntity, Epic.class);
    }

    @Override
    public void deleteEpic(Epic epic) {

        projectService.removeEpic(epic);
    }
}
