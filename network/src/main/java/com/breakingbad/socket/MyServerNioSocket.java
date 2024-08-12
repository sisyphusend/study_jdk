package com.breakingbad.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class MyServerNioSocket {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        Handler handler = new Handler(1024);


        while(true){
            if(selector.select(3000)==0){
                System.out.println("等待请求超时");
                continue;
            }
            System.out.println("处理请求");
            Iterator<SelectionKey> keyIterator =selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                try{
                    if(key.isAcceptable()){
                        handler.handleRead(key);
                    }
                }catch (IOException e){
                    keyIterator.remove();
                    continue;
                }
                keyIterator.remove();
            }
        }

    }


}
