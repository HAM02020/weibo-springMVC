import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest extends BaseTest {
    @Test
    public void formatDate() throws ParseException {
        String dateStr="Sat Jul 04 15:14:27 +0800 2020";

        SimpleDateFormat wbDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date date = wbDateFormat.parse(dateStr);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(date);

        System.out.println(result);

    }
}
