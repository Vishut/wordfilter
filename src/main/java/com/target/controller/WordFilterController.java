package com.target.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.request.FilterRequest;
import com.target.response.FilterResponse;
import com.target.service.WordFilterservice;
import com.target.util.ApplicationUtil;

@RestController
public class WordFilterController {

	@Autowired
	private WordFilterservice filterService;

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<FilterResponse> filterText(HttpServletRequest request, @RequestBody String inputjson) {
		FilterRequest filterRequest = ApplicationUtil.convertJsonToObject(inputjson, FilterRequest.class);
		FilterResponse filterResponse = filterService.filter(filterRequest.getComment());
		return new ResponseEntity<FilterResponse>(filterResponse, filterResponse.getStatus());
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "ho gya";
	}

}
