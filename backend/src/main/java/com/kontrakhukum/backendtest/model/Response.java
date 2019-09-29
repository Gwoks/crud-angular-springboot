package com.kontrakhukum.backendtest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	private String message;

	public Response(String message) {
		super();
		this.message = message;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Response [message=" + message + "]";
	}

}
