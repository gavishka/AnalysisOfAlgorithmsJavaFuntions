/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;

import java.util.ArrayList;

/**
 *
 * @author gavis
 */
public class HallGreedy implements Comparable<HallGreedy>{
    private Integer freeTime;
    
    private ArrayList<ActivityGreedy> listOfLectures=new ArrayList<ActivityGreedy>();
    
    public Integer hallfreeAt(){
        return freeTime;
    }
    
    public void setHallFreeTime(Integer freeTimeGet){
        this.freeTime=freeTimeGet;
    }
    
    public ArrayList<ActivityGreedy> getListOfLec(){
        return listOfLectures;
    }
    
    public void allocateLecture(ActivityGreedy activity){
        this.listOfLectures.add(activity);
    }
    
    @Override
	public int compareTo(HallGreedy o) {
		// TODO Auto-generated method stub
		return this.hallfreeAt().compareTo(o.hallfreeAt());
	}
}
