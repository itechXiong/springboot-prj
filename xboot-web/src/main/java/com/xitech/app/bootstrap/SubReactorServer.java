package com.xitech.app.bootstrap;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SubReactorServer implements Runnable{

	private Selector selector = null;
	
	private SocketChannel socketChannel = null;
	
	public SubReactorServer(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
	
	public void init() throws IOException {
		this.selector = Selector.open();
		this.socketChannel.configureBlocking(false);
		this.socketChannel.register(this.selector, SelectionKey.OP_READ|SelectionKey.OP_CONNECT);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			init();
			while(true) {
				this.selector.select();
				Set<SelectionKey> selectionKey = this.selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKey.iterator();
                while (iterator.hasNext()) {
                     SelectionKey key = iterator.next();
                     iterator.remove();
				
					if(key.isReadable()) {
						readHanlder((SocketChannel)key.channel());
					}else if(key.isWritable()) {
						
					}
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void readHanlder(SocketChannel channel) throws IOException {
		System.out.println(Thread.currentThread().getName()+" is readable ***********");
		System.out.println(Thread.currentThread().getName()+ "  client content*************");
		ByteBuffer bf = ByteBuffer.allocate(1024);
		channel.read(bf);
		byte[] data = bf.array();
        String message = new String(data);
        System.out.println("message :"+message);
		System.out.println(Thread.currentThread().getName()+ "  client content end*************");
		System.out.println(Thread.currentThread().getName()+ "  server write*************");
		ByteBuffer bfs = Utils.getByteBuffer("  server write    ");
		channel.write(bfs);
	}
	
	public void writeHanlder() {
		System.out.println(Thread.currentThread().getName()+" is writeble ===========");
	}
	
}
