// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.controller;

import com.azure.samples.tablesapp.entities.ExpandableWeatherObject;
import com.azure.samples.tablesapp.entities.UpdateWeatherObject;
import com.azure.samples.tablesapp.models.FilterResultsInputModel;
import com.azure.samples.tablesapp.models.SampleDataInputModel;
import com.azure.samples.tablesapp.models.WeatherDataModel;
import com.azure.samples.tablesapp.models.WeatherInputModel;
import com.azure.samples.tablesapp.service.ITablesService;
import com.azure.samples.tablesapp.untils.WeatherDataUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;

@RestController
public class TablesServiceController  {

    @Autowired
    private ITablesService tablesService;

    private static final String LAYOUT_PAGE = "layouts/_layout";

    private static final String PRIVACY_PAGE = "privacy";

    private static final String INDEX_PAGE = "index";

    private static final String FILTER_PAGE = "filter-results";

    private static final String HOME_PAGE_TITLE = "Home Page";

    private static final String PRIVACY_PAGE_TITLE = "Privacy Policy";

    private static final String ATTRIBUTE_NAME_TITLE = "title";

    private static final Integer SUCCESS_CODE = 0;

    private static final String SUCCESS_MSG = "success!";

    @GetMapping("/")
    public ModelAndView initLayout() {
        ModelAndView modelAndView = new ModelAndView(LAYOUT_PAGE);
        modelAndView.addObject(ATTRIBUTE_NAME_TITLE, HOME_PAGE_TITLE);
        return modelAndView;
    }

    @GetMapping("/initIndex")
    public ModelAndView initIndex() {
        return new ModelAndView(INDEX_PAGE);
    }

    @GetMapping("/initFilteredResults")
    public ModelAndView initFilteredResults() {
        ModelAndView modelAndView = new ModelAndView(FILTER_PAGE);
        modelAndView.addObject(ATTRIBUTE_NAME_TITLE, HOME_PAGE_TITLE);
        return modelAndView;
    }

    @GetMapping("/initPrivacy")
    public ModelAndView initPrivacy() {
        ModelAndView modelAndView = new ModelAndView(PRIVACY_PAGE);
        modelAndView.addObject(ATTRIBUTE_NAME_TITLE, PRIVACY_PAGE_TITLE);
        return modelAndView;
    }

    @GetMapping("/retrieveAllEntities")
    public String retrieveAllEntities() {
        List<WeatherDataModel> entitiesList = tablesService.retrieveAllEntities();
        return new JSONObject(new HashMap<String, Object>(){{
            put("entitiesList", entitiesList);
            put("listOfKeys", WeatherDataUtils.getListOfKeys(entitiesList));
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/retrieveEntitiesByFilter")
    public String retrieveEntitiesByFilter(@RequestBody FilterResultsInputModel model) {
        List<WeatherDataModel> entitiesList = tablesService.retrieveEntitiesByFilter(model);
        return new JSONObject(new HashMap<String, Object>(){{
            put("entitiesList", entitiesList);
            put("listOfKeys", WeatherDataUtils.getListOfKeys(entitiesList));
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/deleteEntity")
    public String deleteEntity(@RequestBody WeatherInputModel weatherInputModel) {
        tablesService.deleteEntity(weatherInputModel);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping(value = "/insertEntity")
    public String insertEntity(@RequestBody WeatherInputModel weatherInputModel) {
        tablesService.insertEntity(weatherInputModel);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/upsertEntity")
    public String upsertEntity(@RequestBody WeatherInputModel weatherInputModel) {
        tablesService.upsertEntity(weatherInputModel);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/updateEntity")
    public String updateEntity(@RequestBody UpdateWeatherObject updateWeatherObject) {
        tablesService.updateEntity(updateWeatherObject);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/insertExpandableEntity")
    public String insertExpandableEntity(@RequestBody ExpandableWeatherObject expandableWeatherObject) {
        tablesService.insertExpandableEntity(expandableWeatherObject);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/upsertExpandableEntity")
    public String upsertExpandableEntity(@RequestBody ExpandableWeatherObject expandableWeatherObject) {
        tablesService.upsertExpandableEntity(expandableWeatherObject);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

    @PostMapping("/insertSampleEntities")
    public String insertSampleEntities(@RequestBody SampleDataInputModel sampleDataInputModel) {
        tablesService.insertSampleEntities(sampleDataInputModel);
        return new JSONObject(new HashMap<String, Object>(){{
            put("code", SUCCESS_CODE);
            put("msg", SUCCESS_MSG);
        }}).toString();
    }

}
