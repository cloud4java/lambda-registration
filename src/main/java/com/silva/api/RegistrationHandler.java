package com.silva.api;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegistrationHandler implements RequestHandler<RegistrationHandler.Request, RegistrationHandler.Response>{

    public Response handleRequest(Request request, Context context) {
        String greetings =  String.format("Hello, %s %s", request.firstName, request.lastName);
        LambdaLogger logger = context.getLogger();
        logger.log("############ Log output: " + greetings);
        return new Response(request.firstName, request.lastName);
    }


    static class Request{
        public String firstName;
        public String lastName;
    }


    static class Response{
        public String firstName;
        public String lastName;

        public Response(String lastName, String firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }
    }
}
