package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadEmployee {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library lb=new Library();
		
		lb.OpenApp("http://183.82.100.55/ranford2");
		lb.AdminLogin("Admin", "M1ndq");
		//To get Test Data File Path
		String Fpath="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Employee.txt";
		String sd;
		//Result File Path
		String Rpath="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Employee.txt";
		//To Get Test Data File
		FileReader fr=new FileReader(Fpath);
		BufferedReader br=new BufferedReader(fr);
		String Sread=br.readLine();
		System.out.println(Sread);
		//Write Header to Results
		FileWriter fw=new FileWriter(Rpath);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(Sread);
		bw.newLine();
		//Multiple Iterations
		//Loop
		
		while ((sd=br.readLine())!=null)
		{
			System.out.println(sd);
			//Split
			String sr[]=sd.split("###");
			String EmpName=sr[0];
			String LogPass=sr[1];
			String EmpRole=sr[2];
			String EmpBran=sr[3];
	
			String Res=lb.EmployeeCre(EmpName, LogPass, EmpRole, EmpBran);
			System.out.println(Res);
			//Result
			bw.write(sd+"$$$$"+Res);
			bw.newLine();
		}	
		bw.close();
		br.close();
		

	}

}
