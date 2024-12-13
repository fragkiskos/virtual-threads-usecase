This is a demo project to demonstrate virtual threads capabillities combined with spring boot 3 applications. 

Repository contains  3 spring-boot services proxy,hotels and apartments. 

Proxy is the unit under investigation and it has enabled the virtual threads configuration.

Hotels service is playing the role of a slow backend system.

Apartments service is playing the role of a fast service and modern service.

There is also a jmeter test case in order to validate the theory behind the virtual threads.

see more at https://www.linkedin.com/pulse/how-unblock-your-spring-boot-3-service-enabling-real-life-fragiskos-mv4df