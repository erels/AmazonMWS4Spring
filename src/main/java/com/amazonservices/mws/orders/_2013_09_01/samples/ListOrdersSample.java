/*******************************************************************************
 * Copyright 2009-2017 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Orders
 * API Version: 2013-09-01
 * Library Version: 2017-02-22
 * Generated: Thu Mar 02 12:41:03 UTC 2017
 */
package com.amazonservices.mws.orders._2013_09_01.samples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.orders._2013_09_01.*;
import com.amazonservices.mws.orders._2013_09_01.model.*;


/** Sample call for ListOrders. */
public class ListOrdersSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static ListOrdersResponse invokeListOrders(
            MarketplaceWebServiceOrders client, 
            ListOrdersRequest request) {
        try {
            // Call the service.
            ListOrdersResponse response = client.listOrders(request);
            ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
            // We recommend logging every the request id and timestamp of every call.
            System.out.println("Response:");
            System.out.println("RequestId: "+rhmd.getRequestId());
            System.out.println("Timestamp: "+rhmd.getTimestamp());
            String responseXml = response.toXML();
            System.out.println(responseXml);
            return response;
        } catch (MarketplaceWebServiceOrdersException ex) {
            // Exception properties are important for diagnostics.
            System.out.println("Service Exception:");
            ResponseHeaderMetadata rhmd = ex.getResponseHeaderMetadata();
            if(rhmd != null) {
                System.out.println("RequestId: "+rhmd.getRequestId());
                System.out.println("Timestamp: "+rhmd.getTimestamp());
            }
            System.out.println("Message: "+ex.getMessage());
            System.out.println("StatusCode: "+ex.getStatusCode());
            System.out.println("ErrorCode: "+ex.getErrorCode());
            System.out.println("ErrorType: "+ex.getErrorType());
            throw ex;
        }
    }

    /**
     *  Command line entry point.
     */
    public static void main(String[] args) {

        // Get a client connection.
        // Make sure you've set the variables in MarketplaceWebServiceOrdersSampleConfig.
        MarketplaceWebServiceOrdersClient client = MarketplaceWebServiceOrdersSampleConfig.getClient();

        // Create a request.
        ListOrdersRequest request = new ListOrdersRequest();
        String sellerId = "REQUIRED";
        request.setSellerId(sellerId);
        String mwsAuthToken = "REQUIRED";
        request.setMWSAuthToken(mwsAuthToken);

        // XMLGregorianCalendar createdAfter = MwsUtl.getDTF().newXMLGregorianCalendar();
        // request.setCreatedAfter(createdAfter);
        //replaced in the lines below to put now timestamp
        // XMLGregorianCalendar createdBefore = MwsUtl.getDTF().newXMLGregorianCalendar();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            // Date dob=null;
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            df.setTimeZone(TimeZone.getTimeZone("IDT"));
            Date dob=df.parse( "2017-11-11T22:33" );
            System.out.println("Date Before: " + df.format(dob));
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dob);
            XMLGregorianCalendar createdAfter = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            request.setCreatedAfter(createdAfter);
            //------
            dob=df.parse( "2017-11-21T01:00" );
            System.out.println("Date After: " + df.format(dob));
            GregorianCalendar gcb = new GregorianCalendar();
            gcb.setTime(dob);
            XMLGregorianCalendar createdBefore = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcb);
            //DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            //now date;
            //XMLGregorianCalendar createdBefore =
              //      datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);

            // --------
            request.setCreatedBefore(createdBefore);
        } catch (Exception ex) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$");
            System.out.println("Errror: " + ex) ;
            System.out.println("$$$$$$$$$$$$$$$$$$$$");
        }

        //Not un use for now
        /*
        XMLGregorianCalendar lastUpdatedAfter = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setLastUpdatedAfter(lastUpdatedAfter);
        XMLGregorianCalendar lastUpdatedBefore = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setLastUpdatedBefore(lastUpdatedBefore);
        */
        List<String> orderStatus = new ArrayList<String>();
        request.setOrderStatus(orderStatus);
        // List<String> marketplaceId = new ArrayList<String>();
        List<String> marketplaceId = Arrays.asList("REQUIRED");
        request.setMarketplaceId(marketplaceId);
        List<String> fulfillmentChannel = new ArrayList<String>();
        request.setFulfillmentChannel(fulfillmentChannel);
        List<String> paymentMethod = new ArrayList<String>();
        request.setPaymentMethod(paymentMethod);
        // String buyerEmail = "example";
        // request.setBuyerEmail(buyerEmail);
       // String sellerOrderId = "example";
        // request.setSellerOrderId(sellerOrderId);

        Integer maxResultsPerPage = 1;
        request.setMaxResultsPerPage(maxResultsPerPage);
        List<String> tfmShipmentStatus = new ArrayList<String>();
        request.setTFMShipmentStatus(tfmShipmentStatus);

        // Make the call.
        ListOrdersSample.invokeListOrders(client, request);

    }

}
