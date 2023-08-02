package com.mobis.im.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

/**
 * 파일 읽어오기
 * 
 * Auth : junga
 * Date : 2023.07.17
 */
public class ReadFile {
	
	public static StringBuffer readFile(String classPath) throws IOException {
		ClassPathResource resource = new ClassPathResource(classPath);
		
		Path path = Paths.get(resource.getURI());
		StringBuffer sb = new StringBuffer();
		
		List<String> content = Files.readAllLines(path);
		for(int i = 0; i < content.size(); i++) {
			sb.append(content.get(i));
		}
		return sb;
	}
}
