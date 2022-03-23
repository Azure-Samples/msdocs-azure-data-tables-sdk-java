// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.models;

public class ExpandableWeatherInputModel {

    private String StationName;

    private String ObservationDate;

    private String ObservationTime;

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getObservationDate() {
        return ObservationDate;
    }

    public void setObservationDate(String observationDate) {
        ObservationDate = observationDate;
    }

    public String getObservationTime() {
        return ObservationTime;
    }

    public void setObservationTime(String observationTime) {
        ObservationTime = observationTime;
    }
}
