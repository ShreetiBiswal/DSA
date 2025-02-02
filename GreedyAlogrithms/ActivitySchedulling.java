package GreedyAlogrithms;
import java.util.*;
class Activity{
    int index,startTime,finishTime;

    Activity(int index,int startTime,int finishTime){
        this.index=index;
        this.startTime=startTime;
        this.finishTime=finishTime;
    }

    int getFinishTime(){
        return finishTime;
    }

    int getStartTime(){
        return  startTime;
    }


    public String toString(){
        return  "Activity-"+index+")Start:"+startTime+",Finish:"+finishTime;
    }



}
public class ActivitySchedulling {

  static public ArrayList<Activity> ScheduledActivies(int[]s,int[]f){
        Activity[]Activities=new Activity[s.length];
        for(int i=0;i<s.length;i++){
            Activities[i]=new Activity(i,s[i],f[i]);
        }

        Arrays.sort(Activities,(Activity A,Activity B)->(A.getFinishTime()-B.getFinishTime()));

        ArrayList<Activity> ScheduledResource=new ArrayList<>();
        ScheduledResource.add(Activities[0]);
        int k=0;
        for(int i=1;i<Activities.length;i++){
            if(Activities[i].getStartTime()>=Activities[k].getFinishTime()){
                ScheduledResource.add(Activities[i]);
                k=i;
            }
        }

        return ScheduledResource;
    }

   static void showResources(ArrayList<Activity>List){
        for(Activity Activity:List){
            System.out.println(Activity);
        }
    }

   static void ScheduleActivities(int[]s,int[]e){
        ArrayList<Activity>ScheduledList=ScheduledActivies(s,e);
       System.out.println("SCHEDULED ACTIVITY:");
        showResources(ScheduledList);
    }

    public static void main(String[] args) {
        int[]s={1,2,3,4,2,2,5};
        int[]f={2,6,5,4,9,7,9};
        ScheduleActivities(s,f);
    }
}
