package com.work.entiy;

public class Student {
String studentid;
String sname;
String ssex;
Integer sage;

 public Student() {
	// TODO Auto-generated constructor stub
}

public String getStudentid() {
	return studentid;
}

public void setStudentid(String studentid) {
	this.studentid = studentid;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}

public String getSsex() {
	return ssex;
}

public void setSsex(String ssex) {
	this.ssex = ssex;
}

public Integer getSage() {
	return sage;
}

public void setSage(Integer sage) {
	this.sage = sage;
}


@Override
public String toString() {
	return "Student [studentid=" + studentid + ", sname=" + sname + ", ssex=" + ssex + ", sage=" + sage + "]";
}

public Student(String studentid, String sname, String ssex, Integer sage) {
	super();
	this.studentid = studentid;
	this.sname = sname;
	this.ssex = ssex;
	this.sage = sage;
}

}
