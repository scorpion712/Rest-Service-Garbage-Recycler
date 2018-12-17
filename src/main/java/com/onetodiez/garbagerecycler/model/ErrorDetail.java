package com.onetodiez.garbagerecycler.model;
/**
 * This class is used to return an error or exception in a customized Json format
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 * 
 */
import java.util.Date;
/**
 * 
 * This class generate a Json to use as format to response customized errors.
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 * 
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDetail {

	   @JsonProperty("message")
	   private String message;
	   @JsonProperty("status_code")
	   private int statusCode;
	   @JsonProperty("uri")
	   private String uriRequested;
	   @JsonProperty("date")
	   @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
	   private Date date; 

	   public ErrorDetail(int statusCode, String message, String uriRequested) {
	       this.message = message;
	       this.statusCode = statusCode;
	       this.uriRequested = uriRequested;
	       this.date = new Date();
	   }
	   
	   public Date getDate() {
		   return date;
	   }

	   public String getMessage() {
	       return message;
	   }

	   public int getStatusCode() {
	       return statusCode;
	   }

	   public String getUriRequested() {
	       return uriRequested;
	   }
}
