/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devware.batch.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author HP
 */
public class Launcher {
    
    
    public static void main (String arg[]){
		
        String[] springConfig = {"org/devware/config/context/readerConfig.xml",
                                 "org/devware/config/context/writerConfig.xml",
                                 "org/devware/config/context/processorConfig.xml",
                                 "org/devware/config/datasource/datasource.xml"};
		
	ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
	JobLauncher jobLauncher = 
                                (JobLauncher) context.getBean("jobLauncher");
		
        Job job = (Job)context.getBean("ExcelReaderJob");

	try{
            JobExecution execution = jobLauncher.run(job, new JobParameters());
                        
            System.out.println("Exit Status : " + execution.getStatus());
	}
        catch (Exception e) {	
               //  
               e.printStackTrace();
	}

	System.out.println("Done");

    }
    
}
