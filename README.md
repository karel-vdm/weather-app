# weather-app

This is an example weather app using the Open Weather Map API https://openweathermap.org/api 

# Architecture

This app uses the clean architecture https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html with MVVM as well as kotlin flow for handling the data flow between the domain and data layers.

More on the diffrent layers defined in clean archtecture:

Data Layer:
The data layer is a one to one mapping of the api. There should be no business or display logic in the data layer. The data layer is purely responseble for getting data from the defined data source.


![CleanArchitecture](https://user-images.githubusercontent.com/80144326/110372775-5fa39c00-8057-11eb-9e3a-ff4662064a9c.jpg)

![image](https://user-images.githubusercontent.com/80144326/110373716-7a2a4500-8058-11eb-8396-fde929432ee8.png)
