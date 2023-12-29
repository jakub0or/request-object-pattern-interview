# AnotherFakeApi

All URIs are relative to *http://petstore.swagger.io:80/v2*

 Method                                                   | HTTP request                  | Description                         
----------------------------------------------------------|-------------------------------|-------------------------------------
 [**testSpecialTags**](AnotherFakeApi.md#testSpecialTags) | **PATCH** /another-fake/dummy | To PostPetStoreApiTest special tags 

<a name="testSpecialTags"></a>

# **testSpecialTags**

> Client testSpecialTags(body)

To PostPetStoreApiTest special tags

To PostPetStoreApiTest special tags

### Example

```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AnotherFakeApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://petstore.swagger.io:80/v2"))).anotherFake();

api.testSpecialTags()
    .body(body).execute(r -> r.prettyPeek());
```

### Parameters

 Name     | Type                    | Description  | Notes 
----------|-------------------------|--------------|-------
 **body** | [**Client**](Client.md) | client model |

### Return type

[**Client**](Client.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

