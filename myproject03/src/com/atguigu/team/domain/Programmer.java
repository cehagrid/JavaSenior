package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Programmer extends Employee {
	private int memberId;// 开发团队中的id
	private Status status = Status.FREE;// 空闲
	private Equipment equipment;

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
//	3	李彦宏	23	7000.0	程序员	FREE			戴尔(NEC17寸)
	public String toString() {
		return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}

	public String getTeamBaseDetails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t程序员";
	}

}
