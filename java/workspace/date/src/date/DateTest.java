package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
//		System.out.println(date); // Thu Feb 16 20:14:41 KST 2023
//		System.out.println(format.format(date)); // 2023/02/16 20:14:34
//		
//		try {
//			전달된 문자열을 다시 Date 타입으로 바꿀 때
//			Date 타입으로 바꿔야 연산이 가능
//			date = format.parse("2024/05/12 10:22:11");
//			System.out.println(date);
//		} catch (ParseException e) {;}
		
//		Calendar calendar = Calendar.getInstance();
//		format을 사용해야 하는 경우 아래와 같이 format 인자에 calendar를 넘겨서 사용
//		System.out.println(format.format(calendar.getTime()));
		
//		년월일을 한 줄에 간편하게 설정하는 방법
//		LocalDate localDate = LocalDate.of(2020, 12, 3);
//		String format = localDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
//		
//		System.out.println(localDate);
//		System.out.println(format); // 2020년 12월 03일
//		
//		System.out.println(localDate.getMonthValue());
//		System.out.println(date.getMonth()); // 0~11 <- 차라리 localDate나 calendar를 사용하자..
		
//		LocalDateTime localDateTime = LocalDateTime.of(2010,  4, 5, 10, 0);
//		String foramt = localDateTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
//				
//		System.out.println(localDateTime); // 2010-04-05T10:00
//		System.out.println(foramt); // 2010년 04월 05일 10시 00분 00초
		
//		LocalDate localDate = LocalDate.parse("2025-05-04");
		LocalDate localDate = LocalDate.parse("2025/05/04".replace("/", "-"));
		System.out.println(localDate);
		
	}
}
