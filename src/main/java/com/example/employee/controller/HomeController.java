package com.example.employee.controller;

import com.example.employee.constant.UriConstants;
import com.example.employee.domain.Link;
import com.example.employee.domain.Response;
import com.example.employee.util.ResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController implements UriConstants {

    @GetMapping(UriConstants.HOME)
    public Response<List<Link>> links() throws Exception {

        List<Link> links = listLinks();
        return ResponseWrapper.wrapGetResponse(List::isEmpty, links);
    }
}