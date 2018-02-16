# API Versioning Example

This is a quick example of an annotation driven URL path API Versioning approach at the method level that is very lightweight.

## Getting Started

The ApiVersion, VersioningConfig, and ApiVersionRequestMappingHandlerMapping classes are all plug and play. The integration tests and example controller provide examples of what to expect.


### Examples


```
@ApiVersion("1")
-
/v1/example-controller/hello
```

```
@ApiVersion("2")
-
/v2/example-controller/hello
```

```
@ApiVersion("2016-12-25")
-
/v2016-12-25/example-controller/hello
```

```
No Annotation
-
/example-controller/hello
```


## Built With

* Gradle
* SpringBoot

## Authors

* **William Gibbins** - w.d.gibbins@gmail.com

## License

This project is licensed under the MIT License 
