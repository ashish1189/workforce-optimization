# WorkForce-Optimization
Work force optimization tool
* Workforce Optimization tool helps to make optimal use of available workforce with respect to their capacities. Provided the array of structures in terms of number of rooms astructure has and the capacities of junior & senior resources, tool determines the optimal number of each type of worforce required to get the job done.
* The API is build using Java 8 & Spring Boot.
* API accepts JSON as an input & produces JSON as an output.

# Assumptions
* There will be no more than 100 structures.
* No structure has less than 1 or more than 100 rooms.
* Cpacity of the senior resource is greater than capacity of the junior resource.

# Build
* Run `mvn clean install` from the root directory
* Run `java -jar target/workforce-optimization-0.0.1-SNAPSHOT.jar` [--server.port=8080]

# Usage

## Base url
http://locahost:7080	(7080 is the default port)

### API endpoint (PUT)
/app/optimize

#### Sample Request
* Request body <br/>
	```json 
	{ 
		"rooms": [35, 21, 17, 28],
		"senior": 10, 
		"junior": 6 
	 }
	 ```

* Response body (success)
	```json 
	[
		{
			"senior": 3,
			"junior": 1
		},
		{
			"senior": 1,
			"junior": 2
		},
		{
			"senior": 2,
			"junior": 0
		},
		{
			"senior": 1,
			"junior": 3
		}
	]
	```

* Response Error

	```json
	{
		"id": "86c31f18-afb9-42fd-bb52-d0cc144c51b8",
		"code": "4006",
		"title": "NO_SENIOR_WORKER",
		"details": "Junior cleaner's capacity cannot be greater than that of Senior cleaner."
	}
	```

#### List of error codes

* API returns below error codes in the specific scenarios

| Response Code | Error Code | Title | Description |
| --- | --- | --- | --- |
| 400 | 4001 | Bad Request | No or empty request body provided. |
| 400 | 4002 | NO_REAL_STRUCTURE | At least one structre should be provided. |
| 400 | 4003 | NO_REAL_ROOMS | A structure should have at least one room. |
| 400 | 4004 | TOO_MANY_ROOMS | A structure should not have more than 100 rooms. |
| 400 | 4005 | NO_REAL_WORKER | Worker capacity should be a non zero positive entity. |
| 400 | 4006 | NO_SENIOR_WORKER | Junior cleaner's capacity cannot be greater than that of Senior cleaner. |
| 500 | 5001 | Internal Server Error | Internal error occured, cannot process request. |

#### Logs

* Application log file with name *co-app.log* will be created in the run path of the executable.
* Application Logging level is set to INFO
