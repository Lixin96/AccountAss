package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static String getDatetime(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		 return df.format(new Date());
    }
	public static void main(String[] args) {
		System.out.println(DateFormat.getDatetime());
	}

}
