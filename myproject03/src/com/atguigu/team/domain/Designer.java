package com.atguigu.team.domain;

public class Designer extends Programmer {
	private double bonus;// 奖金

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	// 5 雷军 28 10000.0 设计师 FREE 5000.0 激光(佳能 2900)
	@Override
	public String toString() {
		return getDetais() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t设计师\t" + getBonus();
	}
}
