package com.company.designPattern.proxy;

public class Browser implements IBrowser{

    private String url;

    public Browser(String url)
    {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("Browser Loading html from : " + url);
        return new Html(url);
    }
}
