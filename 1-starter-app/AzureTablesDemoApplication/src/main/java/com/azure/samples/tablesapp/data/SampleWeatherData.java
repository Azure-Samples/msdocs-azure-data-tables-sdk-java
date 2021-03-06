// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.samples.tablesapp.data;

import com.azure.samples.tablesapp.models.WeatherInputModel;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SampleWeatherData {

    private static final List<WeatherInputModel> SAMPLE_DATA_LIST = new ArrayList<>() {{
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("00:00");
                    setTemperature(72D);
                    setHumidity(82D);
                    setBarometer(29.99);
                    setWindDirection("S");
                    setWindSpeed(1D);
                    setPrecipitation(0.01);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("03:00");
                    setTemperature(70D);
                    setHumidity(87D);
                    setBarometer(29.96);
                    setWindDirection("S");
                    setWindSpeed(1D);
                    setPrecipitation(0.14);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("06:00");
                    setTemperature(68D);
                    setHumidity(84D);
                    setBarometer(29.99);
                    setWindDirection("NE");
                    setWindSpeed(14D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("09:00");
                    setTemperature(72D);
                    setHumidity(66D);
                    setBarometer(30.02);
                    setWindDirection("N");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("12:00");
                    setTemperature(76D);
                    setHumidity(50D);
                    setBarometer(30.04);
                    setWindDirection("N");
                    setWindSpeed(16D);
                    setPrecipitation(0.01);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("15:00");
                    setTemperature(77D);
                    setHumidity(47D);
                    setBarometer(30.03);
                    setWindDirection("NE");
                    setWindSpeed(20D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("18:00");
                    setTemperature(72D);
                    setHumidity(48D);
                    setBarometer(30.04);
                    setWindDirection("NE");
                    setWindSpeed(17D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-01");
                    setObservationTime("21:00");
                    setTemperature(65D);
                    setHumidity(59D);
                    setBarometer(30.05);
                    setWindDirection("N");
                    setWindSpeed(14D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("00:00");
                    setTemperature(63D);
                    setHumidity(65D);
                    setBarometer(30.06);
                    setWindDirection("N");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("03:00");
                    setTemperature(62D);
                    setHumidity(75D);
                    setBarometer(30.05);
                    setWindDirection("N");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("06:00");
                    setTemperature(62D);
                    setHumidity(78D);
                    setBarometer(30.08);
                    setWindDirection("N");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("09:00");
                    setTemperature(68D);
                    setHumidity(65D);
                    setBarometer(30.12);
                    setWindDirection("N");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("12:00");
                    setTemperature(71D);
                    setHumidity(53D);
                    setBarometer(30.12);
                    setWindDirection("S");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("15:00");
                    setTemperature(73D);
                    setHumidity(41D);
                    setBarometer(30.09);
                    setWindDirection("N");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("18:00");
                    setTemperature(72D);
                    setHumidity(44D);
                    setBarometer(30.06);
                    setWindDirection("NE");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-02");
                    setObservationTime("21:00");
                    setTemperature(66D);
                    setHumidity(54D);
                    setBarometer(30.04);
                    setWindDirection("NE");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("00:00");
                    setTemperature(63D);
                    setHumidity(70D);
                    setBarometer(30.05);
                    setWindDirection("N");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("03:00");
                    setTemperature(59D);
                    setHumidity(81D);
                    setBarometer(30.06);
                    setWindDirection("W");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("06:00");
                    setTemperature(60D);
                    setHumidity(75D);
                    setBarometer(30.06);
                    setWindDirection("W");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("09:00");
                    setTemperature(70D);
                    setHumidity(56D);
                    setBarometer(30.06);
                    setWindDirection("W");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("12:00");
                    setTemperature(80D);
                    setHumidity(51D);
                    setBarometer(30.00);
                    setWindDirection("NW");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("15:00");
                    setTemperature(85D);
                    setHumidity(45D);
                    setBarometer(29.96);
                    setWindDirection("W");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("18:00");
                    setTemperature(85D);
                    setHumidity(48D);
                    setBarometer(29.93);
                    setWindDirection("NW");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-03");
                    setObservationTime("21:00");
                    setTemperature(80D);
                    setHumidity(64D);
                    setBarometer(29.93);
                    setWindDirection("W");
                    setWindSpeed(9D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("00:00");
                    setTemperature(75D);
                    setHumidity(71D);
                    setBarometer(29.94);
                    setWindDirection("W");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("03:00");
                    setTemperature(72D);
                    setHumidity(73D);
                    setBarometer(29.95);
                    setWindDirection("W");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("06:00");
                    setTemperature(70D);
                    setHumidity(79D);
                    setBarometer(29.96);
                    setWindDirection("W");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("09:00");
                    setTemperature(77D);
                    setHumidity(66D);
                    setBarometer(29.98);
                    setWindDirection("W");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("12:00");
                    setTemperature(84D);
                    setHumidity(55D);
                    setBarometer(29.96);
                    setWindDirection("W");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("15:00");
                    setTemperature(88D);
                    setHumidity(45D);
                    setBarometer(29.93);
                    setWindDirection("SW");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("18:00");
                    setTemperature(87D);
                    setHumidity(51D);
                    setBarometer(29.93);
                    setWindDirection("W");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Chicago");
                    setObservationDate("2021-07-04");
                    setObservationTime("21:00");
                    setTemperature(82D);
                    setHumidity(63D);
                    setBarometer(29.93);
                    setWindDirection("SW");
                    setWindSpeed(9D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("00:00");
                    setTemperature(76D);
                    setHumidity(97D);
                    setBarometer(30.03);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("03:00");
                    setTemperature(75D);
                    setHumidity(96D);
                    setBarometer(30.00);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("06:00");
                    setTemperature(75D);
                    setHumidity(100D);
                    setBarometer(29.99);
                    setWindDirection("N");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("09:00");
                    setTemperature(81D);
                    setHumidity(85D);
                    setBarometer(30.02);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("12:00");
                    setTemperature(79D);
                    setHumidity(88D);
                    setBarometer(30.03);
                    setWindDirection("VARIABLE");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("15:00");
                    setTemperature(78D);
                    setHumidity(87D);
                    setBarometer(30.00);
                    setWindDirection("SE");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("18:00");
                    setTemperature(79D);
                    setHumidity(88D);
                    setBarometer(30.00);
                    setWindDirection("ESE");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-01");
                    setObservationTime("21:00");
                    setTemperature(79D);
                    setHumidity(88D);
                    setBarometer(30.00);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("00:00");
                    setTemperature(79D);
                    setHumidity(79D);
                    setBarometer(30.02);
                    setWindDirection("VARIABLE");
                    setWindSpeed(3D);
                    setPrecipitation(0.03);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("03:00");
                    setTemperature(79D);
                    setHumidity(94D);
                    setBarometer(29.99);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("06:00");
                    setTemperature(79D);
                    setHumidity(88D);
                    setBarometer(29.99);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("09:00");
                    setTemperature(79D);
                    setHumidity(88D);
                    setBarometer(30.03);
                    setWindDirection("SW");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("12:00");
                    setTemperature(87D);
                    setHumidity(64D);
                    setBarometer(30.02);
                    setWindDirection("S");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("15:00");
                    setTemperature(90D);
                    setHumidity(57D);
                    setBarometer(29.96);
                    setWindDirection("VARIABLE");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("18:00");
                    setTemperature(88D);
                    setHumidity(65D);
                    setBarometer(29.92);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.20);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-02");
                    setObservationTime("21:00");
                    setTemperature(77D);
                    setHumidity(94D);
                    setBarometer(29.99);
                    setWindDirection("E");
                    setWindSpeed(6D);
                    setPrecipitation(0.37);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("00:00");
                    setTemperature(77D);
                    setHumidity(96D);
                    setBarometer(30.01);
                    setWindDirection("SE");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("03:00");
                    setTemperature(76D);
                    setHumidity(97D);
                    setBarometer(29.99);
                    setWindDirection("SW");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("06:00");
                    setTemperature(76D);
                    setHumidity(100D);
                    setBarometer(29.99);
                    setWindDirection("W");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("09:00");
                    setTemperature(85D);
                    setHumidity(75D);
                    setBarometer(30.01);
                    setWindDirection("VARIABLE");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("12:00");
                    setTemperature(89D);
                    setHumidity(63D);
                    setBarometer(30.02);
                    setWindDirection("SW");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("15:00");
                    setTemperature(94D);
                    setHumidity(62D);
                    setBarometer(29.97);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("18:00");
                    setTemperature(91D);
                    setHumidity(57D);
                    setBarometer(29.95);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-03");
                    setObservationTime("21:00");
                    setTemperature(87D);
                    setHumidity(57D);
                    setBarometer(30.01);
                    setWindDirection("NW");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("00:00");
                    setTemperature(82D);
                    setHumidity(82D);
                    setBarometer(30.01);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("03:00");
                    setTemperature(80D);
                    setHumidity(100D);
                    setBarometer(29.97);
                    setWindDirection("NW");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("06:00");
                    setTemperature(80D);
                    setHumidity(90D);
                    setBarometer(29.98);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("09:00");
                    setTemperature(82D);
                    setHumidity(77D);
                    setBarometer(30.01);
                    setWindDirection("E");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("12:00");
                    setTemperature(90D);
                    setHumidity(59D);
                    setBarometer(30.01);
                    setWindDirection("SE");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("15:00");
                    setTemperature(92D);
                    setHumidity(60D);
                    setBarometer(29.97);
                    setWindDirection("E");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("18:00");
                    setTemperature(89D);
                    setHumidity(65D);
                    setBarometer(29.95);
                    setWindDirection("SE");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Miami");
                    setObservationDate("2021-07-04");
                    setObservationTime("21:00");
                    setTemperature(82D);
                    setHumidity(82D);
                    setBarometer(29.99);
                    setWindDirection("SE");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("00:00");
                    setTemperature(89D);
                    setHumidity(39D);
                    setBarometer(28.67);
                    setWindDirection("SE");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("03:00");
                    setTemperature(88D);
                    setHumidity(40D);
                    setBarometer(28.66);
                    setWindDirection("E");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("06:00");
                    setTemperature(86D);
                    setHumidity(38D);
                    setBarometer(28.69);
                    setWindDirection("E");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("09:00");
                    setTemperature(93D);
                    setHumidity(31D);
                    setBarometer(28.72);
                    setWindDirection("W");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("12:00");
                    setTemperature(100D);
                    setHumidity(23D);
                    setBarometer(28.67);
                    setWindDirection("W");
                    setWindSpeed(9D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("15:00");
                    setTemperature(104D);
                    setHumidity(19D);
                    setBarometer(28.58);
                    setWindDirection("N");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("18:00");
                    setTemperature(106D);
                    setHumidity(19D);
                    setBarometer(28.51);
                    setWindDirection("W");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-01");
                    setObservationTime("21:00");
                    setTemperature(102D);
                    setHumidity(21D);
                    setBarometer(28.55);
                    setWindDirection("S");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("00:00");
                    setTemperature(93D);
                    setHumidity(36D);
                    setBarometer(28.64);
                    setWindDirection("NE");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("03:00");
                    setTemperature(89D);
                    setHumidity(42D);
                    setBarometer(28.61);
                    setWindDirection("E");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("06:00");
                    setTemperature(90D);
                    setHumidity(37D);
                    setBarometer(28.66);
                    setWindDirection("E");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("09:00");
                    setTemperature(92D);
                    setHumidity(38D);
                    setBarometer(28.69);
                    setWindDirection("W");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("12:00");
                    setTemperature(96D);
                    setHumidity(32D);
                    setBarometer(28.68);
                    setWindDirection("W");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("15:00");
                    setTemperature(101D);
                    setHumidity(26D);
                    setBarometer(28.59);
                    setWindDirection("VARIABLE");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("18:00");
                    setTemperature(103D);
                    setHumidity(22D);
                    setBarometer(28.55);
                    setWindDirection("W");
                    setWindSpeed(10D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-02");
                    setObservationTime("21:00");
                    setTemperature(98D);
                    setHumidity(25D);
                    setBarometer(28.61);
                    setWindDirection("S");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("00:00");
                    setTemperature(92D);
                    setHumidity(38D);
                    setBarometer(28.67);
                    setWindDirection("SE");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("03:00");
                    setTemperature(91D);
                    setHumidity(37D);
                    setBarometer(28.67);
                    setWindDirection("E");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("06:00");
                    setTemperature(88D);
                    setHumidity(42D);
                    setBarometer(28.69);
                    setWindDirection("E");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("09:00");
                    setTemperature(94D);
                    setHumidity(36D);
                    setBarometer(28.70);
                    setWindDirection("E");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("12:00");
                    setTemperature(99D);
                    setHumidity(29D);
                    setBarometer(28.68);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("15:00");
                    setTemperature(104D);
                    setHumidity(22D);
                    setBarometer(28.59);
                    setWindDirection("W");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("18:00");
                    setTemperature(104D);
                    setHumidity(60D);
                    setBarometer(28.56);
                    setWindDirection("W");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-03");
                    setObservationTime("21:00");
                    setTemperature(81D);
                    setHumidity(77D);
                    setBarometer(28.71);
                    setWindDirection("E");
                    setWindSpeed(6D);
                    setPrecipitation(0.21);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("00:00");
                    setTemperature(81D);
                    setHumidity(72D);
                    setBarometer(28.73);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.05);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("03:00");
                    setTemperature(81D);
                    setHumidity(72D);
                    setBarometer(28.70);
                    setWindDirection("E");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("06:00");
                    setTemperature(81D);
                    setHumidity(74D);
                    setBarometer(28.72);
                    setWindDirection("E");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("09:00");
                    setTemperature(86D);
                    setHumidity(70D);
                    setBarometer(28.74);
                    setWindDirection("E");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("12:00");
                    setTemperature(94D);
                    setHumidity(38D);
                    setBarometer(28.72);
                    setWindDirection("E");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("15:00");
                    setTemperature(99D);
                    setHumidity(31D);
                    setBarometer(28.64);
                    setWindDirection("N");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("18:00");
                    setTemperature(102D);
                    setHumidity(26D);
                    setBarometer(28.59);
                    setWindDirection("S");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Phoenix");
                    setObservationDate("2021-07-04");
                    setObservationTime("21:00");
                    setTemperature(98D);
                    setHumidity(31D);
                    setBarometer(28.60);
                    setWindDirection("S");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("00:00");
                    setTemperature(52D);
                    setHumidity(77D);
                    setBarometer(29.96);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("03:00");
                    setTemperature(48D);
                    setHumidity(86D);
                    setBarometer(29.96);
                    setWindDirection("SSW");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("06:00");
                    setTemperature(48D);
                    setHumidity(86D);
                    setBarometer(29.95);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("09:00");
                    setTemperature(56D);
                    setHumidity(75D);
                    setBarometer(29.95);
                    setWindDirection("SW");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("12:00");
                    setTemperature(59D);
                    setHumidity(64D);
                    setBarometer(29.93);
                    setWindDirection("NW");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("15:00");
                    setTemperature(61D);
                    setHumidity(64D);
                    setBarometer(29.87);
                    setWindDirection("WNW");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("18:00");
                    setTemperature(63D);
                    setHumidity(65D);
                    setBarometer(29.85);
                    setWindDirection("NNW");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-01");
                    setObservationTime("21:00");
                    setTemperature(68D);
                    setHumidity(37D);
                    setBarometer(29.55);
                    setWindDirection("SSE");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("00:00");
                    setTemperature(63D);
                    setHumidity(50D);
                    setBarometer(29.81);
                    setWindDirection("SE");
                    setWindSpeed(15D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("03:00");
                    setTemperature(59D);
                    setHumidity(62D);
                    setBarometer(29.80);
                    setWindDirection("SE");
                    setWindSpeed(15D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("06:00");
                    setTemperature(56D);
                    setHumidity(72D);
                    setBarometer(29.79);
                    setWindDirection("SSE");
                    setWindSpeed(15D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("09:00");
                    setTemperature(56D);
                    setHumidity(84D);
                    setBarometer(29.82);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("12:00");
                    setTemperature(60D);
                    setHumidity(60D);
                    setBarometer(29.85);
                    setWindDirection("SE");
                    setWindSpeed(16D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("15:00");
                    setTemperature(63D);
                    setHumidity(50D);
                    setBarometer(29.86);
                    setWindDirection("SE");
                    setWindSpeed(18D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("18:00");
                    setTemperature(64D);
                    setHumidity(45D);
                    setBarometer(29.87);
                    setWindDirection("SE");
                    setWindSpeed(21D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-02");
                    setObservationTime("21:00");
                    setTemperature(60D);
                    setHumidity(51D);
                    setBarometer(29.91);
                    setWindDirection("SSE");
                    setWindSpeed(15D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("00:00");
                    setTemperature(54D);
                    setHumidity(66D);
                    setBarometer(29.98);
                    setWindDirection("WSW");
                    setWindSpeed(13D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("03:00");
                    setTemperature(53D);
                    setHumidity(69D);
                    setBarometer(30.02);
                    setWindDirection("W");
                    setWindSpeed(12D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("06:00");
                    setTemperature(50D);
                    setHumidity(83D);
                    setBarometer(30.05);
                    setWindDirection("CALM");
                    setWindSpeed(0D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("09:00");
                    setTemperature(51D);
                    setHumidity(86D);
                    setBarometer(30.07);
                    setWindDirection("SE");
                    setWindSpeed(3D);
                    setPrecipitation(0.05);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("12:00");
                    setTemperature(52D);
                    setHumidity(83D);
                    setBarometer(30.09);
                    setWindDirection("NE");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("15:00");
                    setTemperature(54D);
                    setHumidity(69D);
                    setBarometer(30.09);
                    setWindDirection("NW");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("18:00");
                    setTemperature(56D);
                    setHumidity(64D);
                    setBarometer(30.09);
                    setWindDirection("WNW");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-03");
                    setObservationTime("21:00");
                    setTemperature(55D);
                    setHumidity(67D);
                    setBarometer(30.10);
                    setWindDirection("W");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("00:00");
                    setTemperature(53D);
                    setHumidity(74D);
                    setBarometer(30.11);
                    setWindDirection("W");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("03:00");
                    setTemperature(52D);
                    setHumidity(74D);
                    setBarometer(30.11);
                    setWindDirection("SSW");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("06:00");
                    setTemperature(51D);
                    setHumidity(77D);
                    setBarometer(30.11);
                    setWindDirection("W");
                    setWindSpeed(7D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("09:00");
                    setTemperature(53D);
                    setHumidity(77D);
                    setBarometer(30.11);
                    setWindDirection("VARIABLE");
                    setWindSpeed(6D);
                    setPrecipitation(0.05);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("12:00");
                    setTemperature(58D);
                    setHumidity(65D);
                    setBarometer(30.09);
                    setWindDirection("VARIABLE");
                    setWindSpeed(5D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("15:00");
                    setTemperature(61D);
                    setHumidity(58D);
                    setBarometer(30.07);
                    setWindDirection("WNW");
                    setWindSpeed(8D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("18:00");
                    setTemperature(63D);
                    setHumidity(52D);
                    setBarometer(30.03);
                    setWindDirection("W");
                    setWindSpeed(6D);
                    setPrecipitation(0.00);
            }});
            add(new WeatherInputModel() {{
                    setStationName("Anchorage");
                    setObservationDate("2021-07-04");
                    setObservationTime("21:00");
                    setTemperature(62D);
                    setHumidity(60D);
                    setBarometer(30.01);
                    setWindDirection("NW");
                    setWindSpeed(3D);
                    setPrecipitation(0.00);
            }});
    }};

    public static List<WeatherInputModel> getSampleData(String unit, String city) {
        List<WeatherInputModel> dataList = new ArrayList<>();
        switch (unit) {
            case "US":
                if (StringUtils.isEmptyOrWhitespace(city)) {
                    dataList.addAll(SAMPLE_DATA_LIST);
                } else {
                    dataList.addAll(SAMPLE_DATA_LIST.stream().filter(sampleData -> city.equals(sampleData.getStationName())).collect(Collectors.toList()));
                }
                break;
            case "Metric":
                break;
        }
        return dataList;
    }

}
