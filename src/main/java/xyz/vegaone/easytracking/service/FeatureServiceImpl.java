package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.FeatureEntity;
import xyz.vegaone.easytracking.dto.Feature;
import xyz.vegaone.easytracking.repo.FeatureRepo;

import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepo featureRepo;

    private final Mapper mapper;

    @Autowired
    public FeatureServiceImpl(FeatureRepo featureRepo, Mapper mapper) {
        this.featureRepo = featureRepo;
        this.mapper = mapper;
    }

    @Override
    public Feature getFeature(Long id) {
        Optional findResult = featureRepo.findById(id);

        FeatureEntity featureEntity;
        if (findResult.isPresent()) {
            featureEntity = (FeatureEntity) findResult.get();
            return mapper.map(featureEntity, Feature.class);
        } else {
            return null;
        }
    }

    @Override
    public Feature createFeature(Feature feature) {
        FeatureEntity featureEntity = mapper.map(feature, FeatureEntity.class);

        FeatureEntity savedFeatureEntity = featureRepo.save(featureEntity);

        return mapper.map(savedFeatureEntity, Feature.class);
    }

    @Override
    public Feature updateFeature(Feature feature) {
        FeatureEntity featureEntity = mapper.map(feature, FeatureEntity.class);

        FeatureEntity savedFeatureEntity = featureRepo.save(featureEntity);

        return mapper.map(featureEntity, Feature.class);
    }

    @Override
    public void deleteFeature(Feature feature) {
        FeatureEntity featureEntity = mapper.map(feature, FeatureEntity.class);

        featureRepo.delete(featureEntity);
    }
}
