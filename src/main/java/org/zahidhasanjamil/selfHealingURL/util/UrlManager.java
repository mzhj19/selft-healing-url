package org.zahidhasanjamil.selfHealingURL.util;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UrlManager {

    private final List<String> urls = List.of(
            "http://github.com",
            "http://secondary-api.com"
    );

    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public String getCurrentUrl() {
        return urls.get(currentIndex.get());
    }

    public void switchToNextUrl() {
        int nextIndex = (currentIndex.get() + 1) % urls.size();
        currentIndex.set(nextIndex);
    }
}
