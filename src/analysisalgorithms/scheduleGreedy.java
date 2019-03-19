/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author gavis
 */
public class scheduleGreedy {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("How many activities?");
                
                Scanner sc=new Scanner(System.in);
                
                int size=sc.nextInt();
                
                ArrayList<ActivityGreedy> act=new ArrayList<ActivityGreedy>(size);
                
                for(int i=1;i<=size;i++){
                    
                    System.out.println("Enter start time for activity "+i);
                    int start = sc.nextInt();
                    
                    System.out.println("Enter end time for activity "+i);
                    int end=sc.nextInt();
                    
                    act.add(new ActivityGreedy(start, end));
                }
                Collections.sort(act);
                
//                System.out.print("\n");
//                for (ActivityGreedy itemAct : act) {   
//                    System.out.println(itemAct.getStartTime() + " " + itemAct.getEndTime()+"\n");
//                }
                
                ArrayList<HallGreedy> listOfHallsCreated=new ArrayList<HallGreedy>();
                ArrayList<HallGreedy> allocatedHalls=new ArrayList<HallGreedy>();
                
                Iterator<ActivityGreedy> itrAct=act.iterator();
                
                while(itrAct.hasNext()){
                    ActivityGreedy lecture=itrAct.next();
                    HallGreedy hall=null;
                    
                    if(listOfHallsCreated.isEmpty()){
                        hall=new HallGreedy();
                        listOfHallsCreated.add(hall);
                    }
                    else{
                    for(int i=0;i<allocatedHalls.size();i++){
                        if(allocatedHalls.get(i).hallfreeAt()==lecture.getStartTime()){
                          // System.out.println(allocatedHalls.get(i).hallfreeAt() + " and " + lecture.getStartTime()+", ");
                            hall=allocatedHalls.remove(i);
                            break;
                        }
                        else if(allocatedHalls.get(i).hallfreeAt()<lecture.getStartTime()){
                          // System.out.println(allocatedHalls.get(i).hallfreeAt() + " and " + lecture.getStartTime()+", ");
                            hall=allocatedHalls.remove(i);
                            break;
                        }
                        else{
                            hall=new HallGreedy();
                            listOfHallsCreated.add(hall);
                            break;
                        }
                    
                    }
                    }
                    
                    hall.setHallFreeTime(lecture.getEndTime());
                    hall.allocateLecture(lecture);
                    allocatedHalls.add(hall);
                }
                
                
                int no = 0;
		for (HallGreedy h : listOfHallsCreated) {

			System.out.print("\n\nLecture Hall 10" + no++ + " : ");
			for (ActivityGreedy lectureActivity : h.getListOfLec()) {
				
					System.out.print(lectureActivity.getStartTime() + " - " + lectureActivity.getEndTime()+", ");

			}

		}
                System.out.print("\n\n");
                System.out.println("The minimum number of Lecture Halls required: "+listOfHallsCreated.size());
                System.out.print("\n");

	}
}
