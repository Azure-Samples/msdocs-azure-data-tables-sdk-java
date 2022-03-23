// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.azure.data.tables.TableClient;
import com.azure.samples.tablesapp.entities.ExpandableWeatherObject;
import com.azure.samples.tablesapp.entities.UpdateWeatherObject;
import com.azure.samples.tablesapp.models.FilterResultsInputModel;
import com.azure.samples.tablesapp.models.SampleDataInputModel;
import com.azure.samples.tablesapp.models.WeatherDataModel;
import com.azure.samples.tablesapp.models.WeatherInputModel;
import com.azure.samples.tablesapp.service.ITablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TablesServiceImpl implements ITablesService {

    @Autowired
    private TableClient tableClient;

    /**
     * Get all weather data entities
     * @return List<WeatherDataModel>
     */
    @Override
    public List<WeatherDataModel> retrieveAllEntities() {
        return new ArrayList<>();
    }

    /**
     * Get weather data entities by filters
     * @return List<WeatherDataModel>
     */
    @Override
    public List<WeatherDataModel> retrieveEntitiesByFilter(FilterResultsInputModel model) {
        return new ArrayList<>();
    }

    /**
     * Delete weather data by table key
     */
    @Override
    public void deleteEntity(WeatherInputModel model) {

    }

    /**
     * Insert new weather data object
     */
    @Override
    public void insertEntity(WeatherInputModel model) {

    }

    /**
     * Insert or update a weather data object
     */
    @Override
    public void upsertEntity(WeatherInputModel model) {

    }

    /**
     * Update weather data object
     */
    @Override
    public void updateEntity(UpdateWeatherObject model) {

    }

    /**
     * Insert a new expandable weather data object
     */
    @Override
    public void insertExpandableEntity(ExpandableWeatherObject model) {

    }

    /**
     * Insert or update an expandable weather data object
     */
    @Override
    public void upsertExpandableEntity(ExpandableWeatherObject model) {

    }

    /**
     * Insert or update multiple instances of weather data using a transaction
     */
    @Override
    public void insertSampleEntities(SampleDataInputModel model) {

    }

}
