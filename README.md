# workforce-optimization
Work force optimization tool
* The API is build using Java 8 & Spring Boot.
* API accepts JSON as an input & produces JSON as an output.

# Build
* Run `mvn clean install` from the root directory
* Run `java -jar target/workforce-optimization-0.0.1-SNAPSHOT.jar`

# Usage

## Base url
http://locahost:7080

### API endpoint (PUT)
/app/optimize

#### Sample Request
* Request payload <br/>
	```json 
	{ 
		"rooms": [35, 21, 17, 28],
		"senior": 10, 
		"junior": 6 
	 }
	 ```

* Response payload (success)
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