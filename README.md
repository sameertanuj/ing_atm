# ING ATM App
The app is used to store the ING ATM's list and retrieve them.
The app doesn't allow duplicate insertions based on address.

## Execute Application
### Install Mongo DB(Mac)
- Install xcode 
```console
  $ xcode-select --install
  ```
- Install mongo DB
```console
  $ brew tap mongodb/brew
  $ brew install mongodb-community@4.4
  $ brew services start mongodb-community@4.4
  ```
- Running mongo DB
```console
  $ brew services start mongodb-community@4.4
  ```
### Run the application
```console
  $ ./mvnw spring-boot:run
```
## How it works
- Once application is started it will get the master data from the https://www.ing.nl/api/locator/atms/ and loads the data to local DB.
- When a post API is called the service will check for the duplicates and insert only the unique values.
- In case we want to update the current values use the PUT API.
- Get the full list using get call.
## API
Below is a list of API endpoints with their respective input and output. Please note that the application needs to be
running for the following endpoints to work.
###Post ATM Data
Endpoint
```text
POST /atms
``` 
Example of body

```json
{
   "atmListId":1,
   "atmList":[
      {
            "address": {
                "street": "Omtaplein",
                "housenumber": "5",
                "postalcode": "1771 CW",
                "city": "Wieringerwerf",
                "geoLocation": {
                    "lat": "52.854517",
                    "lng": "5.023475"
                }
            },
            "distance": 0,
            "openingHours": [
                {
                    "dayOfWeek": 2,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 3,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 4,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 5,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 6,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 7,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 1,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                }
            ],
            "functionality": "Geldautomaat",
            "type": "GELDMAAT"
        }
   ]
}
```
Example of response

```json
{
    "successfulCount": 0,
    "successfulATMList": [],
    "duplicatesCount": 1,
    "duplicateATMList": [
        {
            "address": {
                "street": "Omtaplein",
                "housenumber": "5",
                "postalcode": "1771 CW",
                "city": "Wieringerwerf",
                "geoLocation": {
                    "lat": "52.854517",
                    "lng": "5.023475"
                }
            },
            "distance": 0,
            "openingHours": [
                {
                    "dayOfWeek": 2,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 3,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 4,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 5,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 6,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 7,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 1,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                }
            ],
            "functionality": "Geldautomaat",
            "type": "GELDMAAT"
        }
    ],
    "errorsCount": 0,
    "errorATMList": []
}
```
###Get ATM Data
Endpoint
```text
GET /atms
``` 
Example of response
```json
{
    "count": 1,
    "atmList": [
        {
            "address": {
                "street": "DIAMANTLAAN",
                "housenumber": "47",
                "postalcode": "9743 BA",
                "city": "GRONINGEN",
                "geoLocation": {
                    "lat": "53.22483",
                    "lng": "6.52823"
                }
            },
            "distance": 0,
            "openingHours": [
                {
                    "dayOfWeek": 2,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 3,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 4,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 5,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 6,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 7,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 1,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                }
            ],
            "functionality": "Geldautomaat",
            "type": "GELDMAAT"
        }
    ]
}
```
###PUT ATM Data
Endpoint
```text
PUT /atms
``` 
Example of body

```json
{
   "atmListId":1,
   "atmList":[
      {
            "address": {
                "street": "Omtaplein",
                "housenumber": "5",
                "postalcode": "1771 CW",
                "city": "Wieringerwerf",
                "geoLocation": {
                    "lat": "52.854517",
                    "lng": "5.023475"
                }
            },
            "distance": 0,
            "openingHours": [
                {
                    "dayOfWeek": 2,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 3,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 4,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 5,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 6,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 7,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                },
                {
                    "dayOfWeek": 1,
                    "hours": [
                        {
                            "hourFrom": "07:00",
                            "hourTo": "23:00"
                        }
                    ]
                }
            ],
            "functionality": "Geldautomaat",
            "type": "GELDMAAT"
        }
   ]
}
```
Example of response
```json
{
    "totalCount": 1,
    "totalMatched": 1,
    "totalModified": 0
}
```
