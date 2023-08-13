package com.examly.springapp.repository;

import com.examly.springapp.entity.Taskentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
 
@Repository
 public interface TaskRepository  extends JpaRepository<Taskentity,String>{
 Optional<Taskentity> findByTaskId(String taskid);
 void deleteByTaskId(String taskid);

 }


 package com.examly.springapp.service;

 import java.util.List;
 import com.examly.springapp.repository.TaskRepository;
 import com.examly.springapp.entity.Taskentity;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import java.util.Optional;

 @Service
 public class TaskService {
     @Autowired
         private TaskRepository repository;

             public Taskentity saveTask(Taskentity taskentity){
                     repository.save(taskentity);
                             return taskentity;
                                 }

                                     public Taskentity updatetaskStatus(String taskId){
                                             Optional<Taskentity> taskentity = repository.findByTaskId(taskId);
                                                     if(taskentity.isPresent()){
                                                                 taskentity.get().setTaskStatus("Accepted");
                                                                             repository.save(taskentity.get());
                                                                                         return taskentity.get();
                                                                                                 }
                                                                                                         return null;
                                                                                                                 
                                                                                                                     }


                                                                                                                         public String deleteTask(String id){
                                                                                                                                 Optional<Taskentity> taskentity = repository.findByTaskId(id);
                                                                                                                                         if(taskentity.isPresent()){
                                                                                                                                                     repository.deleteByTaskId(id);
                                                                                                                                                                 return"Task Deleted Successfully";
                                                                                                                                                                         }
                                                                                                                                                                                 return "User not Found";
                                                                                                                                                                                     }


                                                                                                                                                                                         public List<Taskentity> getallTasks(){
                                                                                                                                                                                                 return repository.findAll();
                                                                                                                                                                                                     }

                                                                                                                                                                                                         public Taskentity gettaskbyid(String id){
                                                                                                                                                                                                                 Optional<Taskentity> taskentity = repository.findByTaskId(id);
                                                                                                                                                                                                                         if(taskentity.isPresent()){
                                                                                                                                                                                                                                     return taskentity.get();
                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                     return null;
                                                                                                                                                                                                                                                         }

                                                                                                                                                                                                                                                             

                                                                                                                                                                                                                                                             }
