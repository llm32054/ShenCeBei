package bjtu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	/**
	 * 读取单个文件内容
	 * @param file
	 * @return
	 */
	public static List<String> readContent(File file) {
		List<String> list = new ArrayList<String>(700);
		// StringBuilder res = new StringBuilder();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
			// 从文本的第二行开始读取
			// br.readLine();
			while (br.ready()) {
				// 这里可以作相关的处理过程 #todo your code#
				// res.append(br.readLine() + "\n");
				list.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return res.toString();
		return list;
	}

	/**
	 * 写txt文本文件
	 * @param path
	 * @param content
	 */
	public static void Write(String path, String content) {
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.write(content);
			// 1.3刷新输出流
			fw.flush();
			// 1.4关闭输出流
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 神策杯关键词文件格式转换
	 * @param keyWordFile 原始神策杯文件
	 * @param goalKeyWordFile 输出文件
	 */
	public static void keyWordChange(String keyWordFile,
			String goalKeyWordFile) {
		File file = new File(keyWordFile);
		// 读取关键词文件
		List<String> list = FileUtils.readContent(file);
		// 行号
		int num = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split("	");
			FileUtils.Write(goalKeyWordFile,
					(num++) + "：" + arr[1] + "\r\n");
		}
	}

	/**
	 * 神策杯数据格式转换
	 * @param keyWordFile 原始的神策杯关键词文件
	 * @param allDataFile 原始的神策杯数据文件
	 * @param goalDataDir 格式转换后的关键词文件
	 */
	public static void dataChange(String keyWordFile,
			String allDataFile, String goalDataDir) {
		File file = new File(keyWordFile);
		// 读取神策杯关键词文件
		List<String> list = FileUtils.readContent(file);

		File file1 = new File(allDataFile);
		// 读取神策杯 数据文件
		List<String> list1 = FileUtils.readContent(file1);

		int num = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split("	");
			for (int j = 0; j < list1.size(); j++) {
				String[] arr1 = list1.get(j).split("  ");
				if (arr[0].equals(arr1[0])) {
					FileUtils.Write(goalDataDir + num + ".txt",
							"https://www.baidu.com" + "\r\n");
					FileUtils.Write(goalDataDir + num + ".txt",
							arr1[1] + "\r\n");
					FileUtils.Write(goalDataDir + (num++) + ".txt",
							arr1[2] + "\r\n");
				}
			}

		}
	}

}
