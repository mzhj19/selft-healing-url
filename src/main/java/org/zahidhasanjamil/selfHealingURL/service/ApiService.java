package org.zahidhasanjamil.selfHealingURL.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zahidhasanjamil.selfHealingURL.util.UrlManager;

import java.net.UnknownHostException;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Autowired
    private RetryTemplate retryTemplate;

    @Autowired
    private UrlManager urlManager;

    private final RestTemplate restTemplate = new RestTemplate();

    public String makeRequest() {
        return retryTemplate.execute(context -> {
            String url = urlManager.getCurrentUrl();
            logger.info("Attempting to connect to URL: {}", url);

            try {
                // Make the HTTP GET request
                return restTemplate.getForObject(url, String.class);

            } catch (Exception e) {
                if (e.getCause() instanceof UnknownHostException) {
                    logger.error("UnknownHostException encountered, switching URL: {}", e.getMessage());
                    urlManager.switchToNextUrl();  // Switch to the next URL
                    throw e;  // Trigger retry with the new URL
                } else {
                    // Handle other RestClientExceptions
                    logger.error("RestClientException encountered: {}", e.getMessage());
                    throw e;
                }
            }
        });
    }
}
