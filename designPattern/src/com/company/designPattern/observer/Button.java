package com.company.designPattern.observer;

public class Button {

    private String name;
    private IButtonListener buttonListener;

    public Button(String name)
    {
        this.name = name;
    }

    // 클릭이벤트가 발생하면 리스너에 메세지를 넘겨준다.
    public void click(String message)
    {
        buttonListener.clickEvent(message);
    }

    public void addListener(IButtonListener buttonListener)
    {
        this.buttonListener = buttonListener;
    }

}
