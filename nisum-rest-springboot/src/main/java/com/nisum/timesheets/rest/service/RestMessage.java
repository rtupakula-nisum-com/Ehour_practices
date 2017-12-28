package com.nisum.timesheets.rest.service;

/*{

"to": "Device Token",
      "data" : {
            "message": "Body",
            "title": "Title"
      }
}*/

public class RestMessage {
	
	private String to;
	private RestData data;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public RestData getData() {
		return data;
	}
	public void setData(RestData data) {
		this.data = data;
	}

}
