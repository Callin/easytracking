package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.BugEntity;
import xyz.vegaone.easytracking.dto.Bug;
import xyz.vegaone.easytracking.repo.BugRepo;

import java.util.Optional;

@Service
public class BugServiceImpl implements BugService{

    private final BugRepo bugRepo;

    private final Mapper mapper;

    @Autowired
    public BugServiceImpl(BugRepo bugRepo, Mapper mapper) {
        this.bugRepo = bugRepo;
        this.mapper = mapper;
    }

    @Override
    public Bug getBug(Long id) {
        Optional findResult = bugRepo.findById(id);

        BugEntity bugEntity;
        if (findResult.isPresent()) {
            bugEntity = (BugEntity) findResult.get();
            return mapper.map(bugEntity, Bug.class);
        } else {
            return null;
        }
    }

    @Override
    public Bug createBug(Bug bug) {
        BugEntity bugEntity = mapper.map(bug, BugEntity.class);

        BugEntity savedBugEntity = bugRepo.save(bugEntity);

        return mapper.map(savedBugEntity, Bug.class);
    }

    @Override
    public Bug updateBug(Bug bug) {
        BugEntity bugEntity = mapper.map(bug, BugEntity.class);

        BugEntity savedBugEntity = bugRepo.save(bugEntity);

        return mapper.map(savedBugEntity, Bug.class);
    }

    @Override
    public void deleteBug(Bug bug) {
        BugEntity bugEntity = mapper.map(bug, BugEntity.class);

        bugRepo.delete(bugEntity);
    }
}
