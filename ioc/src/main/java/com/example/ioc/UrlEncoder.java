package com.example.ioc;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Spring Container 에서 관리를 해준다.
@Component
public class UrlEncoder implements IEncoder {

    public String encode(String message)
    {
        try
        {
            return URLEncoder.encode(message, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
