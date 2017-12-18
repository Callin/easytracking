package xyz.vegaone.easytracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.easytracking.dto.Feature;
import xyz.vegaone.easytracking.service.FeatureService;

@Controller
@RequestMapping("/feature")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Feature createFeature(Feature feature) {

        return featureService.createFeature(feature);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Feature getFeature(@PathVariable("id") Long id) {

        return featureService.getFeature(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Feature updateFeature(Feature feature) {

        return featureService.updateFeature(feature);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteFeature(Feature feature) {

        featureService.deleteFeature(feature);
    }
}
