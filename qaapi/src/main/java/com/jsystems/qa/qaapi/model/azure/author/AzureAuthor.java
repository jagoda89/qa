package com.jsystems.qa.qaapi.model.azure.author;
//http://fakerestapi.azurewebsites.net/swagger/ui/index#!/Authors/Authors_Get
//testujemy metoe Authors GET

import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureAuthor {

    @JsonProperty(value = "ID", required = true)
    public long id;

    @JsonProperty(value = "IDBook", required = true)
    public long idBook;

    @JsonProperty(value = "FirstName", required = true)
    public String firstName;

    @JsonProperty(value = "LastName", required = true)
    public String lastName;

}
