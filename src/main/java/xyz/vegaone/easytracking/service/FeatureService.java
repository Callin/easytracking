package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Feature;

public interface FeatureService {

    Feature getFeature(Long id);

    Feature createFeature(Feature feature);

    Feature updateFeature(Feature feature);

    void deleteFeature(Feature feature);
}
