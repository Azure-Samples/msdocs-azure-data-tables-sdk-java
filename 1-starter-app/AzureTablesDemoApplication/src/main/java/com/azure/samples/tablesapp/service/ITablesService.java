// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.service;

import com.azure.samples.tablesapp.entities.ExpandableWeatherObject;
import com.azure.samples.tablesapp.entities.UpdateWeatherObject;
import com.azure.samples.tablesapp.models.FilterResultsInputModel;
import com.azure.samples.tablesapp.models.SampleDataInputModel;
import com.azure.samples.tablesapp.models.WeatherDataModel;
import com.azure.samples.tablesapp.models.WeatherInputModel;
import java.util.List;

public interface ITablesService {

    List<WeatherDataModel> retrieveAllEntities();

    List<WeatherDataModel> retrieveEntitiesByFilter(FilterResultsInputModel model);

    void deleteEntity(WeatherInputModel model);

    void insertEntity(WeatherInputModel model);

    void upsertEntity(WeatherInputModel model);

    void updateEntity(UpdateWeatherObject model);

    void insertExpandableEntity(ExpandableWeatherObject model);

    void upsertExpandableEntity(ExpandableWeatherObject model);

    void insertSampleEntities(SampleDataInputModel model);

}
