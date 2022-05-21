package com.company.designPattern.facade;

public class Reader {

    private String fileName;

    // 생성자에서 fileName 을 받음
    public Reader(String fileName)
    {
        this.fileName = fileName;
    }

    // 파일 연결
    public void fileConnect()
    {
        String msg = String.format("Reader %s 로 연결합니다.",fileName);
        System.out.println(msg);
    }

    // 파일 읽어오기
    public void fileRead()
    {
        String msg = String.format("Reader %s 의 내용을 읽어옵니다.",fileName);
        System.out.println(msg);
    }

    // 파일 연결 해제
    public void fileDisconnect()
    {
        String msg = String.format("Reader %s 로 연결을 종료합니다.",fileName);
        System.out.println(msg);
    }
}
