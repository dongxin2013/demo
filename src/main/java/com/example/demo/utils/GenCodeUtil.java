package com.example.demo.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GenCodeUtil {

	public static void genCode(String outputDir, String moduleName, String tableName, String author) {
		// 父路径
		String parentPath = "com.example.demo";
		// 表前缀
		String tablePrefix = "";

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(outputDir)
				.setAuthor(author)
				.setFileOverride(true)// 是否覆盖文件
				.setActiveRecord(true)// 开启 activeRecord 模式
				.setEnableCache(false)// XML 二级缓存
				.setBaseResultMap(true)// XML ResultMap
				.setBaseColumnList(true)// XML columList
				.setMapperName("%sMapper")
				.setXmlName("%sMapper")
				.setOpen(true);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.SQL_SERVER)
				.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.setUrl("jdbc:sqlserver://117.157.24.137:1433;DatabaseName=temp")
				.setUsername("sa")
				.setPassword("Root123");
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(parentPath)
				.setModuleName(moduleName)
				.setController("controller")
				.setEntity("entity")
				.setService("service")
				.setServiceImpl("service.impl")
				.setMapper("mapper")
				.setXml("mapper.perf2");
		mpg.setPackageInfo(pc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(false);
		strategy.setRestControllerStyle(true);
		strategy.setInclude(tableName);
		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(tablePrefix);
		mpg.setStrategy(strategy);
		mpg.execute();
	}

	public static void main(String[] args) {
		// 代码生成路径
		String outputDir = "E:\\个人积累\\code\\demo\\src\\main\\java";
		// 作者
		String author = "董鑫";
		// 模块名
		String moduleName = "temp";
		// 表名
		String tableName = "user_temp";
		genCode(outputDir, moduleName, tableName, author);
	}
}
