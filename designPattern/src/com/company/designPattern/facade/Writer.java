package com.company.designPattern.facade;

public class Writer {

    private String fileName;

    // 생성자에서 fileName 을 받음
    public Writer(String fileName)
    {
        this.fileName = fileName;
    }

    // 파일 연결
    public void fileConnect()
    {
        String msg = String.format("Writer %s 로 연결합니다.",fileName);
        System.out.println(msg);
    }

    // 파일 연결 해제
    public void fileDisConnect()
    {
        String msg = String.format("Writer %s 로 연결 종료 합니다.",fileName);
        System.out.println(msg);
    }


    // 파일 쓰기
    public void write()
    {
        String msg = String.format("Writer %s 로 파일 쓰기를 합니다.",fileName);
        System.out.println(msg);
    }
}
