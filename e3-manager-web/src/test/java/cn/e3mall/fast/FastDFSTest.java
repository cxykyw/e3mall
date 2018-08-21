package cn.e3mall.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDFSTest {

	@Test
	public void testUpload() throws Exception{
		//先创建一个配置文件，文件名随意，内容就是tracker服务器地址
		//使用全局对象加载配置文件
		ClientGlobal.init("F:\\Eclipse\\eclipse-j2ee-企业版\\eclipse-j2ee-workspace\\e3-manager-web\\src\\main\\resources\\config\\client.conf");
		
		//创建一个trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		
		//获取trackerServer
		TrackerServer trackerServer = trackerClient.getConnection();
		
		//创建一StorageServer，可以为空
		StorageServer storageServer = null;
		
		//StorageClient
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		
		//storageClient上传文件
		String[] strs = storageClient.upload_file("E:/a1.jpg", "jpg", null);
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDFS() throws Exception{
		FastDFSClient client = new FastDFSClient("F:\\Eclipse\\eclipse-j2ee-企业版\\eclipse-j2ee-workspace\\e3-manager-web\\src\\main\\resources\\config\\client.conf");
		String str = client.uploadFile("E:/a1.jpg");
		System.out.println(str);
	}
}
