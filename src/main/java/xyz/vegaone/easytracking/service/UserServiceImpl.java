package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.repo.UserRepo;
import xyz.vegaone.easytracking.domain.UserEntity;
import xyz.vegaone.easytracking.dto.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final Mapper mapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, Mapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public User getUser(Long id) {
        Optional findResult = userRepo.findById(id);

        UserEntity userEntity;
        if (findResult.isPresent()) {
            userEntity = (UserEntity) findResult.get();
            return mapper.map(userEntity, User.class);
        } else {
            return null;
        }
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);

        UserEntity savedUserEntity = userRepo.save(userEntity);

        return mapper.map(savedUserEntity, User.class);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);

        UserEntity savedUserEntity = userRepo.save(userEntity);

        return mapper.map(savedUserEntity, User.class);
    }

    @Override
    public void deleteUser(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);

        userRepo.delete(userEntity);
    }
}
