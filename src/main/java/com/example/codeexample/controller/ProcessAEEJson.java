package com.example.codeexample.controller;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeexample.service.ProcessAEEService;

@RestController
@RequestMapping(path = "/v1")
public class ProcessAEEJson {
	
	@Autowired
	private ProcessAEEService service;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfo")
	public String getOrgJson() throws IOException, JSONException {
		return service.processJson();
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/generateCSV")
	public void getOrgCSV() throws IOException, JSONException {
		 service.processCSV();
	}
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByName/{orgName}")
	public String getOrgDataByName(@PathVariable(value = "orgName") String orgName) throws IOException, JSONException {
		
		return service.getOrgInfoByName(orgName);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByRelease/{count}")
	public String getOrgInfoByRelease(@PathVariable(value = "count") String count) throws IOException, JSONException {
		
		return service.getOrgInfoByReleaseCount(count);
	}
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/getOrgInfoByTotalHours/{hours}")
	public String getOrgInfoByTotalHours(@PathVariable(value = "hours") String hours) throws IOException, JSONException {
		
		return service.getOrgInfoByTotalhours(hours);
	}

}
