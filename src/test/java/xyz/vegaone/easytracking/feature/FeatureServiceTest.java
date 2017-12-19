package xyz.vegaone.easytracking.feature;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.Feature;
import xyz.vegaone.easytracking.service.FeatureService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeatureServiceTest {

    @Autowired
    private FeatureService featureService;

    private final static String FEATURE_TITLE = "task5";
    private final static String FEATURE_TITLE_TO_UPDATE = "completed";

    @Test
    public void createFeatureTest() {
        //given
        Feature saveResult = saveFeature();

        //then
        Assert.assertNotNull("There should have been one featureEntity saved in the database", saveResult);
        Assert.assertEquals("The featureEntity title should have matched", FEATURE_TITLE, saveResult.getTitle());

    }

    @Test
    public void getFeatureTest() {
        //given
        Feature saveResult = saveFeature();

        //when
        Feature findResult = featureService.getFeature(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one featureEntity saved in the database", findResult);
        Assert.assertEquals("The featureEntity title should have matched", FEATURE_TITLE, findResult.getTitle());
    }

    public void updateFeatureTest() {
        //given
        Feature saveResult = saveFeature();
        saveResult.setTitle(FEATURE_TITLE_TO_UPDATE);

        //when
        Feature updateFeature = featureService.updateFeature(saveResult);
        Feature findResult = featureService.getFeature(updateFeature.getId());

        //then
        Assert.assertNotNull("There should have been one featureEntity saved in the database", findResult);
        Assert.assertNotEquals("The featureEntity title should have been changed", FEATURE_TITLE, findResult.getTitle());

    }

    public void deleteFeatureTest() {
        //given
        Feature saveResult = saveFeature();

        //when
        featureService.deleteFeature(saveResult);
        Feature findResult = featureService.getFeature(saveResult.getId());

        //then
        Assert.assertNull("The featureEntity should have been removed from the database", findResult);

    }


    public Feature saveFeature() {
        Feature feature = new Feature();
        feature.setTitle(FEATURE_TITLE);
        return featureService.createFeature(feature);
    }
}
