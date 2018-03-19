package com.azure.util;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.azure.config.AzureConfig;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

/**
 * @author zhuCan
 *
 * @DATE  2018年2月23日
 *
 * @TIME  上午10:45:03
 */
public class ContainerUtil {

	public static CloudBlobContainer getContainer(){
		try {
			CloudStorageAccount account=CloudStorageAccount.parse(AzureConfig.storageConnectionString);
		
			CloudBlobClient client=account.createCloudBlobClient();
			
			CloudBlobContainer cloudBlobContainer=client.getContainerReference("resource");
			
			cloudBlobContainer.createIfNotExists();
			
			return cloudBlobContainer;
		
		} catch (InvalidKeyException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
