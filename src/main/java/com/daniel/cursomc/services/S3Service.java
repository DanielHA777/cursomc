package com.daniel.cursomc.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.daniel.cursomc.resources.exception.FileException;


@Service
public class S3Service {

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private static AmazonS3 s3client;

	@Value("${s3.bucket}")
	private static String bucketName;

	public URI uploadFile(MultipartFile multipartFile) { // faz upload do arquivo no s3
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}

	public static URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando upload");
			s3client.putObject(bucketName, fileName, is, meta);
			LOG.info("Upload finalizado");
			//pegando url direto na amazon
			return s3client.getUrl(bucketName, fileName).toURI();//retorna obj do tipo url
		} catch (URISyntaxException e) {
			throw new FileException("Erro ao converter URL para URI");
		}
	}
}