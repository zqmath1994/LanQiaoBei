package 高师日记;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		calendar.set(1777, 4, 30);
		calendar.add(Calendar.DAY_OF_YEAR,8113);
	System.out.println(calendar.get(Calendar.YEAR)+
			"-"+calendar.get(Calendar.MONTH)
			+"-"+calendar.get(Calendar.DAY_OF_MONTH));
	}

}
