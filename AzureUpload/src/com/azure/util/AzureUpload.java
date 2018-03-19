package com.azure.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月23日
 *
 * @TIME  上午10:53:37
 */
public class AzureUpload {

	public static void uploadImage(CloudBlobContainer cloudBlobContainer,File file){
		String fileName=file.getParentFile().getName()+"\\"+file.getName();
		
		
		CloudBlockBlob blob = null;
		try {
			blob = cloudBlobContainer.getBlockBlobReference(fileName);
		} catch (URISyntaxException | StorageException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.err.println("上传图片");
			blob.upload(new FileInputStream(file), file.length());
		} catch (StorageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
