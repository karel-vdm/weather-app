# weather-app

This is an example weather app using the Open Weather Map API https://openweathermap.org/api 

# Architecture

This app uses the clean architecture https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html with MVVM as well as kotlin flow and live data for handling the data flow between the data, domain and presentation layers.

The clean architecture enforces dependency inversion High-level modules should not depend on low-level modules. Both should depend on abstractions.

More on the diffrent layers defined in clean archtecture:

Data layer:
The data layer is a one to one mapping of the api. There should be no business or display logic in the data layer. The data layer is purely responseble for getting data from the defined data source.

Domain layer: 
The domain layer is responsible for busniss logic as well as any changes to the api defined object structures. To satisfy dependency inversion we map the data layer object to a domain layer object. The data layer should not know about any low level domain layer objects.

Presentation layer:
The presentation layer is responsible for handling the display of data as well as view rendering logic. The domain layer object is mapped to a presentation layer object (ViewModel). Any changes to data for display purposes should be handled in the presentation layer.


![CleanArchitecture](https://user-images.githubusercontent.com/80144326/110372775-5fa39c00-8057-11eb-9e3a-ff4662064a9c.jpg)

![image](https://user-images.githubusercontent.com/80144326/110373716-7a2a4500-8058-11eb-8396-fde929432ee8.png)
