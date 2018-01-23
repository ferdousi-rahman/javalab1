import edu.duke.*;
import jdk.jfr.events.FileReadEvent;

import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer()
    {
        records = new ArrayList<>();
    }
    public <records, records> void readFile(String fileName) 
    {
        records.clear();
        if (fileName.startsWith("http")) 
        {
            URLResource urlResource = new URLResource(fileName);
            for (String line : urlResource.lines())
                records.add(WebLogParser.parseEntry(line));

        }

        else{
            FileResource fileResource = new FileResource(fileName);
            for(String line : fileResource.lines())
                records.add(WebLogParser.parseEntry(line));
        }
    }

    public void printAll(){
        for(LogEntry logEntry : records)
            System.out.println(logEntry);
    }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIP = new ArrayList<>();
        for(LogEntry logEntry : records)
            if(!uniqueIP.contains(logEntry.getIpAddress()))
                uniqueIP.add(logEntry.getIpAddress());
        return uniqueIP.size();
    }

    public int countUniqueIPs(ArrayList<LogEntry> list)
    {
        ArrayList<String> uniqueIP = new ArrayList<>();
        for(LogEntry logEntry : list)
            if(!uniqueIP.contains(logEntry.getIpAddress()))
                uniqueIP.add(logEntry.getIpAddress());
        return uniqueIP.size();
    }

    public void printAllHigherThanNum(int num)
    {
        for(LogEntry logEntry : records){
            if(logEntry.getStatusCode() > num)
                System.out.println(logEntry);
        }
    }

    public void uniqueIPVisitsOnDay(String d)
    {
        String targetMonth = d.substring(0,3);
        String targetDay = d.substring(4,6);

        System.out.println(targetDay + " " + targetMonth);

        for(LogEntry logEntry : records)
        {
            String date = logEntry.getAccessTime().toString();
            String month = date.substring(4,7);
            String day = date.substring(8,10);
            if(day.equals(targetDay) && month.equals(targetMonth))
                System.out.println(logEntry);
        }
    }

    public int countUniqueIPsInRange(int low, int high)
    {
        ArrayList<LogEntry> list = new ArrayList<>();

        for(LogEntry logEntry : records){
            int status = logEntry.getStatusCode();
            if(status >= low && status <= high)
                list.add(logEntry);
        }

        return countUniqueIPs(list);
    }

    public HashMap<String, Integer> countVisitsPerIP()
    {
        HashMap<String, Integer> countsPerIP = new HashMap<>();

        for(LogEntry logEntry : records)
        {
            String IP = logEntry.getIpAddress();
            if(countsPerIP.containsKey(IP))
                countsPerIP.put(IP, countsPerIP.get(IP) + 1);
            else
                countsPerIP.put(IP, 1);
        }

        return countsPerIP;
    }

    public HashMap<String, Integer> countVisitsPerIP(ArrayList<String>IPList)
    {
        HashMap<String, Integer> countsPerIP = new HashMap<>();

        for(String IP : IPList)
        {
            if(countsPerIP.containsKey(IP))
                countsPerIP.put(IP, countsPerIP.get(IP) + 1);
            else
                countsPerIP.put(IP, 1);
        }

        return countsPerIP;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> countsPerIP)
    {
        int max = 0;
        for(String IP : countsPerIP.keySet())
            max = Math.max(max, countsPerIP.get(IP));
        return max;
    }

    public ArrayList<String> iPsMostVisits (HashMap<String, Integer> countsPerIP)
    {
        int maxVisit = mostNumberVisitsByIP(countsPerIP);
        ArrayList<String>list = new ArrayList<>();
        for(String IP : countsPerIP.keySet())
            if(countsPerIP.get(IP) == maxVisit)
                list.add(IP);
        return list;
    }

    public HashMap<String, ArrayList<String> > iPsForDays()
    {
        HashMap<String, ArrayList<String> >countsPerDay = new HashMap<>();
        String day;

        for(LogEntry logEntry : records)
        {
            String date = logEntry.getAccessTime().toString();
            day = date.substring(4, 10);
            if(!countsPerDay.containsKey(day))
                countsPerDay.put(day, new ArrayList<>());
            countsPerDay.get(day).add(logEntry.getIpAddress());
        }

        return countsPerDay;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String> > countsPerDay) 
    {
        String maxDay = "";
        int max = 0;
        for (String day : countsPerDay.keySet())
        {
            if (countsPerDay.get(day).size() > max) 
            {
                max = countsPerDay.get(day).size();
                maxDay = day;
            }
        }
        return maxDay;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String> > countsPerDay, String day)
    {
        HashMap<String, Integer> countsPerIP = countVisitsPerIP(countsPerDay.get(day));
        return iPsMostVisits(countsPerIP);
    }
}