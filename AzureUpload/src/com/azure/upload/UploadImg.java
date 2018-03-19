package com.azure.upload;

import java.io.File;

import com.azure.config.FileConfig;
import com.azure.util.AzureUpload;
import com.azure.util.ContainerUtil;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

/**
 * @author zhuCan
 *
 * @DATE 2018年2月23日
 *
 * @TIME 上午10:01:01
 */
public class UploadImg {

	public static void main(String[] args) {
		CloudBlobContainer cloudBlobContainer = ContainerUtil.getContainer();

		File imgFolder = new File(FileConfig.FileFolder);
		File[] folderes = imgFolder.listFiles();

		for (File file : folderes) {
			File[] imgs = file.listFiles();
			for (File img : imgs) {
				if (img.isFile()) {
					AzureUpload.uploadImage(cloudBlobContainer, img);
				}
			}
		}
	}
}
