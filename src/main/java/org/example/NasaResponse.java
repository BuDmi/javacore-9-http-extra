package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDate;

public class NasaResponse {
    private String copyright;
    private Timestamp date;
    private String explanation;
    private String hdUrl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public NasaResponse(
        @JsonProperty("copyright") String copyright,
        @JsonProperty("date") Timestamp date,
        @JsonProperty("explanation") String explanation,
        @JsonProperty("hdurl") String hdUrl,
        @JsonProperty("media_type") String mediaType,
        @JsonProperty("service_version") String serviceVersion,
        @JsonProperty("title") String title,
        @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
            "\ncopyright='" + copyright + '\'' +
            ",\n date=" + date +
            ",\n explanation='" + explanation + '\'' +
            ",\n hdUrl='" + hdUrl + '\'' +
            ",\n mediaType='" + mediaType + '\'' +
            ",\n serviceVersion='" + serviceVersion + '\'' +
            ",\n title='" + title + '\'' +
            ",\n url='" + url + '\'' +
            '}';
    }
}
