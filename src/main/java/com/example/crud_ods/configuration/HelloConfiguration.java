package com.example.crud_ods.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    @Bean
    public String helloWorld(){
        return "Hello World";
    }
//    @Bean
//    function dynamoDBClient():DynamoDbClient{
//        return DynamoDbClient.builder()
//                .region(awsProperties.regionAsAwsEnum())
//                .apply {
//            if(! awsProperties.endpoint.isNullOrEmpty())
//                endpointOverride(URI(awsProperties.endpoint)) //awsProperties.endpoint = http://localhost:8000
//        }
//            .credentialsProvider(DefaultCredentialsProvider.builder().build())
//                .build()
//    }
}
