package org.mybatis.generator.plugin;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class MybatisGenerator {

	public static void main(String[] args) throws IOException {
		ClassPathResource res = new ClassPathResource("mybatisGenerator/mybatisGeneratorConfig.xml");
		System.out.println(res.getFile().toPath());
		String[] arg = { "-configfile", res.getFile().toPath().toString(), "-overwrite" };
		ShellRunner.main(arg);
	}
}