package com.obj.exercise;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class GregorianCalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); // Calendar is abstract class, so cannot use new to create instance
        String[]month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[]weekday = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        System.out.println("year: " + cal.get(Calendar.YEAR));
        System.out.println("month: " + month[cal.get(Calendar.MONTH)]); // month: .get(Calendar.MONTH)+1
        System.out.println("date: " + cal.get(Calendar.DATE));
        System.out.println("hour: " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute: " + cal.get(Calendar.MINUTE));
        System.out.println("second: " + cal.get(Calendar.SECOND));
        System.out.println("week: " + weekday[cal.get(Calendar.DAY_OF_WEEK)]);
        // created a new object using GregorianCalendar
        GregorianCalendar obj = new GregorianCalendar(2021,02,05);
        obj.setTimeInMillis(1234567898765L);
        System.out.println("the date is: " + obj.get(Calendar.YEAR) + " " +
                month[obj.get(Calendar.MONTH)] + " "
                + obj.get(Calendar.DATE));
        int days = obj.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("days in gap: " + days);//not total days difference
    }
}


