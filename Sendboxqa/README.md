
### Run tests
##
#### _To run the tests locally, you can use the default configuration from the property file_
  There are two ways to run tests:
  1. From IDE (in our case IntelliJ IDEA), just go to ```RunAllFT.class``` and simply press run. 
  2. Use the maven builder tool by going to Sendboxqa folder and running the following command:
```bash 
    mvn clean test -PSendboxqa 
``` 
You can use the same webDriver as the one in configuration or add the following property to specify your own driver:
```bash
    mvn clean test -PSendboxqa -Dfluentlenium.webDriver=chrome.
```
	
	

## All the configuration is done in _fluentlenium.properties_ file on class path in the resources folder

```
#Default WebDriver
webDriver=chrome
#=======================
#BaseUrl
#========================================================
#Capabilities
capabilities={\"browserName\":\"chrome\", \"chromeOptions"\:{\"args\": [\"window-size=1920,1024"]}}
=========================================================================



