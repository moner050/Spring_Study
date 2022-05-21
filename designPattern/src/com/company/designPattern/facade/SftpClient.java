package com.company.designPattern.facade;

public class SftpClient {

    // 모든 의존성을 가져간다
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    // 생성자에서 다 받아온다.
    public SftpClient(Ftp ftp, Reader reader, Writer writer)
    {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    // 오버로딩 시켜준다음 전부 다 받아와준다.
    public SftpClient(String host, int port, String path, String fileName)
    {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    // 연결
    public void connect()
    {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    // 연결 해제
    public void disConnect()
    {
        writer.fileDisConnect();
        reader.fileDisconnect();
        ftp.disConnect();
    }

    // 파일 읽기
    public void read()
    {
        reader.fileRead();
    }

    // 파일 쓰기
    public void write()
    {
        writer.write();
    }
}
