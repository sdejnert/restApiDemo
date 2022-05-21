package pl.sdejnert.restApiDemo.core.util;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RequestUrlQueryCreator {

    public String create(final String url, final String endpoint) {
        return UriComponentsBuilder.fromHttpUrl(String.format("%s%s", url, endpoint)).toUriString();
    }

}
