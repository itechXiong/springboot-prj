package com.xitech.app.bootstrap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ReactorServerMain {
	
	private ServerSocketChannel serverChannel = null;
	
	private Selector selector = null;
	
	private final int cpuNum = Runtime.getRuntime().availableProcessors();
	
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(cpuNum);
	
	public static void main(String[] arg) {
		try {
			System.out.println("***********server init listening ***************");
			new ReactorServerMain().init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void init() throws IOException {
		this.selector = Selector.open();
		this.serverChannel =  ServerSocketChannel.open();
		this.serverChannel.configureBlocking(false);
		this.serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		this.serverChannel.socket().bind(new InetSocketAddress(8888));
		while(true) {
			this.selector.select();
			Set<SelectionKey> selectionKey = this.selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKey.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
				if(key.isAcceptable()) {
					SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
					socketChannel.write(ByteBuffer.wrap(
				            new String("send message to client").getBytes()));
					threadPool.execute(new SubReactorServer(socketChannel));
				}
			}
			
		}
		
	}
}
