package bjtu;

import bjtu.util.FileUtils;

public class Main {
	/**
	 * 神策杯 关键词文件
	 */
	private static String keyWordFile = Global.keyWordFile;
	/**
	 * 关键词格式转换后输出文件
	 */
	private static String goalKeyWordFile = Global.goalKeyWordFile;
	/**
	 * 神策杯 原始数据文件
	 */
	private static String allDataFile = Global.allDataFile;
	/**
	 * 格式转换后的输出文件
	 */
	private static String goalDataDir = Global.goalDataDir;

	/**
	 * 神策杯关键词文件格式转换
	 * @param keyWordFile
	 * @param goalKeyWordFile
	 */
	public static void keyWordChange(String keyWordFile,
			String goalKeyWordFile) {
		FileUtils.keyWordChange(keyWordFile, goalKeyWordFile);

	}

	/**
	 * 神策杯数据格式转换
	 * @param keyWordFile
	 * @param allDataFile
	 * @param goalDataDir
	 */
	public static void dataChange(String keyWordFile,
			String allDataFile, String goalDataDir) {
		FileUtils.dataChange(keyWordFile, allDataFile, goalDataDir);
	}

	public static void main(String[] args) {
		keyWordChange(keyWordFile, goalKeyWordFile);
		dataChange(keyWordFile, allDataFile, goalDataDir);
	}

}
