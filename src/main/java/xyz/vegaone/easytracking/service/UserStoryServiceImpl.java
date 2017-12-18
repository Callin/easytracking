package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.UserStoryEntity;
import xyz.vegaone.easytracking.dto.UserStory;
import xyz.vegaone.easytracking.repo.UserStoryRepo;

import java.util.Optional;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepo userStoryRepo;

    private final Mapper mapper;

    @Autowired
    public UserStoryServiceImpl(UserStoryRepo userStoryRepo, Mapper mapper) {
        this.userStoryRepo = userStoryRepo;
        this.mapper = mapper;
    }

    @Override
    public UserStory getUserStory(Long id) {
        Optional findResult = userStoryRepo.findById(id);

        UserStoryEntity userStoryEntity;
        if (findResult.isPresent()) {
            userStoryEntity = (UserStoryEntity) findResult.get();
            return mapper.map(userStoryEntity, UserStory.class);
        } else {
            return null;
        }
    }

    @Override
    public UserStory createUserStory(UserStory userStory) {
        UserStoryEntity userStoryEntity = mapper.map(userStory, UserStoryEntity.class);

        UserStoryEntity savedUserStoryEntity = userStoryRepo.save(userStoryEntity);

        return mapper.map(savedUserStoryEntity, UserStory.class);
    }

    @Override
    public UserStory updateUserStory(UserStory userStory) {
        UserStoryEntity userStoryEntity = mapper.map(userStory, UserStoryEntity.class);

        UserStoryEntity savedUserStoryEntity = userStoryRepo.save(userStoryEntity);

        return mapper.map(savedUserStoryEntity, UserStory.class);
    }

    @Override
    public void deleteUserStory(UserStory userStory) {
        UserStoryEntity userStoryEntity = mapper.map(userStory, UserStoryEntity.class);

        userStoryRepo.delete(userStoryEntity);
    }
}
