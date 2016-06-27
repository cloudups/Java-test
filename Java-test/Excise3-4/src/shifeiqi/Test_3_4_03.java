package shifeiqi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/*
 * 注意：如果文件夹中含有"System Volume Information"，程序会当掉。
 * 
 * @author feiqishi
 *
 */
public class Test_3_4_03 {
	private int num_file = 0;
	private int num_dir = 0;
	private int size_files = 0;

	/**
	 * 测试方法
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String path = readDir();
		compute(path);
		System.out.println(
				"file num is: " + num_file + "  dir num is: " + num_dir + "  files size is: " + size_files + "B");
	}

	/**
	 * travel ann the files and compute
	 * 
	 * @param path
	 * @throws IOException
	 */
	private void compute(String path) throws IOException {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("file not exists");
			return;
		}

		if (file.isFile()) {
			System.out.println("file name: " + file.getName());
			num_file++;
			size_files += file.length();
		} else if (file.isDirectory()) {
			num_dir++;
			System.out.println("dir name: " + file.getName());
			for (File f : file.listFiles()) {
				compute(f.getAbsolutePath());
			}
		}

	}

	/**
	 * read String from terminal
	 * 
	 * @return
	 * @throws IOException
	 */
	private String readDir() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String str = br.readLine();
		br.close();
		return str;
	}
}
