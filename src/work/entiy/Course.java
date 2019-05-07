package com.work.entiy;

public class Course {
int c_id;
String cname;

public Course() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Course [c_id=" + c_id + ", cname=" + cname + "]";
}
public Course(int c_id, String cname) {
	super();
	this.c_id = c_id;
	this.cname = cname;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

}
