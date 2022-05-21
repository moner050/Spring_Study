package com.company.designPattern.observer;

public class MainObserver {
    public static void main(String[] args) {

        Button button = new Button("버튼");

        // 버튼에 클릭이 발생하면 메시지를 리스너를 통해서 전달해주는 형태를 옵저버 형태라고 한다.
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");
        button.click("메시지 전달 : click5");

    }
}
