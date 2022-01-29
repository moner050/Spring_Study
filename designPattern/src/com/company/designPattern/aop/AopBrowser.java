package com.company.designPattern.aop;

import com.company.designPattern.proxy.Html;
import com.company.designPattern.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    // AOP 는 관점지향이여서 앞과 뒤를 체크할 용도.
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after)
    {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();
        if(html == null)
        {
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);
            // 메소드 자체가 빠를 수 있으니 1.5초 로딩시간 부여.
            try
            {
                Thread.sleep(1500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        after.run();
            System.out.println("AopBrowser html cache : " + url);

        return null;
    }
}
