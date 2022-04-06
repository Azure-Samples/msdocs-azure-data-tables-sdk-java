// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

// Write your Javascript code.
    var windDirectionArray = ["CALM","N","NE","NW","E","W","SW","SE","S","VARIABLE"];
    var tableEntityBaseItem1 = ["temperature","humidity","barometer","windSpeed","precipitation"];
    var tableEntityBaseItem2 = ["Temperature","Humidity","Barometer","WindSpeed","Precipitation"];
    var requireErrorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">"
        + "This field {0} is required.<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";
    var numericErrorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">"
        + "Please enter a valid number for {0}.<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";
    var temperatureBetweenHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">"
        + "The field {0} must be between -100 and 200.<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";
    var precipitationBetweenHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">"
        + "The field {0} must be between 0 and 300.<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";
    var numericValueNotValid = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">"
        + "The value '{0}' is not valid for {1}.<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>";

    function initIndex() {
        $('#main-context').load('./initIndex');
        $(document).attr('title', "Home page - Azure Tables Demo Application");
    };

    function initFilter() {
        $('#main-context').load('./initFilteredResults');
        $(document).attr('title', "Home page - Azure Tables Demo Application");
    };

    function findByFilter() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='filterErrorArea']").each(function(index, item){
            item.remove();
        });

        $("input[id$='Filter']").each(function(index, item){
            if (item.id != 'partitionKeyFilter' && item.id != 'rowKeyDateStartFilter'
                && item.id != 'rowKeyDateEndFilter' && item.id != 'rowKeyTimeStartFilter'
                && item.id != 'rowKeyTimeEndFilter') {
                var itemId = "#" + item.id;
                var lblItemId = "#" + item.id + "Label";
                var labelText = $(lblItemId).text();
                if ($(itemId).val() != "" ) {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", labelText.substring(0, labelText.length -1));
                    } else {
                        if (item.id == 'minTemperatureFilter' || item.id == 'maxTemperatureFilter') {
                            if ($(itemId).val() < -100 || $(itemId).val() > 200) {
                                validated = false;
                                errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", labelText.substring(0, labelText.length -1));
                            }
                        }else {
                            if ($(itemId).val() < 0 || $(itemId).val() > 300) {
                                validated = false;
                                errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", labelText.substring(0, labelText.length -1));
                            }
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#filterArea').before(errorHtml);
            return false;
        }

        var data = "{";
        if ($('#partitionKeyFilter').val() != "") {
            data = data + "\"partitionKey\":\"" + $('#partitionKeyFilter').val()  + "\",";
        } else {
            data = data + "\"partitionKey\":" + null  + ",";
        }

        if ($('#rowKeyDateStartFilter').val() != "") {
            data = data + "\"rowKeyDateStart\":\"" + $('#rowKeyDateStartFilter').val()  + "\",";
        } else {
            data = data + "\"rowKeyDateStart\":" + null  + ",";
        }

        if ($('#rowKeyTimeStartFilter').val() != "") {
            data = data + "\"rowKeyTimeStart\":\"" + $('#rowKeyTimeStartFilter').val()  + "\",";
        } else {
            data = data + "\"rowKeyTimeStart\":" + null  + ",";
        }

        if ($('#rowKeyDateEndFilter').val() != "") {
            data = data + "\"rowKeyDateEnd\":\"" + $('#rowKeyDateEndFilter').val()  + "\",";
        } else {
            data = data + "\"rowKeyDateEnd\":" + null  + ",";
        }


        if ($('#rowKeyTimeEndFilter').val() != "") {
            data = data + "\"rowKeyTimeEnd\":\"" + $('#rowKeyTimeEndFilter').val()  + "\",";
        } else {
            data = data + "\"rowKeyTimeEnd\":" + null  + ",";
        }

        if ($('#minTemperatureFilter').val() != "") {
            data = data + "\"minTemperature\":" + $('#minTemperatureFilter').val() + ",";
        } else {
            data = data + "\"minTemperature\":" + null  + ",";
        }

        if ($('#maxTemperatureFilter').val() != "") {
            data = data + "\"maxTemperature\":" + $('#maxTemperatureFilter').val() + ",";
        } else {
            data = data + "\"maxTemperature\":" + null  + ",";
        }

        if ($('#minPrecipitationFilter').val() != "") {
            data = data + "\"minPrecipitation\":" + $('#minPrecipitationFilter').val() + ",";
        } else {
            data = data + "\"minPrecipitation\":" + null  + ",";
        }

        if ($('#maxPrecipitationFilter').val() != "") {
            data = data + "\"maxPrecipitation\":" + $('#maxPrecipitationFilter').val() + ",";
        } else {
            data = data + "\"maxPrecipitation\":" + null  + ",";
        }

        data = data.substr(0, data.length -1) + "}";

        $.ajax({
            url: "./retrieveEntitiesByFilter",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success: function(data){
                if (data.code == 0) {
                    $('filterErrorArea').remove();
                    var html = "<thead><tr><th>Station Name</th><th>Observation Date</th>";
                    $.each(data.listOfKeys, function(index, key) {
                        html = html + "<th>" + key + "</th>"
                    });
                    html = html + "</tr></thead><tbody>";
                    $.each(data.entitiesList, function(index, item){
                        html = html + "<tr><td>" + item.stationName + "</td>" +
                            "<td>" + item.observationDate + "</td>";
                        $.each(data.listOfKeys, function(index, key) {
                            html = html + "<td>" + item.propertyMap[key] + "</td>"
                        });
                    });
                    html = html + "</tr></tbody>";
                    $('#result-table').html(html).show();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"filterErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#filterArea').before(errorHtml);
                }
            }
        });

    };

    function retrieveAllEntities() {
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $.ajax({
            url: "./retrieveAllEntities",
            type: "get",
            dataType:"json",
            success: function(data) {
                if (data.code == 0) {
                    var html = "<thead><tr><th>Station Name</th><th>Observation Date</th>";
                    $.each(data.listOfKeys, function(keyIndex, key) {
                        html = html + "<th>" + key + "</th>"
                    });
                    html = html + "<th class=\"text-end\">Actions</th></tr></thead>";
                    html = html + "<tbody>";
                    $.each(data.entitiesList, function(entityIndex, item){
                        html = html + "<tr><td>" + item.stationName + "</td><td>" + item.observationDate + "</td>";
                        $.each(data.listOfKeys, function(keyIndex, key) {
                            html = html + "<td>" + item.propertyMap[key] + "</td>"
                        });
                        html = html + "<td class=\"text-end\">";
                        html = html + "<button id=\"updateEntityButton_" + entityIndex + "\" class=\"btn btn-primary btn-sm entity-update\" data-bs-toggle=\"modal\" data-bs-target=\"#updateEntityModel\">Update</button>&nbsp;";
                        html = html + "<button id=\"deleteEntityButton_" + entityIndex + "\" class=\"btn btn-danger btn-sm\">Delete</button>";
                        html = html + "</td></tr>";
                    });
                    html = html + "</tbody>"
                    $('#result-table').html(html).show();
                    $("button[id^='updateEntityButton_']").each(function(index, item){
                        var buttonId = "#" + item.id;
                        $(buttonId).on('click', function(){
                            showUpdateEntityModel(data.entitiesList[index], data.listOfKeys);
                        });
                    });
                    $("button[id^='deleteEntityButton_']").each(function(index, item){
                        var buttonId = "#" + item.id;
                        $(buttonId).on('click', function(){
                            deleteEntity(data.entitiesList[index]);
                        });
                    });
                } else {
                    var errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function insertEntity() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $("input[id$='TableEntity']").each(function(index, item){
            var itemId = "#" + item.id;
            var lblItemId = '#' + item.id + "Label";
            if ($(itemId).val() == "") {
                validated = false;
                if (item.id == 'stationNameTableEntity'
                    || item.id == 'observationDateTableEntity'
                    || item.id == 'observationTimeTableEntity') {
                    if (item.id == 'observationDateTableEntity' || item.id == 'observationTimeTableEntity') {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $('#observationDateTableEntityLabel').text());
                    } else {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $(lblItemId).text());
                    }
                } else {
                    errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                }
            } else {
                if (item.id != 'stationNameTableEntity'
                    && item.id !='observationDateTableEntity'
                    && item.id != 'observationTimeTableEntity') {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                    } else {
                        if (item.id == 'temperatureTableEntity' && ($(itemId).val() < -100 || $(itemId).val() > 200)) {
                            validated = false;
                            errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", $(lblItemId).text());
                        } else if (item.id == 'precipitationTableEntity' && ($(itemId).val() < 0 || $(itemId).val() > 300)) {
                            validated = false;
                            errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", $(lblItemId).text());
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#closeTableEntity').click();
            $('#buttonArea').before(errorHtml);
            return false;
        }

        var data = "{" +
            "\"stationName\":\"" + $('#stationNameTableEntity').val() + "\"," +
            "\"observationDate\":\"" + $('#observationDateTableEntity').val() + "\"," +
            "\"observationTime\":\"" + $('#observationTimeTableEntity').val() + "\"," +
            "\"temperature\":" + $('#temperatureTableEntity').val() + "," +
            "\"humidity\":" + $('#humidityTableEntity').val() + "," +
            "\"barometer\":" + $('#barometerTableEntity').val() + "," +
            "\"windDirection\":\"" + $('#windDirectionTableEntity').val() + "\"," +
            "\"windSpeed\":" + $('#windSpeedTableEntity').val() + "," +
            "\"precipitation\":" + $('#precipitationTableEntity').val() +
            "}"
        $.ajax({
            url: "./insertEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    $("div[id$='indexErrorArea']").each(function(index, item){
                        item.remove();
                    });
                    $('#closeTableEntity').click();
                    retrieveAllEntities();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"usingTableEntityErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function upsertEntity() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $("input[id$='TableEntity']").each(function(index, item){
            var itemId = "#" + item.id;
            var lblItemId = '#' + item.id + "Label";
            if ($(itemId).val() == "") {
                validated = false;
                if (item.id == 'stationNameTableEntity'
                    || item.id == 'observationDateTableEntity'
                    || item.id == 'observationTimeTableEntity') {
                    if (item.id == 'observationDateTableEntity' || item.id == 'observationTimeTableEntity') {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $('#observationDateTableEntityLabel').text());
                    } else {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $(lblItemId).text());
                    }
                } else {
                    errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                }
            } else {
                if (item.id != 'stationNameTableEntity'
                    && item.id !='observationDateTableEntity'
                    && item.id != 'observationTimeTableEntity') {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                    } else {
                        if (item.id == 'temperatureTableEntity' && ($(itemId).val() < -100 || $(itemId).val() > 200)) {
                            validated = false;
                            errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", $(lblItemId).text());
                        } else if (item.id == 'precipitationTableEntity' && ($(itemId).val() < 0 || $(itemId).val() > 300)) {
                            validated = false;
                            errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", $(lblItemId).text());
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#closeTableEntity').click();
            $('#buttonArea').before(errorHtml);
            return false;
        }

        var data = "{" +
            "\"stationName\":\"" + $('#stationNameTableEntity').val() + "\"," +
            "\"observationDate\":\"" + $('#observationDateTableEntity').val() + "\"," +
            "\"observationTime\":\"" + $('#observationTimeTableEntity').val() + "\"," +
            "\"temperature\":" + $('#temperatureTableEntity').val() + "," +
            "\"humidity\":" + $('#humidityTableEntity').val() + "," +
            "\"barometer\":" + $('#barometerTableEntity').val() + "," +
            "\"windDirection\":\"" + $('#windDirectionTableEntity').val() + "\"," +
            "\"windSpeed\":" + $('#windSpeedTableEntity').val() + "," +
            "\"precipitation\":" + $('#precipitationTableEntity').val() +
            "}"
        $.ajax({
            url: "./upsertEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    $("div[id$='indexErrorArea']").each(function(index, item){
                        item.remove();
                    });
                    $('#closeTableEntity').click();
                    retrieveAllEntities();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"usingTableEntityErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function insertExpandableEntity() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $("input[id$='Expandable']").each(function(index, item){
            var itemId = "#" + item.id;
            var lblItemId = '#' + item.id + "Label";
            if ($(itemId).val() == "") {
                validated = false;
                if (item.id == 'stationNameExpandable'
                    || item.id == 'observationDateExpandable'
                    || item.id == 'observationTimeExpandable') {
                    if (item.id == 'observationDateExpandable' || item.id == 'observationTimeExpandable') {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $('#observationDateExpandableLabel').text());
                    } else {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $(lblItemId).text());
                    }
                } else {
                    errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                }
            } else {
                if (item.id != 'stationNameExpandable'
                    && item.id !='observationDateExpandable'
                    && item.id != 'observationTimeExpandable') {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                    } else {
                        if (item.id == 'temperatureExpandable' && ($(itemId).val() < -100 || $(itemId).val() > 200)) {
                            validated = false;
                            errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", $(lblItemId).text());
                        } else if (item.id == 'precipitationExpandable' && ($(itemId).val() < 0 || $(itemId).val() > 300)) {
                            validated = false;
                            errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", $(lblItemId).text());
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#closeExpandable').click();
            $('#buttonArea').before(errorHtml);
            return false;
        }

        var data = "{" +
            "\"stationName\":\"" + $('#stationNameExpandable').val() + "\"," +
            "\"observationDate\":\"" + $('#observationDateExpandable').val() + " " + $('#observationTimeExpandable').val() + "\"," +
            "\"propertyMap\":" + "{"

        $("input[id$='Expandable']").each(function(index, item){
            if (item.id != 'stationNameExpandable'
                && item.id != 'observationDateExpandable'
                && item.id != 'observationTimeExpandable') {
                data = data + "\"" + item.name + "\":\"" + item.value + "\","
            }
        });
        $("select[id$='Expandable']").each(function(index, item){
            data = data + "\"" + item.name + "\":\"" + item.value + "\""
        });
        data = data + "}" + "}";
        $.ajax({
            url: "./insertExpandableEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    $('#closeExpandable').click();
                    retrieveAllEntities();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"usingExpandedDataErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function upsertExpandableEntity() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $("input[id$='Expandable']").each(function(index, item){
            var itemId = "#" + item.id;
            var lblItemId = '#' + item.id + "Label";
            if ($(itemId).val() == "") {
                validated = false;
                if (item.id == 'stationNameExpandable'
                    || item.id == 'observationDateExpandable'
                    || item.id == 'observationTimeExpandable') {
                    if (item.id == 'observationDateExpandable' || item.id == 'observationTimeExpandable') {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $('#observationDateExpandableLabel').text());
                    } else {
                        errorHtml = errorHtml + requireErrorHtml.replace("{0}", $(lblItemId).text());
                    }
                } else {
                    errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                }
            } else {
                if (item.id != 'stationNameExpandable'
                    && item.id !='observationDateExpandable'
                    && item.id != 'observationTimeExpandable') {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                    } else {
                        if (item.id == 'temperatureExpandable' && ($(itemId).val() < -100 || $(itemId).val() > 200)) {
                            validated = false;
                            errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", $(lblItemId).text());
                        } else if (item.id == 'precipitationExpandable' && ($(itemId).val() < 0 || $(itemId).val() > 300)) {
                            validated = false;
                            errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", $(lblItemId).text());
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#closeExpandable').click();
            $('#buttonArea').before(errorHtml);
            return false;
        }

        var data = "{" +
            "\"stationName\":\"" + $('#stationNameExpandable').val() + "\"," +
            "\"observationDate\":\"" + $('#observationDateExpandable').val() + " " + $('#observationTimeExpandable').val() + "\"," +
            "\"propertyMap\":" + "{"

        $("input[id$='Expandable']").each(function(index, item){
            if (item.id != 'stationNameExpandable'
                && item.id != 'observationDateExpandable'
                && item.id != 'observationTimeExpandable') {
                data = data + "\"" + item.name + "\":\"" + item.value + "\","
            }
        });
        $("select[id$='Expandable']").each(function(index, item){
            data = data + "\"" + item.name + "\":\"" + item.value + "\""
        });
        data = data + "}" + "}";
        $.ajax({
            url: "./upsertExpandableEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    $('#closeExpandable').click();
                    retrieveAllEntities();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"usingExpandedDataErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function insertSampleEntities() {
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        var data = "{" +
             "\"unit\":\"" + $('#bulkDataUnits').val() + "\"," +
             "\"city\":\"" + $('#sampleDataCity').val() + "\""
         + "}"
        $.ajax({
            url: "./insertSampleEntities",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                $('#closeSample').click();
                if (data.code == 0){
                    retrieveAllEntities();
                } else {
                    var errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"sampleDataErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function deleteEntity(tableEntity) {
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        var data = "{" +
             "\"stationName\":\"" + tableEntity.stationName + "\"," +
             "\"observationDate\":\"" + tableEntity.observationDate + "\""
         + "}";
        $.ajax({
            url: "./deleteEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    retrieveAllEntities();
                } else {
                    var errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"indexErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function initPrivacy() {
        $('#main-context').load('./initPrivacy');
        $(document).attr('title', "Privacy Policy - Azure Tables Demo Application");
    };

    function showUpdateEntityModel(entity, listOfKeys) {
        var html = "<div class=\"row g-3 mb-2\">" +
            "     <div class=\"col-sm-4\">" +
            "           <label for=\"PartitionKeyUpdate\" id=\"PartitionKeyUpdateLabel\" class=\"col-form-label\">Partition Key</label>" +
            "     </div>" +
            "     <div class=\"col-sm-8\">" +
            "           <input type=\"text\" id=\"PartitionKeyUpdate\" name=\"stationName\" class=\"form-control\" value=\"" + entity.stationName  + "\" readonly=\"readonly\">" +
            "     </div>" +
            "</div>" +
            "<div class=\"row g-3 mb-2\">" +
            "   <div class=\"col-sm-4\">" +
            "       <label for=\"RowKeyUpdate\" id=\"RowKeyUpdateLabel\" class=\"col-form-label\">Row Key</label>" +
            "   </div>" +
            "   <div class=\"col-sm-8\">" +
            "       <input type=\"text\" id=\"RowKeyUpdate\" name=\"observationDate\" class=\"form-control\" value=\"" + entity.observationDate + "\" readonly=\"readonly\">" +
            "   </div>" +
            "</div>" +
            "<input type=\"hidden\" name=\"etag\" value=" + entity.eTag + " />" +
            "<hr />";
        $.each(listOfKeys, function(index, key) {
            selectedValue = entity.propertyMap[key];
            html = html +
                    "<div class=\"row g-3 mb-2\">" +
                    "   <div class=\"col-sm-4\">" +
                    "       <label for=\"" + key + "Update\" id=\"" + key + "UpdateLabel\" class=\"col-form-label\">" + key + "</label>" +
                    "   </div>";
            if (key == 'WindDirection') {
                var isMatch = false;
                html = html +
                    "   <div class=\"col-sm-8\">" +
                    "       <select id=\"" + key + "Update\" name=\"" + key + "\" class=\"form-control\">";
                $.each(windDirectionArray, function(index, windDirectionArray) {
                    if (!isMatch && windDirectionArray == entity.propertyMap[key]) {
                        html = html + "<option selected>" + windDirectionArray + "</option>"
                        isMatch = true;
                    } else {
                        html = html + "<option>" + windDirectionArray + "</option>"
                    }
                });
                html = html + "</select></div>";
            } else {
                html = html +
                    "   <div class=\"col-sm-8\">" +
                    "       <input type=\"text\" id=\"" + key + "Update\" name=\"" + key + "\" class=\"form-control\" value=\"" + entity.propertyMap[key] + "\">" +
                    "   </div>";
            }
            html = html + "</div>";
        });
        html = html + "</div>";
        $('#updateEntityModalBody').html(html);
    };

    function updateTableEntity() {
        var validated = true;
        var errorHtml = "";
        $("div[id$='indexErrorArea']").each(function(index, item){
            item.remove();
        });
        $("input[id$='Update']").each(function(index, item){
            if (item.id != 'PartitionKeyUpdate'
                && item.id != 'RowKeyUpdate'
                && item.id != 'WindDirectionUpdate') {
                var itemId = "#" + item.id;
                var lblItemId = '#' + item.id + "Label";
                if ($(itemId).val() == "") {
                    validated = false;
                    errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                } else {
                    var isNumeric = $.isNumeric($(itemId).val());
                    if (isNumeric == false) {
                        validated = false;
                        errorHtml = errorHtml + numericValueNotValid.replace("{0}", $(itemId).val()).replace("{1}", $(lblItemId).text());
                    } else {
                        if (item.id == 'TemperatureUpdate' && ($(itemId).val() < -100 || $(itemId).val() > 200)) {
                            validated = false;
                            errorHtml = errorHtml + temperatureBetweenHtml.replace("{0}", $(lblItemId).text());
                        } else if (item.id == 'PrecipitationUpdate' && ($(itemId).val() < 0 || $(itemId).val() > 300)) {
                            validated = false;
                            errorHtml = errorHtml + precipitationBetweenHtml.replace("{0}", $(lblItemId).text());
                        }
                    }
                }
            }
        });

        if (!validated) {
            $('#closeUpdateEntity').click();
            $('#buttonArea').before(errorHtml);
            return false;
        }

        var data = "{" +
            "\"stationName\":\"" + $('#PartitionKeyUpdate').val() + "\"," +
            "\"observationDate\":\"" + $('#RowKeyUpdate').val() + "\"," +
            "\"propertyMap\":" + "{"
            $("input[id$='Update']").each(function(index, item){
                if (item.id != 'PartitionKeyUpdate'
                    && item.id != 'RowKeyUpdate') {
                    data = data + "\"" + item.name + "\":\"" + item.value + "\","
                }
            });
            $("select[id$='Update']").each(function(index, item){
                data = data + "\"" + item.name + "\":\"" + item.value + "\""
            });
            data = data + "}" + "}";
        $.ajax({
            url: "./updateEntity",
            type:"post",
            data: data,
            contentType:"application/json;charset=utf-8",
            dataType:"json",
            success:function(data){
                if (data.code == 0){
                    $('#closeUpdateEntity').click();
                    retrieveAllEntities();
                } else {
                    errorHtml = "<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" id=\"updateEntityErrorArea\">" +
                        data.msg + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>"
                    $('#buttonArea').before(errorHtml);
                }
            }
        });
    };

    function closeCustomField() {
        $('#customFieldName').val('');
        $('#customFieldName-error').remove();
    };

    function addCustomField() {
        $('#customFieldName-error').remove();
        var fieldValue = $('#customFieldName').val();
        if (fieldValue == "") {
            $('#customFieldName').after("<label id=\"customFieldName-error\" class=\"error\" for=\"customFieldName\">This field Custom field name is required.</label>")
            return false;
        }
        var convertedFieldValue = fieldValue.replace(/\s+/g,"");
        var html = "<div id=\"" + convertedFieldValue + "CustomExpandableDiv\" class=\"row g-3 mb-2\">" +
            "<div class=\"col-sm-4\">" +
                "<label for=\"" + convertedFieldValue + "Expandable\" id=\"" + convertedFieldValue +"ExpandableLabel\" class=\"col-form-label\">" + fieldValue + "</label>" +
            "</div>" +
            "<div class=\"col-sm-7\">" +
            "   <input type=\"text\" id=\"" + convertedFieldValue + "Expandable\" name=\"" + convertedFieldValue + "\" class=\"form-control\" placeholder=\"" + fieldValue + " value\">" +
            "</div>" +
            "<div class =\"col-sm-1 text-end\">" +
            "   <button id=\"" + convertedFieldValue + "ExpandableRemove\" class=\"btn btn-danger\">X</button>"
            "</div>" +
            "</div>";
        $('#addCustomFieldDiv').before(html);
        $("#" + convertedFieldValue + "ExpandableRemove").on('click', function() {
            $("#" + convertedFieldValue + "CustomExpandableDiv").remove();
        });
        $('#closeCustomField').click()
    };

    function removeErrorLabelAndResetValue(modelType) {
        if (modelType == 'UsingTableEntity') {
            $("input[id$='TableEntity']").each(function(index, item){
                item.value = ""
            });
            $("select[id$='TableEntity']").each(function(index, item){
                item.options[0].selected = true;
            });
        } else if (modelType == 'UsingExpandedData') {
            $("input[id$='Expandable']").each(function(index, item){
                item.value = ""
            });
            $("select[id$='Expandable']").each(function(index, item){
                item.options[0].selected = true;
            });
            $("div[id$='CustomExpandableDiv']").each(function(index, item){
                item.remove();
            });
        } else if (modelType == 'SampleData') {
            $("select[id$='sampleDataCity']").each(function(index, item){
                item.options[0].selected = true;
            });
        } else if (modelType == 'AddCustomField') {
            $('#customFieldName').val('');
            $('#customFieldName-error').remove();
        }
    };

    $(function(){
        $('#applicationLink').on('click', function(){initIndex();});
        $('#homeLink').on('click', function(){initIndex();});
        $('#filterLink').on('click', function(){initFilter();});
        $('#privacyLink').attr('href', 'javascript:initPrivacy()');
        initIndex();
    });