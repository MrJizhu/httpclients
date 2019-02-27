package quest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 实现一个类TestLimited
 *
 * Created by jizhu on 2019/2/27.
 */
public class CheckCalledTimesInPeriod {
    private long startMills;
    private int limitMinute;
    private int limitCount;
    private Icallee callee;

    static private int count=0;

    public CheckCalledTimesInPeriod(int limitMinute,long startMills,  int limitCount){
        this.startMills=startMills;
        this.limitCount=limitCount;
        this.limitMinute=limitMinute;
        callee=new Callee();
    }

    public synchronized void execute(){
        long nowMills=System.currentTimeMillis();
        count++;
        if(nowMills<=startMills+limitMinute*60000&count<=limitCount){
            callee.play();
        }

        Calendar c=Calendar.getInstance();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-DD-mm hh:mm:ss");
        CallerRunning.sb.append("You are calling = "+count+" times.The time is = "+dateFormat.format(c.getTime())+"\r\n");
        System.out.println("you are calling "+count+" times.The time is = "+dateFormat.format(c.getTime())+"\r\n");

    }
}
