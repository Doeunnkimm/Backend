package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileTest {

//	�޼ҵ� �ȿ��� �߻��� ������ �ƿ� �޼ҵ带 ����� �� ��� ��
	public static void main(String[] args) throws IOException {
//		���� ���: ��𿡼� �ۼ��ص� ã�ư� �� �ִ� ���, C:/a/b
//		��� ���: ���� ��ġ�� ���� ����Ǵ� ���, .., ., ./a. a

//		���� ��δ� ������Ʈ ����
//		true�� �߰��ϸ� �̾�Ⱑ ��
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
//		true ������ ����� ��
//		bufferedWriter.write("�ݰ����ϴ�. \n"); // flush�� �� �߱� �������� ���� �ȿ� ����
//		bufferedWriter.close(); // flush

//		������ ���ٸ� FileNotFoundException
//		BufferedReader bufferedReader = new BufferedReader(new FileReader("test2.txt"));

		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader("test.txt"));
			String line = null;
//			bufferedReader.readLine(); // ������ �� ������ null�� ������, �ٹٲ� ���ڴ� �� ������
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line); // println ������ �ٹٲ� ���ڸ� ������ ��ó�� ���̴� ��
			}

		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} finally {
			try {
				if (bufferedReader != null) { // ���� �ִٸ�
					bufferedReader.close();
				}
			} catch (Exception e) {
//					������ ���� �߻����Ѽ� ������ ����
				throw new RuntimeException(e);
			}
		}

		File file = new File("test.txt");
		file.delete(); // ������ ������ �ݾƾ� ������ �Ǵ� ��
	}
}
