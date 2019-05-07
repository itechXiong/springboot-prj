# springboot-prj

一、 xitech-common-framework  
    1. 描述：使用SpringBoot实现的基础框架，实现功能如下：  
            a. 提供entity、service、dao的抽象  
            b. 集成Mybatis的底层的Sqlsession  
            c. 提供32为UUID生成工具  
             
             
           
二、 xitech-springboot-eureka  
    1. 描述： Eureka版本的注册中心demo  
   
     
三、xitech-springboot-eureka-web  
     1. 描述： 以Eureka为注册中心的服务消费者demo  
    
      
四、xitech-springboot-mybatis  
     1. 描述：使用SpringBoot集成Mybatis，实现访问数据库，提供事务管理，以及作为 以Eureka为注册中心的服务提供者demo  
        实现功能：  
          a. springboot集成Mybatis访问数据库  
          b. 事务管理  
          c. 服务提供者demo（若要部署服务提供者为集群模式，则修改server.port值即可，其他与Eureka注册中心相关的配置保持不变） 
