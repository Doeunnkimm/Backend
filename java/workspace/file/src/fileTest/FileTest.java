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

//	메소드 안에서 발생한 에러를 아예 메소드를 사용할 때 잡는 것
	public static void main(String[] args) throws IOException {
//		절대 경로: 어디에서 작성해도 찾아갈 수 있는 경로, C:/a/b
//		상대 경로: 현재 위치에 따라 변경되는 경로, .., ., ./a. a

//		현재 경로는 프로젝트 폴더
//		true를 추가하면 이어쓰기가 됨
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
//		true 없으면 덮어쓰기 됨
//		bufferedWriter.write("반갑습니다. \n"); // flush를 안 했기 떄문아직 버퍼 안에 있음
//		bufferedWriter.close(); // flush

//		파일이 없다면 FileNotFoundException
//		BufferedReader bufferedReader = new BufferedReader(new FileReader("test2.txt"));

		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader("test.txt"));
			String line = null;
//			bufferedReader.readLine(); // 가져올 게 없으면 null을 리턴함, 줄바꿈 문자는 안 가져옴
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line); // println 때문에 줄바꿈 문자를 가져온 것처럼 보이는 것
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			try {
				if (bufferedReader != null) { // 열려 있다면
					bufferedReader.close();
				}
			} catch (Exception e) {
//					에러를 직접 발생시켜서 실행을 중지
				throw new RuntimeException(e);
			}
		}

		File file = new File("test.txt");
		file.delete(); // 위에서 파일을 닫아야 삭제도 되는 것
	}
}
