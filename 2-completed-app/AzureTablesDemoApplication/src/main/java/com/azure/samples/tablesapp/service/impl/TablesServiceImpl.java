// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.azure.data.tables.TableClient;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;
import com.azure.data.tables.models.TableTransactionAction;
import com.azure.data.tables.models.TableTransactionActionType;
import com.azure.samples.tablesapp.data.SampleWeatherData;
import com.azure.samples.tablesapp.entities.ExpandableWeatherObject;
import com.azure.samples.tablesapp.entities.UpdateWeatherObject;
import com.azure.samples.tablesapp.models.FilterResultsInputModel;
import com.azure.samples.tablesapp.models.SampleDataInputModel;
import com.azure.samples.tablesapp.models.WeatherDataModel;
import com.azure.samples.tablesapp.models.WeatherInputModel;
import com.azure.samples.tablesapp.service.ITablesService;
import com.azure.samples.tablesapp.untils.WeatherDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;


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
        List<WeatherDataModel> modelList = tableClient.listEntities().stream()
                .map(WeatherDataUtils::mapTableEntityToWeatherDataModel)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(WeatherDataUtils.filledValue(modelList));
    }

    /**
     * Get weather data entities by filters
     * @return List<WeatherDataModel>
     */
    @Override
    public List<WeatherDataModel> retrieveEntitiesByFilter(FilterResultsInputModel model) {

        List<String> filters = new ArrayList<>();

        if (!StringUtils.isEmptyOrWhitespace(model.getPartitionKey())) {
            filters.add(String.format("PartitionKey eq '%s'", model.getPartitionKey()));
        }
        if (!StringUtils.isEmptyOrWhitespace(model.getRowKeyDateStart())
                && !StringUtils.isEmptyOrWhitespace(model.getRowKeyTimeStart())) {
            filters.add(String.format("RowKey ge '%s %s'", model.getRowKeyDateStart(), model.getRowKeyTimeStart()));
        }
        if (!StringUtils.isEmptyOrWhitespace(model.getRowKeyDateEnd())
                && !StringUtils.isEmptyOrWhitespace(model.getRowKeyTimeEnd())) {
            filters.add(String.format("RowKey le '%s %s'", model.getRowKeyDateEnd(), model.getRowKeyTimeEnd()));
        }
        if (model.getMinTemperature() != null) {
            filters.add(String.format("Temperature ge %f", model.getMinTemperature()));
        }
        if (model.getMaxTemperature() != null) {
            filters.add(String.format("Temperature le %f", model.getMaxTemperature()));
        }
        if (model.getMinPrecipitation() != null) {
            filters.add(String.format("Precipitation ge %f", model.getMinPrecipitation()));
        }
        if (model.getMaxPrecipitation() != null) {
            filters.add(String.format("Precipitation le %f", model.getMaxPrecipitation()));
        }

        List<WeatherDataModel> modelList = tableClient.listEntities(new ListEntitiesOptions()
                        .setFilter(String.join(" and ", filters)), null, null).stream()
                .map(WeatherDataUtils::mapTableEntityToWeatherDataModel)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(WeatherDataUtils.filledValue(modelList));
    }

    /**
     * Delete weather data by table key
     */
    @Override
    public void deleteEntity(WeatherInputModel model) {
        tableClient.deleteEntity(model.getStationName(),
                WeatherDataUtils.formatRowKey(model.getObservationDate(), model.getObservationTime()));
    }

    /**
     * Insert new weather data object
     */
    @Override
    public void insertEntity(WeatherInputModel model) {
        tableClient.createEntity(WeatherDataUtils.createTableEntity(model));
    }

    /**
     * Insert or update a weather data object
     */
    @Override
    public void upsertEntity(WeatherInputModel model) {
        tableClient.upsertEntity(WeatherDataUtils.createTableEntity(model));
    }

    /**
     * Update weather data object
     */
    @Override
    public void updateEntity(UpdateWeatherObject model) {
        TableEntity tableEntity = tableClient.getEntity(model.getStationName(), model.getObservationDate());
        Map<String, Object> propertiesMap = model.getPropertyMap();
        propertiesMap.keySet().forEach(key -> tableEntity.getProperties().put(key, propertiesMap.get(key)));
        tableClient.updateEntity(tableEntity);
    }

    /**
     * Insert a new expandable weather data object
     */
    @Override
    public void insertExpandableEntity(ExpandableWeatherObject model){
        tableClient.createEntity(WeatherDataUtils.createTableEntity(model));
    }

    /**
     * Insert or update an expandable weather data object
     */
    @Override
    public void upsertExpandableEntity(ExpandableWeatherObject model){
        tableClient.upsertEntity(WeatherDataUtils.createTableEntity(model));
    }

    /**
     * Insert or update multiple instances of weather data using a transaction
     */
    @Override
    public void insertSampleEntities(SampleDataInputModel model) {
        List<WeatherInputModel> sampleList = SampleWeatherData.getSampleData(model.getUnit(), model.getCity());
        List<TableTransactionAction> actions = new ArrayList<>();
        sampleList.parallelStream().forEach(sampleData ->
            actions.add(new TableTransactionAction(TableTransactionActionType.UPSERT_REPLACE,
                    WeatherDataUtils.createTableEntity(sampleData))));
        tableClient.submitTransaction(actions);
    }

}
