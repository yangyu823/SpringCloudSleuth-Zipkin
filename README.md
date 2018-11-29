# SpringCloudSleuth-Zipkin

######Zipkin server file for BackUp

####Zipkin server Dockerize:
https://zipkin.io/
<br>
docker run -d --restart unless-stopped -p 9411:9411 openzipkin/zipkin

##Zipkin default port: 9411



1. Project
    * customerService   (Port:9083)
    * dataService1      (Port:9081)
    * dataService2      (Port:9082)




2. Testing

    * clientAction
    * serviceAction
    
    
###Dependency
* spring-cloud-starter-sleuth
* spring-cloud-starter-zipkin