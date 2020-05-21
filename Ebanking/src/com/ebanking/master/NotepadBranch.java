package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotepadBranch {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Library lb=new Library();
		
		lb.OpenApp("http://183.82.100.55/ranford2");
		lb.AdminLogin("Admin", "M1ndq");
		//To get Test Data File Path
		String Fpath="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\testdata\\Branch.txt";
		String sd;
		//Result File Path
		String Rpath="F:\\JAVA-SELENIUM\\Automation\\Ebanking\\src\\com\\ebanking\\result\\Res.Branch.txt";
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
			String BranchName=sr[0];
			String Address1=sr[1];
			String Address2=sr[2];
			String Address3=sr[3];
			String Area=sr[4];
			String Zip=sr[5];
			String Country=sr[6];
			String State=sr[7];
			String City=sr[8];
			String Res=lb.BranchCre(BranchName, Address1, Address2, Address3, Area, Zip, Country, State, City);
			System.out.println(Res);
			//Result
			bw.write(sd+"$$$$"+Res);
			bw.newLine();
		}	
		bw.close();
		br.close();

		

	}

}
