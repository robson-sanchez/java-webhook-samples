package com.rvvsanchez.libs.event.publisher.webhook.samples;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rvvsanchez.libs.event.publisher.webhook.core.WebhookSender;
import com.rvvsanchez.libs.event.publisher.webhook.http.DefaultHttpConnector;

/**
 * Sample webhook publisher
 * 
 * @author robson-sanchez
 */
public class WebhookPublisherSample {

  private static final String USER_AGENT = "Webhook-Sender";

  public static void main(String[] args) throws IOException {
    DefaultHttpConnector connector = new DefaultHttpConnector(USER_AGENT);

    WebhookSender sender = new WebhookSender(connector);

    int jsonResult = sender.sendJsonEvent("{ \"test\": 1234 }", args[0]);

    int xmlResult = sender.sendXmlEvent("<test>1234</test>", args[0]);

    Map<String, String> content = new HashMap<>();
    content.put("test", "1234");

    int formResult = sender.sendFormUrlEncoded(content, args[0]);
    
    System.out.println("JSON result " + jsonResult);
    System.out.println("XML result " + xmlResult);
    System.out.println("FORM result " + formResult);
  }
  
}
