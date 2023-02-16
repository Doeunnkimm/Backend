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
//			���޵� ���ڿ��� �ٽ� Date Ÿ������ �ٲ� ��
//			Date Ÿ������ �ٲ�� ������ ����
//			date = format.parse("2024/05/12 10:22:11");
//			System.out.println(date);
//		} catch (ParseException e) {;}
		
//		Calendar calendar = Calendar.getInstance();
//		format�� ����ؾ� �ϴ� ��� �Ʒ��� ���� format ���ڿ� calendar�� �Ѱܼ� ���
//		System.out.println(format.format(calendar.getTime()));
		
//		������� �� �ٿ� �����ϰ� �����ϴ� ���
//		LocalDate localDate = LocalDate.of(2020, 12, 3);
//		String format = localDate.format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd��"));
//		
//		System.out.println(localDate);
//		System.out.println(format); // 2020�� 12�� 03��
//		
//		System.out.println(localDate.getMonthValue());
//		System.out.println(date.getMonth()); // 0~11 <- ���� localDate�� calendar�� �������..
		
//		LocalDateTime localDateTime = LocalDateTime.of(2010,  4, 5, 10, 0);
//		String foramt = localDateTime.format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� HH�� mm�� ss��"));
//				
//		System.out.println(localDateTime); // 2010-04-05T10:00
//		System.out.println(foramt); // 2010�� 04�� 05�� 10�� 00�� 00��
		
//		LocalDate localDate = LocalDate.parse("2025-05-04");
		LocalDate localDate = LocalDate.parse("2025/05/04".replace("/", "-"));
		System.out.println(localDate);
		
	}
}
