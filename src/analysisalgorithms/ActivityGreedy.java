/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;

/**
 *
 * @author gavis
 */
public class ActivityGreedy implements Comparable<ActivityGreedy>{
    private Integer startTime;
    private Integer endTime;
    
    public ActivityGreedy(Integer startTime, Integer endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
    
    
    @Override
	public int compareTo(ActivityGreedy compAct) {
		
                int startTimecompAct=((ActivityGreedy)compAct).getStartTime();
		
                return this.getStartTime()-startTimecompAct;
			
		
	}
    
}
