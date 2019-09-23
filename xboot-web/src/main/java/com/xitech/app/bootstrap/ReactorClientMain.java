package com.xitech.app.bootstrap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ReactorClientMain {

	private SocketChannel socketChannel = null;
	
	private Selector selector = null;
	
	private final int cpuNum = Runtime.getRuntime().availableProcessors();
	
	private ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(cpuNum);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {
			//new ReactorClientMain().init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ByteBuffer bf = ByteBuffer.wrap("12312312".getBytes());
		System.out.println(bf.toString());
		
	}
	
	public void init() throws IOException {
		this.selector = Selector.open();
		this.socketChannel = SocketChannel.open();
		this.socketChannel.configureBlocking(false);
		this.socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
		this.socketChannel.connect(new InetSocketAddress(8888));
		
		while(true) {
			this.selector.select();
			Set<SelectionKey> selectionKey = this.selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKey.iterator();
            while (iterator.hasNext()) {
                 SelectionKey key = iterator.next();
                 iterator.remove();
				if(key.isConnectable()) {
					SocketChannel channel = (SocketChannel) key.channel();
					if(channel.isConnectionPending()){
			               channel.finishConnect();//如果正在连接，则完成连接
			        }
					System.out.println(Thread.currentThread().getName()+ "  client connection*************");
					ByteBuffer bf = Utils.getByteBuffer("  client write    ");
					System.out.println("client content "+ Utils.getString(bf));
					channel.write(bf);
					//channel.configureBlocking(false);
					channel.register(this.selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
				}else if(key.isReadable()) {
					
					SocketChannel channel = (SocketChannel) key.channel();
					
					System.out.println(Thread.currentThread().getName()+ "  client read*************");
					System.out.println(Thread.currentThread().getName()+ "  server content*************");
					ByteBuffer bf = ByteBuffer.allocate(1024);
					channel.read(bf);
					byte[] data = bf.array();
			        String message = new String(data);
			        System.out.println("message :"+message);
					System.out.println(Utils.getString(bf));
					System.out.println(Thread.currentThread().getName()+ "  server content end*************");

				}else if(key.isWritable()) {
					System.out.println("writeable ....................");
				}
				
				
			}
		}
	}

}
