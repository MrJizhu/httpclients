package quest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jizhu on 2019/2/27.
 */
public class CallerRunning {
    static public StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        long startMills = System.currentTimeMillis();
        long nowMills = startMills;

        CheckCalledTimesInPeriod called = new CheckCalledTimesInPeriod(1, startMills, 60000);

        Calendar c = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sb.append("begin time is = " + format.format(c.getTime()) + "\r\n");

        while (nowMills <= (startMills + 6000)) {
            nowMills = System.currentTimeMillis();
            called.execute();
        }

        Calendar d = Calendar.getInstance();
        sb.append("end time is = " + format.format(d.getTime()) + "\r\n");
        System.out.println(sb.toString());
        writeTxt("d:\\test.txt",sb.toString());
    }

    public static void writeTxt(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();//不存在则创建
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                output.write(content);
                output.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
