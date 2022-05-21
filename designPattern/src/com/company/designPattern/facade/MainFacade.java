package com.company.designPattern.facade;

public class MainFacade {
    public static void main(String[] args) {

        Ftp ftpClient = new Ftp("www.mysite.com", 22, "/home/etc");
        // ftp 연결
        ftpClient.connect();
        // 해당 디렉토리로 이동
        ftpClient.moveDirectory();

        // 파일을 연결하고 내용을 쓴다.
        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        // 파일을 연결하고 내용을 읽어온다.
        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        // 연결 해제
        writer.fileDisConnect();
        reader.fileDisconnect();
        ftpClient.disConnect();

        // facade 패턴을 이용해 의존성들을 안쪽으로 숨겨줘 간략화시키기.
        SftpClient sftpClient = new SftpClient("www.mysite.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.write();

        sftpClient.read();

        sftpClient.disConnect();
    }
}
