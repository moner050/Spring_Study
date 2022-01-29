package com.company.designPattern.facade;

public class SftpClient {

    // 모든 의존성을 가져간다
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer)
    {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SftpClient(String host, int port, String path, String fileName)
    {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect()
    {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect()
    {
        writer.fileDisConnect();
        reader.fileDisconnect();
        ftp.disConnect();
    }

    public void read()
    {
        reader.fileRead();
    }

    public void write()
    {
        writer.write();
    }
}
